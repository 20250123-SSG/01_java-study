package com.ino.practice1.mvc.controller;

import com.ino.practice1.mvc.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController{

    private List<Book> bookList = new ArrayList<>();
    {    // 초기값 4개정도 추가
        bookList.add(new Book("자바언어의 정석", "홍길동", "기타", 20000));
        bookList.add(new Book("C언어의 보람", "김말똥", "기타", 15000));
        bookList.add(new Book("도움이 되었나요", "캥거루", "인문", 17500));
        bookList.add(new Book("여러분", "홍홍홍", "의료", 10000));
    }

    public void insertBook(String bookName, String author, int genre, String price) {
        // 전달받은 값들을 가지고 Book객체 생성 후 bookList에 추가하기
        // (1:인문 / 2:자연과학 / 3:의료 / 4:기타)
        String category = "";
        switch (genre) {
            case 1: category = "인문"; break;
            case 2: category = "자연과학"; break;
            case 3: category = "의료"; break;
            case 4: category = "기타"; break;
        }
        Book b = new Book(bookName, author, category, Integer.parseInt(price));
        bookList.add(b);
        // * 유의사항
        // - Book객체 생성시에 category필드에는 장르번호가 아닌 장르명으로 기록되어야됨
        // - Book객체 생성시에 price필드에는 가격값이 숫자로 기록되어야됨
    }

    public List<Book> selectList(){
        // 도서객체들이 담겨있는 bookList 반환
        return bookList;
    }

    public List<Book> searchBook(int menu, String name){
        // 현재 bookList내의 도서들 가지고 전달된 키워드 값이 포함 되어있는 도서들을 반환하기
        // 이때 전달된 메뉴번호가 1일 경우 도서명에 포함되어있는지 비교하고,
        // 메뉴번호가 2일 경우 저자명에 포함되어있는지 비교하고,
        // 메뉴번호가 3일 경우 도서명 포함되어있거나, 저자명에 포함되어있는지 비교할 것
        List<Book> bList = new ArrayList<>();
        switch (menu) {
            case 1:
                for(Book b : bookList) {
                    if (b.getTitle().contains(name)) {
                        bList.add(b);
                    }
                }
                break;
            case 2:
                for(Book b : bookList) {
                    if (b.getAuthor().contains(name)) {
                        bList.add(b);
                    }
                }
                break;
            case 3:
                for(Book b : bookList) {
                    if (b.getTitle().contains(name) || b.getAuthor().contains(name)) {
                        bList.add(b);
                    }
                }
                break;
        }
        return bList;
    }

    public int deleteBook( String title, String author){
        Book book = null;
        for(Book b : bookList) {
            if (b.getAuthor().equals(author) && b.getTitle().equals(title)) {
                book = b;
            }
        }
        if (book == null) {
            return 0;
        }
        else {
            bookList.remove(book);
            return 1;
        }
        // 현재 도서들 중 전달된 도서명과 저자명이 일치하는 도서를 찾아 삭제하고
        // 성공여부 값을 1 또는 0으로 반환하기
    }
}
