package com.kyungbae.practice2.mvc.view;

import com.kyungbae.practice2.mvc.controller.LibraryManager;
import com.kyungbae.practice2.mvc.dto.Book;
import com.kyungbae.practice2.mvc.dto.Member;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    LibraryManager lm = new LibraryManager();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        lm.insertMember(setMember());

        while (true) {
            System.out.println("\n==== 메뉴 ====");
            System.out.println("1.   마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("0. 프로그램 종료하기");
            System.out.print(">> 메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: myPage(); break;
                case 2: selectAll(); break;
                case 3: searchBook(); break;
                case 4: rentBook(); break;
                case 0:
                    System.out.println("프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    } // mainMenu end

    public Member setMember(){
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        sc.nextLine();
        char gen;
        while (true) {
            System.out.print("성별 입력 (m/f) : ");
            char gender = sc.nextLine().charAt(0);

            if (gender == 'm' || gender == 'M') {
                gen = '남';
                break;
            } else if (gender == 'f' || gender == 'F') {
                gen = '여';
                break;
            }
            System.out.println("다시 입력해주세요");
        }
        return new Member(name, age, gen);
    } // setMember end

    public void myPage(){
        System.out.println("\n=== 마이페이지 ===");
        System.out.println(lm.getMem());
//        sc.nextLine();
        System.out.print("수정하시겠습니까? (y/n) : ");
        char yn = sc.nextLine().charAt(0);
        if (yn == 'y' || yn == 'Y') {
            lm.updateMember(setMember());
            System.out.println("수정되었습니다.");
        }
    } // myPage end

    public void selectAll(){
        System.out.println("\n=== 도서 전체 조회 ===");
        List<Book> list = lm.selectAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "번째 도서 : " + list.get(i));
        }
    } // selectAll end

    public void searchBook(){
        System.out.println("\n=== 도서 검색 ===");
        System.out.print("검색할 제목 키워드 : ");
        String keyword = sc.nextLine();
        List<Book> books = lm.searchBook(keyword);
        if (books.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    } // searchBook end

    public void rentBook(){
        System.out.println("\n=== 도서 대여하기 ===");
        selectAll();
        System.out.print("\n대여할 도서 번호 선택 : ");
        int num = sc.nextInt();
        sc.nextLine();

        int count = lm.rentBook(num);
        if(count == 0){
            System.out.println("성공적으로 대여 완료되었습니다.");
        } else if (count == 1) {
            System.out.println("나이 제한으로 대여가 불가합니다.");
        } else if (count == 2) {
            System.out.println("성공적으로 대여 완료되었습니다. 추가로 요리학원 쿠폰이 발급되었습니다.");
        }
    }


}
