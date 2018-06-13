package com.company;

public class Book {
    String bookTitle;
    String author;
    String description;
    double price;
    boolean isInStock;

    public Book()
    {

    }

    public Book(String bookTitle, String author, String description, double price, boolean isInStock)
    {
        this.bookTitle=bookTitle;
        this.author=author;
        this.description=description;
        this.price=price;
        this.isInStock=isInStock;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public String getDisplayText()
    {
        String display = "The author: "+author+"\nThe title: "+bookTitle
                +"\nThis book is: "+description;
        return display;
    }

}
