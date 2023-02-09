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
    // database-mock index
    private static int index = 0;

    // in-memory answer list
    private final List<String> answerBank = Arrays.asList(
            "Yes", "It is certain", "Without a doubt",
            "No", "My sources say no", "It is doubtful",
            "Try again", "It is not clear");

    // POST /magic route
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer addQuestion(@RequestBody Answer question) {
        // set id
        question.setId(++index);

        // generate random answer
        Random random = new Random();
        int randomIndex = random.nextInt(answerBank.size());
        question.setAnswer(answerBank.get(randomIndex));

        return question;
    }

}
