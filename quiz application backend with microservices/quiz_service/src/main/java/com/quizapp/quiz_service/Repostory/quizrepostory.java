package com.quizapp.quiz_service.Repostory;


import com.quizapp.quiz_service.Entity.quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quizrepostory extends JpaRepository<quiz,Integer> {
}
