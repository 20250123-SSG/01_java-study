package com.pch.practice1.mvc.view;

import com.pch.practice1.mvc.controller.BookController;
import com.pch.practice1.mvc.dto.Book;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    BookController bc = new BookController();

    public void mainMenu(){
        /*
					===== 메인 메뉴 =====
					1. 새 도서 추가		 	  insertBook 메소드 실행
					2. 도서 전체 조회 		  selectList 메소드 실행
					3. 도서 검색 조회		  searchBook 메소드 실행
					4. 도서 삭제하기			  deleteBook 메소드 실행
					0. 프로그램 종료하기		  “프로그램 종료” 출력 후 리턴
					메뉴 번호 선택 :  		>> 입력 받음
				*/
        // 메뉴 화면 반복 실행 처리

        int menu = 0;

        while(true){
            System.out.print("===== 메인 메뉴 =====\n" +
                    "1. 새 도서 추가\t\t \t  insertBook 메소드 실행\n" +
                    "2. 도서 전체 조회 \t\t  selectList 메소드 실행\n" +
                    "3. 도서 검색 조회\t\t  searchBook 메소드 실행\n" +
                    "4. 도서 삭제하기\t\t\t  deleteBook 메소드 실행 \n" +
                    "0. 프로그램 종료하기\t\t  “프로그램 종료” 출력 후 리턴\n" +
                    "메뉴 번호 선택 :");
            menu = Integer.parseInt(sc.nextLine());

            switch(menu){
                case 1:
                    insertBook();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    break;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }
        }


    }

    public void insertBook(){
        System.out.print("도서명 : ");
        String title = sc.nextLine();
        System.out.print("저자명 : ");
        String author = sc.nextLine();
        System.out.print("장르번호 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int bookId = Integer.parseInt(sc.nextLine());
        System.out.print("가격 : ");
        String price = sc.nextLine();

        bc.insertBook(title, author, bookId, price);
        System.out.println("성공적으로 추가되었습니다.");
    }

    public void selectList(){
        List<Book> list = bc.selectList();
        if(list.isEmpty()) System.out.println("존재하는 도서가 없습니다");
        else {
            for(Book book : list){
                System.out.println(book.toString());
            }
        }
    }

    public void searchBook(){
        int menu = 0;
        while(true){
            System.out.print("===== 검색 메뉴 =====\n" +
                    "1. 도서명으로 검색\t\t \t\n" +
                    "2. 저자명으로 검색 \t\t\n" +
                    "3. 도서명+저자명으로 검색\t\t \n" +
                    "0. 뒤로가기\t\t\t  다시 mainMenu메소드로 리턴\n" +
                    "메뉴 번호 선택 :  \t\t>> 입력 받음");
            menu = Integer.parseInt(sc.nextLine());
            if(menu == 0) return;

            System.out.print("검색할 키워드 : ");
            String keyword = sc.nextLine();

            List<Book> books = bc.searchBook(menu, keyword);
            if(books.isEmpty()) System.out.println("검색 결과가 없습니다");
            else {
                for(Book book : books){
                    System.out.println(book.toString());
                }
            }
        }
    }

    public void deleteBook(){
        System.out.print("삭제할 도서명 : ");
        String title = sc.nextLine();
        System.out.print("삭제할 저자명 : ");
        String author = sc.nextLine();

        if(bc.deleteBook(title, author) == 0) System.out.println("삭제할 도서가 존재하지 않습니다.");
        else System.out.println("성공적으로 삭제되었습니다.");
    }
}
