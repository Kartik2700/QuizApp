package com.QuizApp.Question_Service.Repository;


import com.QuizApp.Question_Service.Model.Questions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    @Query(value= "SELECT  q.question_Id FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQues", nativeQuery = true)
    List<Integer> findRandomQuestion(String category, int numQues);

}
