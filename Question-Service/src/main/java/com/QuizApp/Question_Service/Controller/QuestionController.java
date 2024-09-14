package com.QuizApp.Question_Service.Controller;


import com.QuizApp.Question_Service.Model.QuestionWrapper;
import com.QuizApp.Question_Service.Model.Questions;
import com.QuizApp.Question_Service.Model.Response;
import com.QuizApp.Question_Service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return questionService.addQuestion(questions);

    }
  @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category,@RequestParam int numQues){
            return questionService.getQuestionForQuiz(category,numQues);
  }

  @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestions(@RequestBody List<Integer>questionsID){
        return questionService.getQuestionsById(questionsID);
  }

  @PostMapping("getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>response){
        return questionService.getScore(response);
  }
}
