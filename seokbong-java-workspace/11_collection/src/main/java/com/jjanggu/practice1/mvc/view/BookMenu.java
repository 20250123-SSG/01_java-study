package com.jjanggu.practice1.mvc.view;

import com.jjanggu.practice1.mvc.controller.BookController;
import com.jjanggu.practice1.mvc.dto.Book;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();


    public void mainMenu(){

        while(true){
            System.out.println("\n===== 메인 메뉴 =====");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색 조회");
            System.out.println("4. 도서 삭제하기");
            System.out.println("0. 프로그램 종료하기");
            System.out.println(">> 메뉴 번호 선택");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: insertBook(); break;
                case 2: selectList(); break;
                case 3: searchBook(); break;
                case 4:break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 선택해주세요");
            }
        }


    }

    public void insertBook(){
        System.out.println("도서명 : ");
        String title = sc.nextLine();
        System.out.println("저자명 : ");
        String author = sc.nextLine();
        System.out.println();
        System.out.println("장르번호 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.println("가격 : ");
        String price = sc.nextLine();

        boolean result = bc.insertBook(title, author, category, price);
        if (result){
            System.out.println("성공적으로 추가되었습니다.");
        }else{
            System.out.println("추가에 실패하였습니다.");
        }


    }

    public void selectList() {
        List<Book> list = bc.selectList();

        if(list.isEmpty()){
            System.out.println("존재하는 도서가 없습니다.");
        }else{
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
        }

    }

    public void searchBook() {
        while(true){
            System.out.println("===== 검색 메뉴=====");
            System.out.println("1. 도서명으로 검색");
            System.out.println("2. 저자명으로 검색");
            System.out.println("3. 도서명+저자명으로 검색");
            System.out.println("0. 뒤로가기");
            System.out.println(">> 메뉴 번호 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            System.out.println("검색할 키워드 : ");
            String keyword = sc.nextLine();
        }




    }

    public void deleteBook() {

    }
}
