package com.kyungbae.practice1.mvc.view;

import com.kyungbae.practice1.mvc.cotroller.BookController;
import com.kyungbae.practice1.mvc.dto.Book;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    BookController bc = new BookController();

    public void mainMenu(){

        while (true) {

            System.out.println("\n===== 메인 매뉴 =====");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색 조회");
            System.out.println("4. 도서 삭제하기");
            System.out.println("0. 프로그램 종료하기");
            System.out.print(">> 메뉴 번호 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 : insertBook(); break;
                case 2 : selectList(); break;
                case 3 : searchBook(); break;
                case 4 : deleteBook(); break;
                case 0 :
                    System.out.println("프로그램 종료"); return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
            }
        }

    } // mainMenu end

    public void insertBook(){
        System.out.println("\n=== 새 도서 추가 ===");
        System.out.print("도서명 : ");
        String title = sc.nextLine();
        System.out.print("저자명 : ");
        String author = sc.nextLine();
        System.out.print("장르번호 (1: 인문 / 2: 자연과학 / 3: 의료 / 4: 기타) : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.print("가격 : ");
        String price = sc.nextLine();

        int result = bc.insertBook(title, author, category, price);
        if (result > 0) {
            System.out.println("성공적으로 추가되었습니다.");
        } else {
            System.out.println("실패하였습니다.");
        }
    } // insertBook end

    public void selectList (){

        List<Book> list = bc.selectList();
        if (list.isEmpty()) {
            System.out.println("존재하는 도서가 없습니다.");
        } else {
            for(Book b : list){
                System.out.println(b);
            }
        }
    }// selectList end

    public void searchBook() {
        System.out.println("\n===== 검색 메뉴 =====");
        System.out.println("1. 도서명으로 검색");
        System.out.println("2. 저자명으로 검색");
        System.out.println("3. 도서 + 저자명으로 검색");
        System.out.println("0. 뒤로가기");
        System.out.print(">> 메뉴 번호 선택 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        if (menu != 0) {
            System.out.print(">> 검색할 키워드 : ");
            String input = sc.nextLine();
            List<Book> result = bc.searchBook(menu, input);
            if (result.isEmpty()) {
                System.out.println("검색 결과가 없습니다.");
            } else {
                for (Book b : result){
                    System.out.println(b);
                }
            }
        }
    } // searchBook end

    public void deleteBook(){
        System.out.println("\n==== 도서 삭제 ====");
        System.out.print("삭제할 도서명 : ");
        String title = sc.nextLine();
        System.out.print("삭제할 저자명 : ");
        String author = sc.nextLine();

        int result = bc.deleteBook(title, author);
        if (result > 0) {
            System.out.println("성공적으로 삭제되었습니다.");
        } else {
            System.out.println("삭제할 도서가 존재하지 않습니다.");
        }
    } // deleteBook end

} // class end
