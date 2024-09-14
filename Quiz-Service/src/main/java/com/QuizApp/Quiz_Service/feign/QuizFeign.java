package com.QuizApp.Quiz_Service.feign;

import com.QuizApp.Quiz_Service.Model.QuestionWrapper;
import com.QuizApp.Quiz_Service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam int numQues);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestions(@RequestBody List<Integer>questionsID);


    @PostMapping("question/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>response);
}
