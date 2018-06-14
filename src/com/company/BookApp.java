package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {

    static ArrayList<Book> booksList = new ArrayList<>();
    static ArrayList<Book> booksList1= new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static DecimalFormat df = new DecimalFormat("0.00");


    public static void main(String[] args) throws IOException {

        BookDB bookDb = new BookDB();
        bookDb.setBooksList(populate());
        booksList = bookDb.getBooksList();
        /////////////////////////////////////////////////////////////////////////

        BookDB newBookDb = new BookDB("Java1002");
        booksList1=newBookDb.getBooksList();
        int listSize = booksList1.size();
        System.out.println(booksList1.get(listSize-1).getBookTitle());
        ///////////////////////////////////////////////////////////////////////////

        System.out.println("Welcome!! Look at the book List\n*************************");


        String answer = "y";
        while (!answer.equalsIgnoreCase("n")) {
            for (Book book : booksList) {
                System.out.println(book.getDisplayText());
                System.out.println("==============================");
            }

            System.out.println("Which book do you want to order? Please type the book SKU.");
            String sku = br.readLine();
                if (bookDb.isExistBook(sku)==true)
                {
                    System.out.println("How many books do you want to buy? ");
                    int orderQty;
                    orderQty = scanner.nextInt();
                    Book book = bookDb.findBook(sku);
                    while(book.getStockQty()<orderQty)
                    {
                        System.out.println("Sorry, the stock is only: "+book.getStockQty());
                        System.out.println("How many books do you want to buy? ");
                        orderQty = scanner.nextInt();
                    }
                    System.out.println("The price of this book is: $" + df.format(book.getTotalPrice(orderQty)));
                    System.out.println("Do you want to order another book<y/n>?");
                    answer = br.readLine();
                } else {
                    System.out.println("We don't have the book with the SKU. ");
                    System.out.println("Do you want to order a book<y/n>?");
                    answer = br.readLine();
                }
        }
    }

    public static ArrayList<Book> populate()
    {
        booksList.add(new Book("Java1001","Head First Java","Kathy Sierra and Bert Bates","Easy to read Java workbook",47.50,12));
        booksList.add(new Book("Java1002","Thinking in Java","Bruce Eckel","Details about Java under the hood",20,0));
        booksList.add(new Book("Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky","Everything you need to know in one place",45,3));
        booksList.add(new Book("Python1004","Automate the Boring Stuff with Python","Al Sweigart","Fun with Python",10.50,5));
        booksList.add(new Book("Zombie1005","The Maker's Guide to the Zombie Apocalypse","Simon Monk","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",16.50,3));
        booksList.add(new Book("Rasp1006","Raspberry Pi Projects for the Evil Genius","Donald Norris","A dozen fiendishly fun projects for the Raspberry Pi!",14.75,15));
        return booksList;
    }


}
