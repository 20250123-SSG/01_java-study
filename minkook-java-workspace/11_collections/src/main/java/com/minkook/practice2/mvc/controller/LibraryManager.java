package com.minkook.practice2.mvc.controller;



import com.minkook.practice2.mvc.dto.AniBook;
import com.minkook.practice2.mvc.dto.Book;
import com.minkook.practice2.mvc.dto.CookBook;
import com.minkook.practice2.mvc.dto.Member;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager{

    private Member mem = null;
    private List<Book> bookList = new ArrayList<>();

    { // 초기화 블록을 이용하여 샘플 데이터 초기화
        bookList.add(new CookBook("백종원의 집밥", "백종원", "tvN", true));
        bookList.add(new AniBook("한번 더 해요", "미티", "원모어", 19));
        bookList.add(new AniBook("루피의 원피스", "루피", "japan", 12));
        bookList.add(new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false));
        bookList.add(new CookBook("최현석 날 따라해봐", "최현석", "소금책", true));
    }

    public void insertMember(String name, int age, char gender) {
        // 전달받은 값을 가지고 Member 객체 생성 후 mem에 대입
        mem = new Member(name,age,gender);
    }

    public Member getMem() {
        // 회원 레퍼런스(mem) 주소 값 리턴
        return  mem;
    }

    public void updateMember(String name, int age, char gender) {
        // mem의 각 필드값을
        // 전달받은 이름, 나이, 성별값으로 수정하기
        mem.setName(name);
        mem.setAge(age);
        mem.setGender(gender);
    }

    public List<Book> selectAll() {
        // 도서 목록 레퍼런스 리턴
        return bookList;
    }

   public List<Book> searchBook(String keyword) {
        // 검색 결과를 담아줄 새로운 List 생성
       List<Book> searchTitleToBookList = new ArrayList<>();
        // for문을 이용하여 bList 도서 목록들의 도서명과 전달받은 keyword 비교
        // 전달받은 keyword를 포함하고 있으면  HINT : String 클래스의 contains() 참고
        // 검색결과의 도서목록에 담기 	        HINT : count 이용
       for(int i = 0; i<bookList.size(); i++){
           if(bookList.get(i).getTitle().contains(keyword)){
               searchTitleToBookList.add(bookList.get(i));
           }
       }


       // 해당 검색결과의 도서목록 주소 값 리턴
       return searchTitleToBookList;
    }

    public int rentBook(int index) {
        int result = 0;

        // 전달 받은 index의 bList 객체가 실제 AniBook 객체를 참조하고 있고
        // 해당 만화책의 제한 나이와 회원의 나이를 비교하여 회원 나이가 적을 경우
        // result를 1로 초기화		  나이 제한으로 대여 불가하다는 의미

        // 전달 받은 index의 bList 객체가 실제 CookBook 객체를 참조하고 있고
        // 해당 요리책의 쿠폰유무가 “true”일 경우
        // 회원의 couponCount 1 증가 처리 후
        // result를 2로 초기화  성공적으로 대여 완료, 요리학원 쿠폰이 발급됐다는 의미

        // result 값 리턴
       if(bookList.get(index) instanceof AniBook){
           AniBook aniBook = (AniBook) bookList.get(index);
           if(aniBook.getAccessAge() > mem.getAge()){
               result = 1;
           }
       }else if(bookList.get(index) instanceof  CookBook){
           CookBook cookBook = (CookBook) bookList.get(index);
           if(cookBook.isCoupon() == true){
               result = 2;
               mem.setCouponCount(mem.getCouponCount()+1);

           }
       }
       return result;
    }

}