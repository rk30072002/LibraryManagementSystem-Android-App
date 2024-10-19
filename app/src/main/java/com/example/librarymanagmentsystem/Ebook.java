package com.example.librarymanagmentsystem;

public class Ebook {
    String ebookId, title, author;
    public Ebook() {
    }

    public Ebook(String ebookId, String title, String author) {
        this.ebookId = ebookId;
        this.title = title;
        this.author = author;
    }
    public String getEbookId() {
        return ebookId;
    }

    public void setEbookId(String ebookId) {
        this.ebookId = ebookId;
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
}
