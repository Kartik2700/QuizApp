package com.QuizApp.Quiz_Service.Controller;


import com.QuizApp.Quiz_Service.Model.QuestionWrapper;
import com.QuizApp.Quiz_Service.Model.QuizDTO;
import com.QuizApp.Quiz_Service.Model.Response;
import com.QuizApp.Quiz_Service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
     private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){

        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNumQues(),quizDTO.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
        return quizService.getQuizQuestion(id) ;
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.calculateAnswer(id,response) ;
    }


}
