package practice1.mvc.view;

import practice1.mvc.controller.BookController;
import practice1.mvc.dto.Book;

import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class BookMenu {
    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();

    public void mainMenu() {
        while (true) {
            System.out.println("===== 메인 메뉴=====");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색 조회");
            System.out.println("4. 도서 삭제하기");
            System.out.println("0. 프로그램 종료하기");
            System.out.println("메뉴 번호 선택 :   ");
            int menuNum = sc.nextInt();
            sc.nextLine();

            switch (menuNum) {
                case 0: return;
                case 1: insertBook();break;
                case 2: selectList();break;
                case 3: searchBook();break;
                case 4: deleteBook();break;
                default: System.out.println("잘못된 메뉴 선택입니다.");break;
            }
        }
    }

    public void insertBook() {
        System.out.println("도서명 : ");
        String title = sc.nextLine();
        System.out.println("저자명 : ");
        String author = sc.nextLine();
        System.out.println("장르번호 (1:인문 / 2:자연과학 / 3:의료 / 4:기타)");
        int category = sc.nextInt();
        System.out.println("가격 : ");
        String price = sc.nextLine();

        bc.insertBook(title, author, category, Integer.parseInt(price));
        System.out.println("성공적으로 추가되었습니다.");
    }

    public void selectList() {
        List<Book> bookResult = bc.selectList();

        if (bookResult.isEmpty()) {
            System.out.println("존재하는 도서가 없습니다.");
            return;
        }
        for (Book book : bookResult) {
            System.out.println(book);
        }
    }

    public void searchBook() {
        while (true) {
            System.out.println("""
                    		===== 검색 메뉴 =====
                           	1. 도서명으로 검색
                    		2. 저자명으로 검색
                    		3. 도서명+저자명으로 검색
                    		0. 뒤로가기			 
                    		메뉴 번호 선택 :  	
                    """);
            int searchType = sc.nextInt();
            sc.nextLine();
            if (searchType == 0) {
                return;
            }
            System.out.println("검색할 키워드 : ");
            String keyword = sc.nextLine();


            List<Book> bookResult = bc.searchBook(searchType, keyword);
            if (bookResult.isEmpty()) {
                System.out.println("검색 결과가 없습니다.");
                continue;
            }
            for (Book book : bookResult) {
                System.out.println(book);
            }
        }
    }

    public void deleteBook() {
        System.out.println("삭제할 도서명");
        String title = sc.nextLine();
        System.out.println("삭제할 저자명");
        String author = sc.nextLine();

        if (bc.deleteBook(title, author) == 1) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("삭제할 곡이 없습니다.");
        }
    }

}
