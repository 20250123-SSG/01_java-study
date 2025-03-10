package practice2.mvc.controller;

import practice2.mvc.dto.AniBook;
import practice2.mvc.dto.Book;
import practice2.mvc.dto.CookBook;
import practice2.mvc.dto.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryManager {
    private Member member;
    private List<Book> bookList = new ArrayList<>();

    {
        bookList.add(new CookBook("백종원의 집밥", "백종원", "tvN", true));
        bookList.add(new AniBook("한번 더 해요", "미티", "원모어", 19));
        bookList.add(new AniBook("루피의 원피스", "루피", "japan", 12));
        bookList.add(new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false));
        bookList.add(new CookBook("최현석 날 따라해봐", "최현석", "소금책", true));
    }

    public String login(String userId, String userPwd) {
        if (userId.equals("admin") && userPwd.equals("1234")) {
            return "admin";
        }
        return "member";
    }

    public boolean isExist(Book book) {
        return bookList.contains(book);
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(Book book) {
        bookList.remove(book);
    }

    public boolean switchBookOrder(int bookIndex1, int bookIndex2) {
//        bookList.set(bookIndex1-1, book2);
//        bookList.set(bookIndex2-1, book1);
        if (bookIndex1 == bookIndex2) {
            return false;
        }
        if ((bookIndex1 <= 0 || bookIndex1 > bookList.size()
                || bookIndex2 <= 0 || bookIndex2 > bookList.size())) {
            return false;
        }
        Collections.swap(bookList, bookIndex1 - 1, bookIndex2 - 1);
        return true;
    }

    public boolean editBookByEditOptionNumber(Book book, int editOption, String editValue) {
        ///아예 책을 삭제하고 새로운 객체를 생성 or set으로 수정
        ///좋은 구조는 아님 만약 책 옵션이 더 늘어나면 코드 복잡해짐
        if (editOption == 4) {
            if (book instanceof AniBook aniBook) {
                aniBook.setAccessAge(Integer.parseInt(editValue));
            } else if (book instanceof CookBook cookBook) {
                cookBook.setCoupon(editValue.equals("y"));
            }
            return true;
        }

        if (editOption == 1) {
            book.setTitle(editValue);
            return true;
        }
        if (editOption == 2) {
            book.setAuthor(editValue);
            return true;
        }
        if (editOption == 3) {
            book.setPublisher(editValue);
            return true;
        }
        return false;
    }


    public Book findBookByInfo(String title, String author, String publisher) {
        return bookList.stream().filter(
                        book -> book.getTitle().equals(title) &&
                                book.getAuthor().equals(author) &&
                                book.getPublisher().equals(publisher))
                .findFirst().orElse(null);
    }


    public void insertMember(String name, int age, char gender) {
        this.member = new Member(name, age, gender);
    }

    public Member getMember() {
        return this.member;
    }

    public void updateMember(String name, int age, char gender) {
        this.member = new Member(name, age, gender);
    }

    public List<Book> selectAll() {
        return new ArrayList<>(bookList); ///정렬할때 원본이 변경되지않게하기 위해서 복사하고 보내야됨
    }

    public List<Book> searchBook(String keyword) {
        List<Book> result = new ArrayList<>();

        for (Book book : this.bookList) {
            if (book.getTitle().contains(keyword)) {
                result.add(book);
            }
        }
        return List.copyOf(result);
    }

    public int rentBook(int index) {
        int result = 0;

        Book book = this.bookList.get(index);

        if (book instanceof AniBook aniBook) {
            if (aniBook.getAccessAge() > member.getAge()) {
                result = 1;
            }
        } else if (book instanceof CookBook cookBook) {
            if (cookBook.isCoupon()) {
                member.setCouponCount(member.getCouponCount() + 1);
                result = 2;
            }
        }
        return result;
    }

}
