package com.quizapp.quiz_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class createquizDto {

    private String category;
    private Integer numOfQuestion;
    private String title;

}
