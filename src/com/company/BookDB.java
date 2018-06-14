package com.company;

import java.util.ArrayList;

public class BookDB {

    static ArrayList<Book> booksList;

    //constructor without parameter
    public BookDB()
    {
        System.out.println("first constructor$$$$");
    }


    public BookDB(String sku)
    {

        Book book=findBook(sku);
       // System.out.println("####################%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%**");
        booksList.add(new Book(sku,book.getBookTitle(),book.getAuthor(),book.getDescription(),book.getPrice(),book.getStockQty()));
       // System.out.println("The book title!!!!!!"+book.getBookTitle());
    }


    public ArrayList<Book> getBooksList() {
        return booksList;
    }


    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public boolean isExistBook(String sku)
    {
        for (Book book : booksList) {
            if (book.getSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }

    public Book findBook(String sku)
    {
        for (Book book : booksList) {
            if (book.getSku().equalsIgnoreCase(sku)) {
                return book;
            }
        }
        return null;
    }

}
