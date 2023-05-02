package org.homework;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Getter
@Setter
public class Quote {

    private int id;
    private final String author;
    private final String quote;
    private boolean favorite;

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public static List<Quote> setQuoteMap(String filePath) throws FileNotFoundException {

        List<Quote> quoteList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        int id = 1;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(Pattern.quote("~"));
            quoteList.add(new Quote(id, tokens[0], tokens[1]));
            id++;
        }
        return quoteList;
    }
}
