package com.quizapp.quiz_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class submitresponse {

    private Integer quizId;
    private String response;

}
