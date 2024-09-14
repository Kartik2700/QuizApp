package com.QuizApp.Question_Service.Service;


import com.QuizApp.Question_Service.Model.QuestionWrapper;
import com.QuizApp.Question_Service.Model.Questions;
import com.QuizApp.Question_Service.Model.Response;
import com.QuizApp.Question_Service.Repository.QuestionRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Questions questions) {
        try {
            if (questionRepo.existsById(questions.getQuestionId())) {
                return new ResponseEntity<>("Question ID already exists", HttpStatus.CONFLICT);
            }
            questionRepo.save(questions);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Duplicate key error", HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, int numQues) {
        List<Integer> questions = questionRepo.findRandomQuestion(category,numQues);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>>getQuestionsById(List<Integer> questionsID) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
            List<Questions> question = new ArrayList<>();
        for(var qId:questionsID){
            question.add(questionRepo.findById(qId).get());
        }

        for(var q: question){
           QuestionWrapper wrapper = new QuestionWrapper();
           wrapper.setQuestionId(q.getQuestionId());
           wrapper.setQuestionTitle(q.getQuestionTitle());
           wrapper.setOption1(q.getOption1());
            wrapper.setOption2(q.getOption2());
            wrapper.setOption3(q.getOption3());
            wrapper.setOption4(q.getOption4());
            questionWrappers.add(wrapper);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score=0;
        for(var response: responses){
            Questions questions = questionRepo.findById(response.getId()).get();

            if(response.getAnswerSubmitByUser().equals(questions.getRightAnswer())) {
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
