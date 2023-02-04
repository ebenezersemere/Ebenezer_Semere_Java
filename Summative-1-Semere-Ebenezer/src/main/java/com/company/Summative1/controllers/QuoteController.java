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
    private static int index = 0;
    List<Quote> quoteList = new ArrayList<>(Arrays.asList(
            new Quote(index++, "The purpose of our lives is to be happy.", "Dalai Lama"),
            new Quote(index++, "Life is what happens when you're busy making other plans.", "John Lennon"),
            new Quote(index++, "Get busy living or get busy dying.", "Stephen King"),
            new Quote(index++, "You only live once, but if you do it right, once is enough.", "Mae West"),
            new Quote(index++, "The only way to do great work is to love what you do.", "Steve Jobs"),
            new Quote(index++, "If you want to live a happy life, tie it to a goal, not to people or things.", "Albert Einstein"),
            new Quote(index++, "Never let the fear of striking out keep you from playing the game.", "Babe Ruth"),
            new Quote(index++, "Money and success don't change people; they merely amplify what is already there.", "Will Smith"),
            new Quote(index++, "The two most important days in your life are the day you are born and the day you find out why.", "Mark Twain"),
            new Quote(index++, "Whatever you can do, or dream you can, begin it. Boldness has genius, power and magic in it.", "Johann Wolfgang von Goethe")
    ));

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){
        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.size());
        return quoteList.get(randomIndex);
    }



}
