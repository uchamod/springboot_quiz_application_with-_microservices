package com.quizapp.quiz_service.Controller;


import com.quizapp.quiz_service.DTO.createquizDto;
import com.quizapp.quiz_service.DTO.responsequiz;
import com.quizapp.quiz_service.DTO.submitresponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quizapp.quiz_service.Service.quizservice;
import java.util.List;

@RestController
@RequestMapping("/createdQuiz")
@AllArgsConstructor
public class quiz_controller {


    private quizservice quizservice;

    Environment environment;
    @PostMapping("/addnewquiz")
    public ResponseEntity createQuiz(@RequestBody createquizDto createquiz){
        return quizservice.createQuiz(createquiz.getCategory(),createquiz.getNumOfQuestion(),createquiz.getTitle());
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<responsequiz>> getCreatedQuiz(@PathVariable Integer id) {
        System.out.println(environment.getProperty("local.server.port"));

        return quizservice.getCreatedQuiz(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<submitresponse> response){
                System.out.println(environment.getProperty("local.server.port"));
               return quizservice.submitQuiz(id,response);
    }
}
