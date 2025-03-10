package com.minkook.practice2.mvc.dto;

public  class Book {
    private String title;
    private String author;
    private String pupblisher;

    public Book() {
    }

    public Book(String title, String author, String pupblisher) {
        this.title = title;
        this.author = author;
        this.pupblisher = pupblisher;
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

    public String getPupblisher() {
        return pupblisher;
    }

    public void setPupblisher(String pupblisher) {
        this.pupblisher = pupblisher;
    }

    @Override
    public String toString() {
        return title + "/" + author + "/" + pupblisher + "/";
    }
}
