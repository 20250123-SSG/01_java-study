package practice2.mvc.view;

import practice2.mvc.comparator.BookAuthorComparator;
import practice2.mvc.comparator.BookPublisherComparator;
import practice2.mvc.comparator.BookTitleComparator;
import practice2.mvc.controller.LibraryManager;
import practice2.mvc.dto.AniBook;
import practice2.mvc.dto.Book;
import practice2.mvc.dto.CookBook;
import practice2.mvc.dto.Member;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private LibraryManager lm = new LibraryManager();
    private Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.println("******** 환영합니다 *******");
        System.out.print("아이디 : ");
        String userId = sc.nextLine();
        System.out.print("비밀번호 : ");
        String userPwd = sc.nextLine();

        String user = lm.login(userId, userPwd);

        if (user.equals("admin")) {
            System.out.println("관리자님 환영합니다. 도서관리메뉴로 이동합니다.");
            adminMenu();
        } else {
            System.out.println("처음 방문하셨군요. 회원등록부터 진행합니다.");
            mainMenu();
        }
    }

    public void adminMenu() {
        while (true) {
            System.out.println("\n==== 관리자메뉴 ====");
            System.out.println("1. 도서 전체 조회");    // selectAll()
            System.out.println("2. 새로운 도서 추가");    // 기능 추가 해보기
            System.out.println("3. 기존 도서 삭제");    // 기능 추가 해보기
            System.out.println("4. 기존 도서 수정");    // 기능 추가 해보기
            System.out.println("5. 기본 도서 순서 변경");
            System.out.println("0. 프로그램 종료하기");
            System.out.print(">> 메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    selectAll();
                    break;
                case 2:
                    addNewBookInLibrary();
                    break;
                case 3:
                    deleteBookInLibrary();
                    break;
                case 4:
                    editBookInLibrary();
                    break;
                case 5:
                    switchBookOrder();
                    break;
                case 0:
                    System.out.println("안녕히가세요 관리자님.");
                    return;
                default:
                    System.out.println("다시입력해주세용");
            }
        }
    }

    public void mainMenu() {
        System.out.println("이름, 나이, 성별을 입력하세요");
        String name = sc.nextLine();
        int age = sc.nextInt();
        sc.nextLine();
        char gender = sc.next().charAt(0);
        lm.insertMember(name, age, gender);

        while (true) {
            System.out.println("""
                    			  	==== 메뉴 ====	  
                    				1.  마이페이지		
                    				2. 도서 전체 조회	
                    				3. 도서 검색		  
                    				4. 도서 대여하기	 
                    				0. 프로그램 종료하기	
                    """);
            int menuNum = sc.nextInt();
            sc.nextLine();

            if (menuNum == 0) {
                return;
            }
            if (menuNum == 1) {
                myPage();
            } else if (menuNum == 2) {
                selectAll();
            } else if (menuNum == 3) {
                searchBook();
            } else if (menuNum == 4) {
                rentBook();
            } else {
                System.out.println("존재하지 않는 기능입니다.");
            }
        }
    }


    public void switchBookOrder() {
        List<Book> basicOrderBookList = lm.selectAll();
        for (int i = 0; i < basicOrderBookList.size(); i++) {
            System.out.println(i + 1 + "번째 " + basicOrderBookList.get(i));
        }

        System.out.println("변경하고싶은 책의 번호를 입력하세요");
        int book1 = sc.nextInt();
        int book2 = sc.nextInt();

        if (lm.switchBookOrder(book1, book2)) {
            System.out.println("순서가 변경되었습니다.");
        } else {
            System.out.println("실패");
        }
    }


    public void addNewBookInLibrary() {
        System.out.println("제목, 저자, 출판사를 입력해주세요.");
        String title = sc.nextLine();
        String author = sc.nextLine();
        String publisher = sc.nextLine();

        System.out.println("카테고리를 입력해주세요.");
        System.out.println("""
                1. 애니
                2. 요리
                3. 기타
                """);
        int category = sc.nextInt();
        sc.nextLine();

        Book book = null;
        if (category == 1) {
            System.out.println("대여가능연령을 입력해주세요.");
            int accessAge = sc.nextInt();
            sc.nextLine();
            book = new AniBook(title, author, publisher, accessAge);

        } else if (category == 2) {
            System.out.println("요리 쿠폰이 존재합니까? y/n");
            String answer = sc.nextLine().toLowerCase();
            boolean coupon = answer.equals("y");
            book = new CookBook(title, author, publisher, coupon);

        } else if (category == 3) {
            book = new Book(title, author, publisher);
        }

        if (book == null) {
            System.out.println("존재하지 않는 카테고리입니다.");
            return;
        }

        if (lm.isExist(book)) {
            System.out.println("이미 존재하는 책입니다.");
            return;
        }
        lm.addBook(book);
        System.out.println("추가하였습니다.");
    }

    public void deleteBookInLibrary() {
        System.out.println("삭제할 도서의 제목, 저자, 출판사를 입력해주세요.");
        String title = sc.nextLine();
        String author = sc.nextLine();
        String publisher = sc.nextLine();

        Book book = lm.findBookByInfo(title, author, publisher);
        if (book == null) {
            System.out.println("존재하지 않는 책입니다.");
            return;
        }
        lm.deleteBook(book);
        System.out.println("삭제되었습니다.");
    }

    public void editBookInLibrary() {
        System.out.println("수정할 도서의 제목, 저자, 출판사를 입력해주세요.");
        String title = sc.nextLine();
        String author = sc.nextLine();
        String publisher = sc.nextLine();

        Book book = lm.findBookByInfo(title, author, publisher);
        if (book == null) {
            System.out.println("존재하지 않는 책입니다.");
            return;
        }

        while (true) {
            System.out.println("무엇 수정");
            System.out.println("""
                    1. 제목
                    2. 저자
                    3. 출판사
                    """);

            if (book instanceof AniBook) {
                System.out.println("4. 대여가능연령");
            } else if (book instanceof CookBook) {
                System.out.println("4. 쿠폰 유무(y/n)");
            }
            System.out.println("0. 종료");

            int editOption = sc.nextInt();
            sc.nextLine();
            if (editOption == 0) {
                return;
            }
            System.out.println("수정 내용을 입력하세요.");
            if (lm.editBookByEditOptionNumber(book, editOption, sc.nextLine())) {
                System.out.println(book);
                System.out.println("수정되었습니다.");
            } else {
                System.out.println("수정에 실패하였습니다.");
            }
        }
    }


    public void myPage() {
        Member member = lm.getMember();
        System.out.println(member);

        System.out.println("출력하시겠습니까?(y/n)");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("n")) {
            return;
        }
        System.out.println("수정할 이름,나이,성별을 입력하세요");
        String name = sc.nextLine();
        int age = sc.nextInt();
        sc.nextLine();
        char gender = sc.next().charAt(0);
        lm.updateMember(name, age, gender);
        System.out.println("성공적으로 수정되었습니다.");
    }

    public void selectAll() {
        System.out.println("""
                어떤 기준으로 정렬
                1. 기본(추가 순서)
                2. 이름
                3. 저자
                4. 출판사
                """);
        int sortType = sc.nextInt();
        sc.nextLine();

        List<Book> result = lm.selectAll();
        if (sortType == 2) {
            result.sort(new BookTitleComparator());
        } else if (sortType == 3) {
            result.sort(new BookAuthorComparator());
        } else if (sortType == 4) {
            result.sort(new BookPublisherComparator());
        }

        System.out.println("내림차순을 원하시면 1, 아니면 2를 입력하세요.");
        boolean isDescendant = sc.nextInt() == 1;
        if (isDescendant) {
            Collections.reverse(result);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + 1 + "번째 " + result.get(i));
        }
    }

    public void searchBook() {
        System.out.println("검색할 키워드 :");
        String keyword = sc.nextLine();

        List<Book> reuslt = lm.searchBook(keyword);
        if (!reuslt.isEmpty()) {
            for (Book book : reuslt) {
                System.out.println(book);
            }
        } else {
            System.out.println("없음");
        }
    }

    public void rentBook() {
        selectAll();

        System.out.println("대여할 도서 번호 선택 ");
        int searchBookNum = sc.nextInt();
        int rentResult = lm.rentBook(searchBookNum);

        if (rentResult == 0) {
            System.out.println("성공적으로 대여되었습니다.");
        } else if (rentResult == 1) {
            System.out.println("나이 제한으로 대여 불가능입니다.");
        } else if (rentResult == 2) {
            System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다.");
        }
    }

}
