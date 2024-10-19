package com.example.librarymanagmentsystem;

public class Movie {
    private String bookId, title, author, price,serialNo, name,category,status,cost,procurementDate;

    public Movie() {
    }

    public Movie(String bookId, String title, String author, String price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }
}
