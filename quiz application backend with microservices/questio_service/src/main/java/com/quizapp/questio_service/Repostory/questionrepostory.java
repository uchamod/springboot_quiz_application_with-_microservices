package com.quizapp.questio_service.Repostory;


import com.quizapp.questio_service.Entity.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionrepostory extends JpaRepository<question,Integer> {
        public List<question> findByquizCatogery(String cat);
    @Query(value = "SELECT quiz_id FROM question  WHERE quiz_catogery=:cat ORDER BY RAND() LIMIT :numQ" ,nativeQuery = true)
    public List<Integer> findRandomQuizByCatogery(String cat, int numQ);



}
