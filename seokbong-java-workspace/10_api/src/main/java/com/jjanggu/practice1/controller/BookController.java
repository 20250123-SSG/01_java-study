package com.jjanggu.practice1.controller;

import com.jjanggu.practice1.dto.Book;

import java.util.GregorianCalendar;

public class BookController {

    private Book[] list = new Book[5];

    { 	// 초기화블럭 (초기에 4개의 도서가 세팅될 수 있도록)
        list[0] = new Book("자바의 정석", "제임스 고슬링", "나무", new GregorianCalendar(2018, 4-1, 15), 20000);
        list[1] = new Book("여러분들 성공할꺼에요", "캥거루", "BR", new GregorianCalendar(2019, 6-1, 15), 30000);
        list[2] = new Book("API의 모든것", "캥거루", "BR", new GregorianCalendar(2017, 2-1, 13), 15000);
        list[3] = new Book("씨언어 프로그래밍", "김절차", "문학동네", new GregorianCalendar(2016, 8-1, 30), 10000);
    }

    public BookController() {}

    public void printAll() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println(list[i].toString());
            }
        }
        // list배열에 존재하는 Book객체의 정보 출력하는 구문 작성하시오.
        // 1) for loop문 방법
        // 2) for each문 방법 (향상된 for문)

    }

    public void insertBook(String newTitle, String newAuthor, String newPublisher, String newDate, String newPrice) {

        int price = Integer.parseInt(newPrice);

        // 전달된 신규 도서 정보들을 담은 Book객체를 생성하여 list 배열의 마지막 인덱스 자리에 대입하시오.

				/*
					* 고려사항
					1. 전달된 출판일이 "XXXX-XX-XX" 형식의 문자열이므로 어떻게 Book객체의 Calendar 타입 필드에 반영시킬건지 고려해보기.
					   Hint. Split 또는 StringTokenizer 와 파싱을 적절히 활용해볼것
					2. 전달된 가격값 또한 문자열 이므로 어떻게 Book객체의 int 타입 필드에 반영시킬건지 고려해보기.
				*/

    }

    public void printBookPublishDate() {

        // list 배열의 마지막 도서객체의 출판일 정보 출력하시오.
        // 단, "XXXX년 XX월 XX 출간"과 같은 패턴으로 출력하시오.

    }

    public void searchBook(String searchTitle) {

        // list배열내의 도서들 중 전달받은 키워드가 도서명으로 포함되어있는 도서 정보 출력
        // 1) for loop문 방법
        // 2) for each문 방법 (향상된 for문)

    }

}