package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {

    static ArrayList<Book> booksList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static DecimalFormat df = new DecimalFormat("0.00");


    public static void main(String[] args) throws IOException {
        makeList();
        String answer = "y";
        while (!answer.equalsIgnoreCase("n")) {
            for (Book book : booksList) {
                System.out.println(book.getDisplayText());
                System.out.println("==============================");
            }

            System.out.println("Which book do you want to order? Please type the book title.");
            String bookTitle = br.readLine();
                if (isExistList(bookTitle)==true)
                {
                    System.out.println("How many books do you want to buy? ");
                    int orderQty;
                    orderQty = scanner.nextInt();
                    Book book = findBook(bookTitle);
                    while(book.getStockQty()<orderQty)
                    {
                        System.out.println("Sorry, the stock is only: "+book.getStockQty());
                        System.out.println("How many books do you want to buy? ");
                        orderQty = scanner.nextInt();
                    }
                    System.out.println("The price of this book is: " + df.format(book.getTotalPrice(orderQty)));
                    System.out.println("Do you want to order another book<y/n>?");
                    answer = br.readLine();
                } else {
                    System.out.println("We don't have the book with the title. ");
                    System.out.println("Do you want to order a book<y/n>?");
                    answer = br.readLine();
                }
        }
    }

    public static boolean isExistList(String bookTitle)
    {
        for (Book book : booksList) {
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                return true;
            }
        }
        return false;
    }

    public static void makeList()
    {
        Book book1 = new Book("Train Your Dragon To Be Kind", "Steve Herman",
                "A Dragon Book To Teach Children About Kindness",12.95, 10);
        Book book2 = new Book("Giraffes Can't Dance","Giles Andreae", "The bestselling Giraffes Can't Dance is now a board book!",
                5.06, 2 );
        Book book3 = new Book("Just Me and My Dad","Mercer Mayer",
                "Mercer Mayer’s Little Critter is going on a camping.", 2.81, 1);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
    }

    public static Book findBook(String bookTitle) {
        for (Book book : booksList)
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
            return null;
    }

}
