package com.company.Summative1.controllers;

import com.company.Summative1.models.Definition;
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
public class WordController {
    // database-mock index
    private static int index = 0;

    // in-memory word list
    private static List<Definition> wordList = new ArrayList<>(Arrays.asList(
            new Definition(++index, "Venerate", "To regard with great respect and admiration."),
            new Definition(++index, "Quixotic", "Extravagantly chivalrous or romantic."),
            new Definition(++index, "Serendipity", "The occurrence of fortunate events by chance."),
            new Definition(++index, "Sycophant", "A person who tries to please someone in order to gain an advantage."),
            new Definition(++index, "Surreptitious", "Kept secret, especially because it would not be approved of."),
            new Definition(++index, "Tantamount", "Equivalent in value or significance."),
            new Definition(++index, "Tawdry", "Cheap and showy but of poor quality."),
            new Definition(++index, "Tirade", "A long, angry speech of criticism or accusation."),
            new Definition(++index, "Tome", "A large and heavy book."),
            new Definition(++index, "Effervescence", "The production of bubbles; liveliness and excitement.")
    ));

    // GET /word route
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getDefinition() {
        // generate random word
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());

        return wordList.get(randomIndex);
    }

}
