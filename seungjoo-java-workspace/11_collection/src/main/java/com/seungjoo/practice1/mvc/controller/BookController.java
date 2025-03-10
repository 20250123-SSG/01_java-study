package com.seungjoo.practice1.mvc.controller;

import com.seungjoo.practice1.mvc.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private List<Book> bookList = new ArrayList<>();
    {    // 초기값 4개정도 추가
        bookList.add(new Book("자바언어의 정석", "홍길동", "기타", 20000));
        bookList.add(new Book("C언어의 보람", "김말똥", "기타", 15000));
        bookList.add(new Book("도움이 되었나요", "캥거루", "인문", 17500));
        bookList.add(new Book("여러분", "홍홍홍", "의료", 10000));
    }

    public void insertBook(String bookName,String author,String category,int price){
        Book book = new Book(bookName, author,category,price);
    }
    public List<Book> selectList() {
        return bookList;
    }

    public ArrayList<Book> searchBook(int num, String keyword) {
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : bookList){
            if(num == 1) {
                if (book.getTitle().contains(keyword)) {
                    books.add(book);
                }
            }else if(num == 2) {
                if(book.getAuthor().contains(keyword)) {
                    books.add(book);
                }
            }else if(num == 3) {
                if(book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                    books.add(book);
                }
            }
        }
        return books;
    }
    public boolean deleteBook(String bookName, String author) {
        boolean result = false;
        for(Book book : bookList){
            if(book.getTitle().equals(bookName) && book.getAuthor().equals(author)) {

                bookList.remove(book);
                result = true;
            }
        }
        return result;
    }

}
