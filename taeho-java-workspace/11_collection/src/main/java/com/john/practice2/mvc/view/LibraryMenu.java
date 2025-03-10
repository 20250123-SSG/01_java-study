package com.john.practice2.mvc.view;

import java.util.List;
import java.util.Scanner;

import com.john.practice2.mvc.dto.Book;
import com.john.practice2.mvc.dto.Member;
import com.john.practice2.mvc.controller.LibraryManager;



public class LibraryMenu {

    private LibraryManager lm = new LibraryManager();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        // 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
        // LibraryManager의 insertMember() 메소드에 전달

				/*
			  	==== 메뉴 ====	  // 무한 반복 실행
					1. 마이페이지		  // LibraryMenu의 myPage() 호출
					2. 도서 전체 조회	// LibraryMenu의 selectAll() 호출
					3. 도서 검색		    // LibraryMenu의 searchBook() 호출
					4. 도서 대여하기	  // LibraryMenu의 rentBook() 호출
					0. 프로그램 종료하기
				*/
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("성별을 입력하세요: ");
        char gender = sc.nextLine().charAt(0);
        Member member = new Member(name, age, gender);
        lm.insertMember(name, age, gender);

        while (true) {
            System.out.println("==== 메뉴 ====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("0. 프로그램 종료하기");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    myPage();
                    break;
                case 2:
                    selectAll();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    rentBook();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void myPage() {
        // LibraryManager의 getMem() 메소드 호출 하여 결과값 받은 후 회원 정보 출력하기

        // “수정하시겠습니까? (y/n) : “ 출력하여
        // 대소문자 구분없이 y일 경우
        // 수정할 이름, 나이, 성별을 입력받아
        // LibraryManager의 updateMember() 호출시 전달하기
        // “성공적으로 수정되었습니다.” 출력하기
        Member member = lm.getMem();
        System.out.println(member);

        System.out.println("수정하시겠습니까? (y/n) : ");
        char choice = sc.nextLine().charAt(0);
        if (choice == 'y' || choice == 'Y') {
            System.out.println("수정할 이름을 입력하세요 : ");
            String name = sc.nextLine();
            System.out.println("수정할 나이를 입력하세요 : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("수정할 성별을 입력하세요 : ");
            char gender = sc.nextLine().charAt(0);
            lm.updateMember(name, age, gender);
            System.out.println("성공적으로 수정되었습니다.");
        }
    }

    public void selectAll() {
        // LibraryManager의 selectAll() 메소드 호출하여 결과 값 받기

        // for문 이용하여 모든 도서 목록 출력
        // 단, i를 이용하여 인덱스도 같이 출력  대여할 때 도서번호를 알기 위해
        // ex) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
        List<Book> bookList = lm.selectAll();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + "번도서 : " + bookList.get(i).toString());
        }
    }

    public void searchBook() {
        // “검색할 제목 키워드 : “ 		>> 입력 받음 (keyword : String)
        // LibraryManager의 searchBook() 메소드에 전달 후 결과값 받기

        // for each문(향상된 for문)을 이용하여 검색 결과의 도서 목록 출력
        // 단, 검색 결과가 없을 경우 "검색된 결과가 없습니다" 출력
        System.out.print("검색할 제목을 입력하세요: ");
        String bookName = sc.nextLine();
        List<Book> searchList = lm.searchBook(bookName);
        if(searchList.isEmpty()) {
            System.out.println("검색된 결과가 없습니다.");
        }
        for(Book book : searchList) {
            System.out.println(book);
        }
    }

    public void rentBook() {
        // 도서 대여를 위해 도서번호를 알아야 된다.
        // => selectAll() 메소드 호출을 통해 도서 리스트 한번 출력 해주고

        // “대여할 도서 번호 선택 : ” 		>> 입력 받음 (num : int)
        // LibraryManager의 rentBook(num) 메소드에 전달 후 결과값 받기
        // 그 결과 값을 가지고 “성공적으로 대여되었습니다.” 또는
        // “나이 제한으로 대여 불가능입니다.” 또는
        // “성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인하세요” 출력하기
        List<Book> bookList = lm.selectAll();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + "번도서 : " + bookList.get(i).toString());
        }

        System.out.print("대여할 도서 번호 선택 : ");
        int bookId = sc.nextInt();
        sc.nextLine();
        int rentIdx = lm.rentBook(bookId);

        if (rentIdx == 0) {
            System.out.println("성공적으로 대여되었습니다.");
        } else if (rentIdx == 1) {
            System.out.println("나이 제한으로 대여 불가능입니다.");
        } else {
            System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인하세요");
        }
    }
}