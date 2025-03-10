package com.seungjoo.practice1.mvc.view;

import com.seungjoo.practice1.mvc.controller.BookController;
import com.seungjoo.practice1.mvc.dto.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookMenu {
    private Scanner sc = new Scanner(System.in);
    private BookController bc =new BookController();

    public BookMenu(){}


    public BookMenu(Scanner sc, BookController bc) {
        this.sc = sc;
        this.bc = bc;
    }

    public void mainMenu(){
        while(true) {
            System.out.println("===== 메인 메뉴 ====");
            System.out.println("1.새 도서 추가");
            System.out.println("2.도서 전체 조회");
            System.out.println("3.도서 검색 조회");
            System.out.println("4.도서 삭제하기");
            System.out.println("0.프로그램 종료하기");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
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
                    deletetBook();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
            }
        }





    }

    public void insertBook(){

        System.out.println("도서명 : ");
        String bookName = sc.nextLine();
        System.out.println("저자명: ");
        String author = sc.nextLine();
        System.out.println("1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int genre = sc.nextInt();
        sc.nextLine();
        System.out.println("가격 : ");
        String price = sc.nextLine();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"인문");
        map.put(2,"자연과학");
        map.put(3,"의료");
        map.put(4, "기타");


        bc.insertBook(bookName,author,map.get(genre),Integer.parseInt(price));
        System.out.println("성공적으로 추가되었습니다.");
    }

    public void selectList(){
        List<Book> list = bc.selectList();
        if(list.isEmpty()) System.out.println("존재하는 도서가 없습니다.");
        else{
            for(Book book : list){
                System.out.println(book.toString());
            }
        }
    }

    public void searchBook(){

    while(true) {
        System.out.println(" ==== 검색 메뉴 ====");
        System.out.println("1. 도서명으로 검색");
        System.out.println("2. 저자명으로 검색");
        System.out.println("3. 도서명 + 저자명으로 검색");
        System.out.println("0 뒤로가기");
        System.out.println("메뉴 번호 선택 : ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("검색할 키워드 : ");
        String keyword = sc.nextLine();
        ArrayList<Book> list = bc.searchBook(num, keyword);

        if(list.isEmpty()) System.out.println("검색 결과가 없습니다.");
        else{
            for(Book book : list){
                System.out.println(book.toString());
            }
        }
    }

    }

    public void deletetBook(){
        System.out.println("삭제할 도서명 : ");
        String bookName = sc.nextLine();
        System.out.println("삭제할 저자명");
        String author = sc.nextLine();
        boolean flag = bc.deleteBook(bookName,author);
        if(flag) {
            System.out.println("성공적으로 삭제되었습니다.");
        }else{
            System.out.println("삭제할 도서가 존재하지 않습니다.");
        }
    }



}
