package practice1.mvc.controller;

import practice1.mvc.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private List<Book> bookList = new ArrayList<>();

    {    // 초기값 4개정도 추가
        bookList.add(new Book("자바언어의 정석", "홍길동", "기타", 20000));
        bookList.add(new Book("자바언어의 정석", "홍길동", "기타", 20000));
        bookList.add(new Book("C언어의 보람", "김말똥", "기타", 15000));
        bookList.add(new Book("도움이 되었나요", "캥거루", "인문", 17500));
        bookList.add(new Book("여러분", "홍홍홍", "의료", 10000));
    }

    public void insertBook(String title, String author, int categoryNum, int price) {
        bookList.add(new Book(title, author, findCategoryByNum(categoryNum), price));
    }

    private String findCategoryByNum(int num) {
        if (num == 1) {
            return "인문";
        } else if (num == 2) {
            return "자연과학";
        } else if (num == 3) {
            return "의료";
        }
        return "기타";
    }

    public List<Book> selectList() {
        return bookList;
    }

    public List<Book> searchBook(int searchType, String keyword) {
        List<Book> result = new ArrayList<>();

        if (searchType == 1) {
            for (Book book : bookList) {
                if (book.getTitle().contains(keyword)) {
                    result.add(book);
                }
            }
        } else if (searchType == 2) {
            for (Book book : bookList) {
                if (book.getAuthor().contains(keyword)) {
                    result.add(book);
                }
            }
        } else if (searchType == 3) {
            for (Book book : bookList) {
                if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public int deleteBook(String title, String author) {
        return bookList.removeIf(book ->
                book.getTitle().contains(title) ||
                        book.getAuthor().contains(author)) ? 1 : 0;
    }

}
