package com.sotogito.practice7.controller;

import com.sotogito.practice7.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager_ArrayList {
    private List<Product> products = new ArrayList<>(10);
    Scanner sc = new Scanner(System.in);
    {
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
    }

    public void mainMenu(){
        while (true){
            System.out.println("===== 제품 관리 메뉴 =====");
            System.out.println("1. 제품 정보 추가");
            System.out.println("2. 제품 전체 조회");
            System.out.println("3. 제품 정보 수정");
            System.out.println("0. 프로그램 종료");
            int functionNum = sc.nextInt();

            if(functionNum == 0){
                return;
            }
            if(functionNum == 1){
                productInput();
            } else if (functionNum == 2) {
                productPrint();
            } else if (functionNum ==3) {
                productUpdate();
            }else {
                System.out.println("존재하지 않는 기능입니다.");
            }
        }
    }

    public void productInput(){
        if(products.size() == 10){
            System.out.println("더이상 추가할 수 없습니다.");
            return;
        }
        System.out.println("상품 아이디 : ");
        int id = sc.nextInt();
        System.out.println("상품 이름 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("상품 가격 : ");
        int price = sc.nextInt();
        System.out.println("상품 세금 : ");
        double tax = sc.nextDouble();

       products.add(new Product(id, name, price, tax));
    }

    public void productPrint(){
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void productUpdate(){
        System.out.println("수정하고자 하는 제품명을 입력하세요.");
        sc.nextLine();
        String productName = sc.nextLine();


        for (Product product : products) {
            if(product.getName().equals(productName)){
                System.out.println("변경할 이름 : ");
                product.setName(sc.nextLine());
                System.out.println("변경할 가격 : ");
                product.setPrice(sc.nextInt());
                System.out.println("변경할 세금 : ");
                product.setTax(sc.nextDouble());
                System.out.println("수정이 완료되었습니다.");

                //아니면 인덱스로해서 새로운 값으로 set해도됨 -> products.set(i,new Product)
                return;
            }
        }
        System.out.println("존재하지 않는 재품입니다.");

    }
}
