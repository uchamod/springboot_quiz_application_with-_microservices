package com.quizapp.questio_service.DTO;


import com.quizapp.questio_service.Entity.question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class responsedto {


    private String massage;


    private List<question> body;

}
