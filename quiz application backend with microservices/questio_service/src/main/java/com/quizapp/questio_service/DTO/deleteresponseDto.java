package com.quizapp.questio_service.DTO;

import com.quizapp.questio_service.Entity.question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class deleteresponseDto {

    private String massage;
    private Optional<question> question;
}
