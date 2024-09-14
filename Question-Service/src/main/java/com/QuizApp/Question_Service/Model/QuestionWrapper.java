package com.QuizApp.Question_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data@Entity@AllArgsConstructor@NoArgsConstructor@Component
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
