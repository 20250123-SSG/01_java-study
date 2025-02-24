package com.seungjoo.practice7.controller;

import com.seungjoo.practice7.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager_ArrayList {

        static int count = 0;

        private List<Product> pro = new ArrayList<>();

        Scanner sc = new Scanner(System.in);


        public void mainMenu() {

            while (true) {
                System.out.println("==== 제품 관리 메뉴 ====");
                System.out.println("1. 제품 정보 추가");
                System.out.println("2.제품 전체 조회");
                System.out.println("3.제품 정보 수정");
                System.out.println("0. 프로그램 종료");
                int num = sc.nextInt();
                sc.nextLine();
                if (num == 1) {
                    productInput();
                } else if (num == 2) {
                    productPrint();
                } else if (num == 3) {
                    productUpdate();
                } else if (num == 0) {
                    break;
                }
            }
        }


        public void productInput() {

            System.out.print("id : ");
            int num1 = sc.nextInt();
            sc.nextLine();
            System.out.print("name : ");
            String str1 = sc.nextLine();
            System.out.print("price : ");
            int num2 = sc.nextInt();
            sc.nextLine();
            System.out.print("tax : ");
            double tax1 = sc.nextDouble();
            sc.nextLine();
            Product p = new Product(num1, str1, num2, tax1);
//            pro[count] = p;
            pro.add(new Product(num1, str1, num2, tax1));

        }

        public void productPrint() {
            for (int i = 0; i < pro.size(); i++) {
                System.out.println(pro.get(i).getInformation());
            }


        }


        public void productUpdate(){
            Scanner sc = new Scanner(System.in);
            System.out.println("수정할 제품명을 입력하세요.");
            String str = sc.nextLine();

            System.out.println("제품명을 입력하세요.");
            String str1 = sc.nextLine();
            System.out.println("가격을 입력하세요");
            int num1 = sc.nextInt();
            sc.nextLine();
            System.out.println("세금을 입력하세요");
            double num2 = sc.nextDouble();
            sc.nextLine();

            for(int i = 0 ; i < pro.size() ; i++){
                if(pro.get(i).getpName().equals(str)){
                    pro.get(i).setPrice(num1);
                    pro.get(i).setTax(num2);
                    pro.get(i).setpName(str1);
                }
            }




        }


    }








