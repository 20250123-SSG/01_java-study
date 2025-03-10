package com.kyungbae.practice1.mvc.cotroller;

import com.kyungbae.practice1.mvc.dto.Book;

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

    public int insertBook(String title, String author, int category, String price){
        int work = 0;
        int intPrice = Integer.parseInt(price);
        String strCategory = null;
        switch (category) {
            case 1 : strCategory = "인문"; work++; break;
            case 2 : strCategory = "자연과학"; work++; break;
            case 3 : strCategory = "의료"; work++; break;
            case 4 : strCategory = "기타"; work++; break;
        }
        bookList.add(new Book(title, author, strCategory, intPrice));

        return work;
    }

    public List<Book> selectList() {
        return bookList;
    }

    public List<Book> searchBook(int menu, String input){
        List<Book> list = new ArrayList<>();
        if(menu == 1){
            for (Book b : bookList) {
                if (b.getTitle().contains(input)) {
                    list.add(b);
                }
            }
        } else if (menu == 2) {
            for(Book b : bookList){
                if(b.getAuthor().contains(input)){
                    list.add(b);
                }
            }
        } else if (menu == 3) {
            for(Book b : bookList){
                if(b.getTitle().contains(input) || b.getAuthor().contains(input)){
                    list.add(b);
                }
            }
        }
        return list;
    } // searchBook end

    public int deleteBook(String title, String author) {
        int result = 0;
//        for (int i = 0; i < bookList.size(); i++) {
//            if (bookList.get(i).getTitle().equals(title)
//                    && bookList.get(i).getAuthor().equals(author)) {
//                bookList.remove(i);
//                result++;
//                break;
//            }
//
//        }
        for (Book b : bookList){
            if (b.getTitle().equals(title) && b.getAuthor().equals(author)){
                bookList.remove(b);
                result++;
                break;
            }
        }
        return result;
    }



}
