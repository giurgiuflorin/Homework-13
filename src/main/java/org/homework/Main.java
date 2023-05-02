package org.homework;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<Quote> quoteList = Quote.setQuoteMap("file/quotes.txt");

        //creati un obiect QuoteService care primeste (in constructor) o lista de Quote si ofera urmatoarele metode:
        QuoteService quoteService = new QuoteService(quoteList);

        //getAllQuotes():List<String>
        quoteService.getAllQuotes();

        //getQuotesForAuthor(String author):List<Quote>
        quoteService.getQuotesFromAuthor("Buddha");

        //getAuthors(): List<String> (distinct)
        System.out.println(quoteService.getAuthors());

        //setFavourite(int id)
        quoteService.setFavorite(444);
        quoteService.setFavorite(19);

//        //getFavourites():List<Quote>
        System.out.println(quoteService.getFavorites());
//
//        //getRandomQuote():String : generati un numar random cu ajutorul
//        // obiectului java.util.Random si returnati quote-ul cu acel id
        System.out.println(quoteService.getRandomQuote());








    }

}