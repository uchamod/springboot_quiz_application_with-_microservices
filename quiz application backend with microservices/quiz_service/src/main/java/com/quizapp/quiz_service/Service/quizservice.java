package com.quizapp.quiz_service.Service;


import com.quizapp.quiz_service.DTO.responsequiz;
import com.quizapp.quiz_service.DTO.submitresponse;

import com.quizapp.quiz_service.Entity.quiz;
import com.quizapp.quiz_service.Fieng.fieng_repostory;
import com.quizapp.quiz_service.Repostory.quizrepostory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class quizservice {

    private quizrepostory  quizrepostory;

   private fieng_repostory fiengrepo;



   //request question service to create a quiz nad the result save in quiz db
    public ResponseEntity createQuiz(String cat, int numQ, String title) {
           List<Integer> questionIds = fiengrepo.getQuestionForQuiz(cat,numQ).getBody();//get question ids
          quiz quiz =new quiz();
          quiz.setTitle(title);
          quiz.setQuestionIds(questionIds);
          quizrepostory.save(quiz);  //save the quiz
          return new ResponseEntity<>("quiz is created",HttpStatus.OK);
    }

    //request qusetion service to get the created wrappper qusetion according to quiz id
    public ResponseEntity<List<responsequiz>> getCreatedQuiz(Integer id) {
                List<Integer> questionIds=quizrepostory.findById(id).get().getQuestionIds(); //get the quiz questions
                return fiengrepo.sendWrapperQuestionForQuiz(questionIds);  //return the wrapper questions

     }
    //request question service to calculate the score
    public Integer submitQuiz(Integer id,List<submitresponse> responses){
       return fiengrepo.calculateQuizScore(responses); //return the score


        }






}
