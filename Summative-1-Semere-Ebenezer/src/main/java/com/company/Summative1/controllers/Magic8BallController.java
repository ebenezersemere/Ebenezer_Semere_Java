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

    private static List<Answer> answersList = new ArrayList<>(Arrays.asList(
            new Answer(index++, "Will I get a job at Netflix?", "Yes"),
            new Answer(index++, "Is today a good day to go to the beach?", "No"),
            new Answer(index++, "Should I move to California?", "Maybe"),
            new Answer(index++, "Will NFLX stock go up next month?", "Certainly"),
            new Answer(index++, "Am I the world's best dancer?", "Probably not"),
            new Answer(index++, "Could I eat 5,000 pieces of broccoli?", "0% chance")
    ));

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String addQuestion(@RequestBody String question) {
        Random random = new Random();
        int randomIndex = random.nextInt(answersList.size());
        return answersList.get(randomIndex).getAnswer();
    }

}
