package com.jjanggu.practice1.mvc.controller;

import com.jjanggu.practice1.mvc.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> bookList = new ArrayList<>();
    {
     bookList.add(new Book("자바언어의 정석", "홍길동", "기타", 20000));
     bookList.add(new Book("C언어의 보람", "김말똥", "기타", 15000));
     bookList.add(new Book("도움이 되었나요", "캥거루", "인문", 17500));
     bookList.add(new Book("여러분", "홍홍홍", "의료", 10000));
    }

    public boolean insertBook(String title, String author, int category, String price){
        String categoryName = "";
        switch(category){
            case 1: categoryName = "인문"; break;
            case 2: categoryName = "자연과학"; break;
            case 3: categoryName = "의료"; break;
            case 4: categoryName = "기타"; break;
            default:
                System.out.println("잘못된 번호입니다.");
                return false;
        }
        int newPrice = Integer.parseInt(price) ; // string  => int

        boolean result = bookList.add(new Book(title, author, categoryName, newPrice));
        return result;
    }

    public List<Book> selectList(){

        return bookList;
    }

    public List<Book> searchBook(int menu, String keyword){
        List<Book> searchList = new ArrayList<>();

         switch(menu){
             case 1:
                 for(int i = 0; i < bookList.size(); i++){
                     if(bookList.get(i).getAuthor().contains(keyword)){
                         searchList.add( bookList.get(i) );
                     }
                 }return searchList;
             case 2:
                 for(int i = 0; i < bookList.size(); i++){
                     if(bookList.get(i).getAuthor().contains(keyword)){
                         searchList.add( bookList.get(i) );
                     }
                 }return searchList;
             case 3:
                 for(int i = 0; i < bookList.size(); i++){
                     if(bookList.get(i).getTitle().contains(keyword) || bookList.get(i).getAuthor().contains(keyword) ){
                         searchList.add( bookList.get(i) );
                     }
                 }return searchList;
         }

        return searchList;
    }

}
