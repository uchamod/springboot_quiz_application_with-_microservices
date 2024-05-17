package com.quizapp.quiz_service.Fieng;

import com.quizapp.quiz_service.DTO.responsequiz;
import com.quizapp.quiz_service.DTO.submitresponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
//config as a feing client and make it to acsses to the question service via eureka client
@FeignClient("QUESTION-SERVICE")
public interface fieng_repostory {

    //define the methods that allows to quiz serviceto accsess from the question service
    @GetMapping("quiz/getQuestionForQuiz")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String cat, @RequestParam Integer numQ);

    //get quetions for the quiz according to format
    @PostMapping("quiz/sendWrapperQuestionForQuiz")
    public ResponseEntity<List<responsequiz>> sendWrapperQuestionForQuiz(@RequestBody List<Integer> questionIds);

    @PostMapping("quiz/calculateQuizScore")
    public Integer calculateQuizScore(@RequestBody List<submitresponse> responses);


}
