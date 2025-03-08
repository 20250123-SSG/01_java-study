/*
package com.ibe6.practice1.mvc.view;

import com.ibe6.practice1.mvc.controller.BookController;

import java.util.Scanner;

public class BookMenu{

    // Scanner 객체 생성
    private Scanner sc = new Scanner(System.in);
    // BookController 객체 생성 (bc)
    private BookController bc = new BookController();


    public void mainMenu() {

        while (true){
        System.out.println("\n===== 메인 메뉴 =====");
        System.out.println("1. 새 도서 추가");
        System.out.println("2. 도서 전체 조회");
        System.out.println("3. 도서 검색 조회");
        System.out.println("4. 도서 삭제하기");
        System.out.println("0. 프로그램 종료하기");
        System.out.print("메뉴 번호 선택 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        switch (menu){
            case 1 : insertBook(); break;
            case 2 : selectList(); break;
            case 3 : searchBook(); break;
            case 4 : deleteBook(); break;
            case 0:
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                return;
            default :
                System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요.");

        }
    }

    public void insertBook(){
            System.out.print("도서명: ");
            String name = sc.nextLine();
            System.out.print("저자명: ");
            String author = sc.nextLine();
            System.out.print("(1:인문 / 2:자연과학 / 3:의료 / 4:기타): ");
            int category = sc.nextInt();
            System.out.println("가격: ");
            String price = sc.nextLine();

        // BookController의 insertBook 메소드로 전달
        // “성공적으로 추가되었습니다.” 출력
    }

    public void selectList(){
        // BookController의 selectList() 메소드 호출하여 ArrayList 돌려받기

        // 해당 리스트가 비어 있을 경우 		>> “존재하는 도서가 없습니다.”출력
        // 해당 리스트가 비어있지 않을 경우	>> for loop문을 이용하여 모든 도서 출력
        //                                >> 또는 for each 문 이용하여 출력
    }

 */
/*
    public void searchBook() {
				/*
					===== 검색 메뉴 =====
					1. 도서명으로 검색
					2. 저자명으로 검색
					3. 도서명+저자명으로 검색
					0. 뒤로가기			  다시 mainMenu메소드로 리턴
					메뉴 번호 선택 :  		>> 입력 받음
				*/
        // 메뉴 화면 반복 실행 처리

        // “검색할 키워드 : “ 			>> String 타입으로 입력 받기
        // BookController의 searchBook으로 메뉴번호와 함께 전달하며 호출 한 후 ArrayList돌려받기

        // 해당 리스트가 비어 있을 경우		>> “검색 결과가 없습니다.”출력
        // 해당 리스트가 비어있지 않을 경우	>> for문을 이용하여 검색 도서 출력
//    }

    /*
    public void deleteBook(){
        // “삭제할 도서명 : “ 				>> String 타입으로 입력 받기
        // “삭제할 저자명 : “				>> String 타입으로 입력 받기
        // BookController의 deleteBook 메소드로 전달하며 호출 한 후 결과 돌려받기

        // 성공적으로 삭제됐을 경우 		>> “성공적으로 삭제되었습니다.” 출력
        // 삭제할 도서를 찾지 못했을 경우	>> “삭제할 도서가 존재하지 않습니다.”출력
    }

}

*/