package com.minkook.practice1.mvc.controller;

import com.minkook.practice1.mvc.dto.Book;

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

    public void insertBook(String title,String author, int genresNum, int price) {
        //장르번호 (1:인문 / 2:자연과학 / 3:의료 / 4:기타)
        String category = "";
        if(genresNum == 1){
            category = "인문";
        }else if(genresNum == 2){
            category = "자연과학";
        }else if(genresNum == 3) {
            category = "의료";
        }else{
            category = "기타";
        }
        bookList.add(new Book(title,author,category,price));
        // 전달받은 값들을 가지고 Book객체 생성 후 bookList에 추가하기
        // * 유의사항
        // - Book객체 생성시에 category필드에는 장르번호가 아닌 장르명으로 기록되어야됨
        // - Book객체 생성시에 price필드에는 가격값이 숫자로 기록되어야됨
    }

    public List<Book> selectList(){
        // 도서객체들이 담겨있는 bookList 반환
        return bookList;
    }

    public List<Book> searchBook(int menu,String keyword) {
        // 현재 bookList내의 도서들 가지고 전달된 키워드 값이 포함 되어있는 도서들을 반환하기
        // 이때 전달된 메뉴번호가 1일 경우 도서명에 포함되어있는지 비교하고,
        // 메뉴번호가 2일 경우 저자명에 포함되어있는지 비교하고,
        // 메뉴번호가 3일 경우 도서명 포함되어있거나, 저자명에 포함되어있는지 비교할 것
        List<Book> searchBookList = new ArrayList<>();
        if(menu == 1){
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getTitle().contains(keyword)) {
                    searchBookList.add(bookList.get(i));
                }
            }
        }else if(menu == 2){
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getAuthor().contains(keyword)) {
                    searchBookList.add(bookList.get(i));
                }
            }
        }else if(menu == 3){
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getTitle().contains(keyword) || bookList.get(i).getAuthor().contains(keyword)) {
                    searchBookList.add(bookList.get(i));
                }
            }
        }
        return searchBookList;

    }

    public int deleteBook(String title,String author){
        // 현재 도서들 중 전달된 도서명과 저자명이 일치하는 도서를 찾아 삭제하고
        // 성공여부 값을 1 또는 0으로 반환하기
        int count = 0;
        for(int i = 0; i<bookList.size(); i++){
            if(bookList.get(i).getTitle().equals(title) && bookList.get(i).getAuthor().equals(author)){
                bookList.remove(i);
                count = 1;
            }
        }
        return  count;
    }
}