package com.quizapp.questio_service.Controller;


import com.quizapp.questio_service.DTO.responsedto;
import com.quizapp.questio_service.DTO.responsequiz;
import com.quizapp.questio_service.DTO.submitresponse;
import com.quizapp.questio_service.Entity.question;
import com.quizapp.questio_service.Service.questionservice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
public class qyestion_controller {

    private questionservice service;
    @GetMapping("/getquestions")
    public ResponseEntity<responsedto> getAllQuiz() {
        return service.getAllQuiz();
    }
    @GetMapping("/getquizbycategory/{cat}")
    public ResponseEntity<responsedto> getAllByCatogery(@PathVariable String cat) {
        return service.getAllByCatogery(cat);
    }

    @PostMapping("/addquizes")
    public ResponseEntity<responsedto> saveQuiz(@RequestBody question quiz){

        return service.saveQuiz(quiz);
    }

    @PutMapping("/updatequiz")
    public ResponseEntity<responsedto> updateQuiz(@RequestBody question question){
       return service.updateQuiz(question);
    }

    @DeleteMapping("/deletequiz")
    public String deleteQuiz(@RequestBody question question){

        return service.deleteQuiz(question);
    }

    //generate quetion according to quiz_service request
    @GetMapping("/getQuestionForQuiz")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String cat,@RequestParam Integer numQ){
       return service.getQuestionForQuiz(cat,numQ);
    }

    //get quetions for the quiz according to format
    @PostMapping("/sendWrapperQuestionForQuiz")
    public ResponseEntity<List<responsequiz>> sendWrapperQuestionForQuiz(@RequestBody List<Integer> questionIds){
        return service.sendWrapperQuestionForQuiz(questionIds);
    }

    @PostMapping("/calculateQuizScore")
    public Integer calculateQuizScore(@RequestBody List<submitresponse> responses){
        return service.calculateQuizScore(responses);
    }
    //getScore

}
