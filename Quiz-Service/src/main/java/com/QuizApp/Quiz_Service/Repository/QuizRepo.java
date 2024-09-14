package com.QuizApp.Quiz_Service.Repository;


import com.QuizApp.Quiz_Service.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
