package com.quizapp.questio_service.Service;


import com.quizapp.questio_service.DTO.deleteresponseDto;
import com.quizapp.questio_service.DTO.responsedto;
import com.quizapp.questio_service.DTO.responsequiz;
import com.quizapp.questio_service.DTO.submitresponse;
import com.quizapp.questio_service.Entity.question;
import com.quizapp.questio_service.Repostory.questionrepostory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class questionservice {

    private questionrepostory repo;


    public ResponseEntity<responsedto> getAllQuiz() {
        try {
            List<question> quizes = repo.findAll();
            if (quizes.isEmpty()) {
                responsedto response = new responsedto("no quiz found", quizes);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                responsedto response = new responsedto("quiz found", quizes);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            responsedto response=new responsedto("unexpected error",null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    public ResponseEntity<responsedto> getAllByCatogery(String cat) {
        try {
            List<question> quizes = repo.findByquizCatogery(cat);
        if (quizes.isEmpty()) {
            responsedto response = new responsedto("no quiz found", quizes);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else {
            responsedto response = new responsedto("quiz found", quizes);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    } catch (Exception e) {
            responsedto response=new responsedto("unexpected error",null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    }

    public ResponseEntity<responsedto> saveQuiz(question quiz) {
        try{
            if (repo.existsById(quiz.getQuizId())) {
                responsedto response=new responsedto("quiz already exists",null);
                return  ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(response);
            }else{
                repo.save(quiz);
                responsedto response=new responsedto("quiz is saved",null);
                return  ResponseEntity.status(HttpStatus.CREATED).body(response);
            }


        } catch(Exception e){
            responsedto response=new responsedto("unexpected error",null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        }

    public ResponseEntity<responsedto> updateQuiz(question question) {
            try{
                if(repo.existsById(question.getQuizId())){
                    repo.save(question);
                    responsedto response=new responsedto("question is updated",null);
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }else{
                    responsedto response=new responsedto("question is not updated:check qusetion details and try agin",null);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                }
            }catch (Exception  e){
                responsedto response=new responsedto("unexpected error "+e,null);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
    }

    public String deleteQuiz(question question) {
        try{
            if(repo.existsById(question.getQuizId())){
                repo.delete(question);
               // deleteresponseDto response=new  deleteresponseDto("question is deleted",null);
               // return ResponseEntity.status(HttpStatus.OK).body(response);
                return "delete sucssus";
            }else{
                deleteresponseDto response=new  deleteresponseDto("question is not deleted",null);
                //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                return "delete not sucssus";
            }
        }catch (Exception e){
            deleteresponseDto response=new  deleteresponseDto("unexpected error"+e,null);
           // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            return "reeor";
        }
    }


    //method for get qustions according to question catogery and the question numbers
    public ResponseEntity<List<Integer>> getQuestionForQuiz(String cat, Integer numQ) {
        List<Integer> quizIds=repo.findRandomQuizByCatogery(cat,numQ);
        return new ResponseEntity<>(quizIds,HttpStatus.OK);
    }

    //method for send the created question according to certifide format
    public ResponseEntity<List<responsequiz>> sendWrapperQuestionForQuiz(List<Integer> questionIds) {
        List<responsequiz> responsequizs=new ArrayList<>();
        for(Integer id:questionIds){
            question question=repo.findById(id).get();
            responsequiz responsequiz=new responsequiz();
            responsequiz.setQuizCatogery(question.getQuizCatogery());
            responsequiz.setQuizId(question.getQuizId());
            responsequiz.setQuizTitle(question.getQuizTitle());
            responsequiz.setOption1(question.getOption1());
            responsequiz.setOption2(question.getOption2());
            responsequiz.setOption3(question.getOption3());
            responsequiz.setOption4(question.getOption4());
            responsequizs.add(responsequiz);

        }
        return new ResponseEntity<>(responsequizs,HttpStatus.OK);
    }

    //calcule and submit the score for the quiz
    public Integer calculateQuizScore(List<submitresponse> responses) {

        Integer right=0;
        for(submitresponse response : responses){
            question question=repo.findById(response.getQuizId()).get();
            if(response.getResponse().equals(question.getRightAnswer())){
                right++;
            }

        }
        return right;
    }
}


