package com.QuizApp.Quiz_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data@NoArgsConstructor@AllArgsConstructor
public class Response{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answerSubmitByUser;
}
