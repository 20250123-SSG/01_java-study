package com.john.practice7_ArrayList.controller;

import com.john.practice7.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        // 메뉴 출력 --> 무한 반복 실행 처리함
				/*
					===== 제품 관리 메뉴 =====
					1. 제품 정보 추가 		// productInput() 메소드 실행
					2. 제품 전체 조회 		// productPrint() 메소드 실행
					3. 제품 정보 수정 		// productUpdate() 메소드 실행
					0. 프로그램 종료
				*/
        while (true) {
            System.out.println("\n===== 제품 관리 메뉴 =====");
            System.out.println("1. 제품 정보 추가");
            System.out.println("2. 제품 전체 조회");
            System.out.println("3. 제품 정보 수정");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 선택 >> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    productInput();
                    break;
                case 2:
                    productPrint();

                    break;
                case 3:
                    productUpdate();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력값입니다. 프로그램을 종료합니다.");
                    return;
            }
        }
    }

    public void productInput() {
        if (products.size() == 10) {
            System.out.println("제품을 최대로 등록했습니다. 먼저 제품을 삭제하시기 바랍니다.");
            return;
        }
        // 키보드로 제품 정보를 입력 받아 객체 생성
        // -> Product 생성자 내부에서 ProductManager의 count 클래스 변수 값이 1씩 증가될꺼임
        // 현재 카운트 인덱스에 생성된 객체 저장

        System.out.print("제품 번호를 입력하세요: ");
        int productId = sc.nextInt();
        sc.nextLine();
        System.out.print("제품명을 입력하세요: ");
        String productName = sc.nextLine();
        System.out.print("제품가격을 입력하세요: ");
        int productPrice = sc.nextInt();
        System.out.print("세금비율을 입력하세요: ");
        double productTax = sc.nextDouble();
        sc.nextLine();

        products.add(new Product(productId, productName, productPrice, productTax));
    }

    public void productPrint() {
        // 현재까지 기록된 모든 제품 정보 모두 출력
        if (products.isEmpty()) {
            System.out.println("제품이 하나도 등록되지 않았습니다. 먼저 제품을 등록해주시기 바랍니다.");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getInformation());
        }
    }

    public void productUpdate() {
        // 키보드로 수정하고자하는 제품명을 입력받으시오 => 해당 제품을 찾기 위한 값

        // 변경할 제품명, 가격, 세금을 입력 받으시오
        // 현재 보유하고있는 제품들 중에 해당 수정할 제품을 찾아서
        // 사용자가 입력한 제품명, 가격, 세금으로 필드 값을 변경하시오.

        if (products.size() == 10) {
            System.out.println("제품이 하나도 등록되지 않았습니다. 먼저 제품을 등록해주시기 바랍니다.");
            return;
        }

        System.out.print("변경하려고 하는 제품명을 입력하세요: ");
        String productName = sc.nextLine();

        System.out.print("변경할 제품명을 입력하세요: ");
        String newProductName = sc.nextLine();
        System.out.print("변경할 제품가격을 입력하세요: ");
        int newProductPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 제품의 세금을 입력하세요: ");
        double newProductTax = sc.nextDouble();
        sc.nextLine();

        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getName().equals(newProductName)) {
                products.get(i).setPrice(newProductPrice);
                products.get(i).setTax(newProductTax);
                products.set(i, new Product(products.get(i).getPid(), newProductName, newProductPrice, newProductTax));
            }
        }
    }
}