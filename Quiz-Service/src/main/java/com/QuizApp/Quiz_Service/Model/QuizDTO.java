package com.QuizApp.Quiz_Service.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class QuizDTO {
    String category;
    int numQues;String title;
}
