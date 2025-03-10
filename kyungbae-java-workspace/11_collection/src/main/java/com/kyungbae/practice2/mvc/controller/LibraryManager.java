package com.kyungbae.practice2.mvc.controller;

import com.kyungbae.practice2.mvc.dto.AniBook;
import com.kyungbae.practice2.mvc.dto.Book;
import com.kyungbae.practice2.mvc.dto.CookBook;
import com.kyungbae.practice2.mvc.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private Member mem = null;
    private List<Book> bookList = new ArrayList<>();
    { // 초기화 블록을 이용하여 샘플 데이터 초기화
        bookList.add(new CookBook("백종원의 집밥", "백종원", "tvN", true));
        bookList.add(new AniBook("한번 더 해요", "미티", "원모어", 19));
        bookList.add(new AniBook("루피의 원피스", "루피", "japan", 12));
        bookList.add(new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false));
        bookList.add(new CookBook("최현석 날 따라해봐", "최현석", "소금책", true));
    }

    public void insertMember(Member mem){
        this.mem = mem;
    }

    public Member getMem(){
        return mem;
    }

    public void updateMember(Member mem){
        this.mem.setName(mem.getName());
        this.mem.setAge(mem.getAge());
        this.mem.setGender(mem.getGender());
    }

    public List<Book> selectAll(){
        return bookList;
    }

    public List<Book> searchBook(String keyword){
        List<Book> books = new ArrayList<>();
        for(Book book : bookList){
            if (book.getTitle().contains(keyword)) {
                books.add(book);
            }
        }
        return books;
    }

    public int rentBook(int num){
        int result = 0;
        if (bookList.get(num).getClass() == AniBook.class) {
            AniBook ani = (AniBook) bookList.get(num);
            if (mem.getAge() < ani.getAccessAge()) {
                result = 1;
            }
        } else if (bookList.get(num).getClass() == CookBook.class) {
            CookBook cook = (CookBook) bookList.get(num);
            if (cook.isCoupon()) {
                mem.setCouponCount(mem.getCouponCount() + 1);
                result = 2;
            }
        }
        return result;
    }



}
