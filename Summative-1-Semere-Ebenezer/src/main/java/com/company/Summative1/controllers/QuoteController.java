package com.company.Summative1.controllers;

import com.company.Summative1.models.Answer;
import com.company.Summative1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    // database-mock index
    private static int index = 0;

    // in-memory quote list
    List<Quote> quoteList = new ArrayList<>(Arrays.asList(
            new Quote(++index, "Dalai Lama", "The purpose of our lives is to be happy."),
            new Quote(++index, "John Lennon", "Life is what happens when you're busy making other plans."),
            new Quote(++index, "Stephen King", "Get busy living or get busy dying."),
            new Quote(++index, "Mae West", "You only live once, but if you do it right, once is enough."),
            new Quote(++index, "Steve Jobs", "The only way to do great work is to love what you do."),
            new Quote(++index, "Albert Einstein", "If you want to live a happy life, tie it to a goal, not to people or things."),
            new Quote(++index, "Babe Ruth", "Never let the fear of striking out keep you from playing the game."),
            new Quote(++index, "Will Smith", "Money and success don't change people; they merely amplify what is already there."),
            new Quote(++index, "Mark Twain", "The two most important days in your life are the day you are born and the day you find out why."),
            new Quote(++index, "Johann Wolfgang von Goethe", "Whatever you can do, or dream you can, begin it. Boldness has genius, power and magic in it.")
    ));

    // GET /quote route
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){
        // generate random quote
        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.size());

        return quoteList.get(randomIndex);
    }



}
