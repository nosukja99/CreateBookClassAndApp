package com.company;

public class Book {
    String bookTitle;
    String author;
    String description;
    double price;
    int stockQty;
    String sku;



    public Book()
    {

    }


    public Book(String sku, String bookTitle, String author, String description, double price, int stockQty)
    {
        this.bookTitle=bookTitle;
        this.author=author;
        this.description=description;
        this.price=price;
        this.stockQty=stockQty;
        this.sku=sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public String getDisplayText()
    {
        String display ="The SKU: "+sku+"\nThe author: "+author+"\nThe title: "+bookTitle
                +"\nThis book is: "+description+"\nThe Price: "+price;
        return display;
    }

    public double getTotalPrice(int orderQty)
    {
        double eachTotalPrice = price*orderQty;
        return eachTotalPrice;
    }


}
