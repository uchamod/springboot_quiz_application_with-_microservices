package com.quizapp.questio_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class responsequiz {

    private Integer quizId;
    private String quizTitle;
    private String quizCatogery;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
