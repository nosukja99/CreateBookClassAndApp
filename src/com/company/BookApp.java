package com.company;

import java.util.ArrayList;

public class BookApp {

    public static void main(String[] args)
    {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Train Your Dragon To Be Kind", "Steve Herman",
                "A Dragon Book To Teach Children About Kindness",12.95, true);
        Book book2 = new Book("Giraffes Can't Dance","Giles Andreae", "The bestselling Giraffes Can't Dance is now a board book!",
                5.06, false );
        Book book3 = new Book("Just Me and My Dad","Mercer Mayer",
                "Mercer Mayer’s Little Critter is going on a camping.", 2.81, true );

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);

        for(Book book : booksList)
        {
            System.out.println(book.getDisplayText());
            System.out.println("==============================");
        }







    }

}
