package com.jjanggu.practice2.run;

import com.jjanggu.practice2.dto.BookDTO;

public class Application {
    public static void main(String[] args) {

        BookDTO bd1 = new BookDTO();
        BookDTO bd2 = new BookDTO("자바의정석", 20000, 0.2, "윤상섭");
        System.out.println(bd1.getInformation());
        System.out.println(bd2.getInformation());

        System.out.println("=======================");

        bd1.setTitle("C언어");
        bd1.setPrice(30000);
        bd1.setDiscountRate(0.1);
        bd1.setAuthor("홍길동");

        System.out.println(bd1.getInformation());

        System.out.println("=====================================");

        int disPrice1 = bd1.getPrice() - (int)(bd1.getPrice()*bd1.getDiscountRate());
        int disPrice2 = bd2.getPrice() - (int)(bd2.getPrice()*bd2.getDiscountRate());
        System.out.println("도서명 = " + bd1.getTitle());
        System.out.println("할인된 가격 = " + disPrice1 + "원");
        System.out.println("도서명 = " + bd2.getTitle());
        System.out.println("할인된 가격 = " + disPrice2 + "원");



    }
}
