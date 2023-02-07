package com.company.Summative1.controllers;

import com.company.Summative1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8BallController {
    private static int index = 0;

    // generate answer list
    private final List<String> answerBank = Arrays.asList("Yes", "No", "It is certain", "My sources say no", "It is doubtful", "Without a doubt", "Try again", "It is not clear");

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer addQuestion(@RequestBody Answer question) {
        question.setId(++index);

        Random random = new Random();
        int randomIndex = random.nextInt(answerBank.size());
        question.setAnswer(answerBank.get(randomIndex));

        return question;
    }

}
