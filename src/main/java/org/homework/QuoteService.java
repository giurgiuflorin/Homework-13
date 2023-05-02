package org.homework;

import java.util.*;

public class QuoteService {

    private List<Quote> qList;

    public QuoteService(List<Quote> qList) {
        this.qList = qList;
    }

    public List<String> getAllQuotes() {

        List<String> quoteStringList = new ArrayList<>();
        for (Quote q : qList) {
            quoteStringList.add(q.getQuote());
            System.out.println(q.getQuote());
        }

        return quoteStringList;
    }

    public List<String> getQuotesFromAuthor(String author) {


        List<String> authorQuotes = new ArrayList<>();
        boolean authorWasFound = false;
        for (Quote q : qList) {
            if (q.getAuthor().equals(author)) {
                authorQuotes.add(q.getQuote());
                authorWasFound = true;
                System.out.println(q.getQuote());
            }
        }
        if (authorWasFound == false) {
            throw new RuntimeException(author + " was not found!");
        }
        return authorQuotes;
    }

    public List<String> getAuthors() {

        Set<String> authors = new HashSet<>();

        for (Quote q : qList) {
           authors.add(q.getAuthor());
        }
        return new ArrayList<>(authors);
    }

    public void setFavorite(int id) {

        for (Quote q : qList) {
            if (id <0 || id >= qList.size()) {
                throw new RuntimeException("Your ID[" + id + "] is out of bounds." +
                        "Please enter a value between 0 and " + (qList.size() - 1));
            }
            if (q.getId() == id) {
                q.setFavorite(true);
            }
        }
    }

    public List<String> getFavorites() {

        List<String> favorites = new ArrayList<>();
        for (Quote q : qList) {
            if (q.isFavorite() == true) {
                favorites.add(q.getQuote());
            }
        }
        return favorites;
    }

    public String getRandomQuote() {

        Random random = new Random();
        int randomInt = random.nextInt(qList.size());
        String randomQuote = null;

        for (Quote q : qList) {
            if (q.getId() == randomInt) {
                randomQuote = q.getQuote();
            }
        }
        System.out.println("Here is your random quote[ID: " + randomInt + "]");
        return randomQuote;
    }
}
