package com.company;

import java.util.ArrayList;

public class BookDB {

    static ArrayList<Book> booksList = new ArrayList<>();

    public BookDB()
    {
        booksList.add(new Book("Java1001","Head First Java","Kathy Sierra and Bert Bates","Easy to read Java workbook",47.50,12));
        booksList.add(new Book("Java1002","Thinking in Java","Bruce Eckel","Details about Java under the hood",20,0));
        booksList.add(new Book("Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky","Everything you need to know in one place",45,3));
        booksList.add(new Book("Python1004","Automate the Boring Stuff with Python","Al Sweigart","Fun with Python",10.50,5));
        booksList.add(new Book("Zombie1005","The Maker's Guide to the Zombie Apocalypse","Simon Monk","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",16.50,3));
        booksList.add(new Book("Rasp1006","Raspberry Pi Projects for the Evil Genius","Donald Norris","A dozen fiendishly fun projects for the Raspberry Pi!",14.75,15));
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public static boolean isExistBook(String sku)
    {
        for (Book book : booksList) {
            if (book.getSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }

    public static Book findBook(String sku)
    {
        for (Book book : booksList) {
            if (book.getSku().equalsIgnoreCase(sku)) {
                return book;
            }
        }
        return null;
    }

}
