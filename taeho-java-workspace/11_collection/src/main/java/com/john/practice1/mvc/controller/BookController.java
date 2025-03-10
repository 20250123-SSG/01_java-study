package com.john.practice1.mvc.controller;

import com.john.practice1.mvc.dto.Book;

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

    // category 값에 따른 categoryName 반환메서드
    public String checkCategory(int category) {
        String categoryName;
        if (category == 1) {
            categoryName = "인문";
        } else if (category == 2) {
            categoryName = "자연과학";
        } else if (category == 3) {
            categoryName = "의료";
        } else {
            categoryName = "기타";
        }
        return categoryName;
    }

    public void insertBook(String title, String author, int category, String price) {
        // 전달받은 값들을 가지고 Book객체 생성 후 bookList에 추가하기
        // * 유의사항
        // - Book객체 생성시에 category필드에는 장르번호가 아닌 장르명으로 기록되어야됨
        // - Book객체 생성시에 price필드에는 가격값이 숫자로 기록되어야됨
        String categoryName = checkCategory(category);
        int intPrice = Integer.parseInt(price);
        Book book = new Book(title, author, categoryName, intPrice);
    }

    public List<Book> selectList() {
        // 도서객체들이 담겨있는 bookList 반환
        return this.bookList;
    }

    public List<Book> searchBook(int menu, String keyword) {
        // 현재 bookList내의 도서들 가지고 전달된 키워드 값이 포함 되어있는 도서들을 반환하기
        // 이때 전달된 메뉴번호가 1일 경우 도서명에 포함되어있는지 비교하고,
        // 메뉴번호가 2일 경우 저자명에 포함되어있는지 비교하고,
        // 메뉴번호가 3일 경우 도서명 포함되어있거나, 저자명에 포함되어있는지 비교할 것

        List<Book> books = new ArrayList<>();
        switch (menu) {
            case 1:
                for (Book book : bookList) {
                    if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                        books.add(book);
                    }
                }
                break;
            case 2:
                for (Book book : bookList) {
                    if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                        books.add(book);
                    }
                }
                break;
            case 3:
                for (Book book : bookList) {
                    if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                            || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                        books.add(book);
                    }
                }
                break;
        }
        return books;
    }

    public int deleteBook(String title, String author) {
        // 현재 도서들 중 전달된 도서명과 저자명이 일치하는 도서를 찾아 삭제하고
        // 성공여부 값을 1 또는 0으로 반환하기
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
                if (bookList.get(i).getAuthor().equals(author.toLowerCase())) {
                    return 1;
                }
            }
        }
        return 0;
    }
}