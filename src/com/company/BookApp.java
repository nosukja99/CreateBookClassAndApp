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
        BookDB bookDb = new BookDB();
        booksList = bookDb.getBooksList();
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


}
