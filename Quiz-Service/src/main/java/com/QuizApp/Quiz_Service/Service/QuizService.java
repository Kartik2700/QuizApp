package com.QuizApp.Quiz_Service.Service;


import com.QuizApp.Quiz_Service.Model.QuestionWrapper;
import com.QuizApp.Quiz_Service.Model.Quiz;
import com.QuizApp.Quiz_Service.Model.Response;
import com.QuizApp.Quiz_Service.Repository.QuizRepo;
import com.QuizApp.Quiz_Service.feign.QuizFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuizFeign quizFeign;

    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {
        List<Integer> questions = quizFeign.generateQuestions(category, numQues).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Integer> questIds = quiz.get().getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questionForUser = quizFeign.getQuestions(questIds);
        return questionForUser;
    }

    public ResponseEntity<Integer> calculateAnswer(int id, List<Response> responses) {
        ResponseEntity<Integer>score = quizFeign.getScore(responses);
        return score;
    }
}
