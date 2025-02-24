package com.kyungbae.practice7.controller;

import com.kyungbae.practice7.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager_ArrayList {
	
//	private Product[] pro = new Product[10];
//	public static int count = 0;
	private List<Product> pro = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		int menu = 0;
		while(true) {
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("3. 제품 수정");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: productInput(); break;
			case 2: productPrint(); break;
			case 3: productUpdate(); break;
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못입력하였습니다. 다시 입력해주세요."); break;
			}
			
		}
	}
	
	public void productInput() {
		
		if(pro.size() == 10) {
			System.out.println("현재 10개의 제품 정보가 다 찼습니다. 더이상 추가할 수 없습니다.");
			return;
		}
		
		System.out.print("제품 번호 : ");
		int pId = sc.nextInt();
		sc.nextLine();
		System.out.print("제품 이름 : ");
		String pName = sc.nextLine();
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		System.out.print("제품 세금 : ");
		double tax = sc.nextDouble();
		
//		pro[count] = new Product(pId, pName, price, tax);
		pro.add(new Product(pId,pName,price,tax));

		
	}
	
	public void productPrint() {
//        for (Product product : pro) {
//            System.out.println(product.getInformation());
//        }
		for(Product l : pro) {
			System.out.println(l.getInformation());
		}
	}
	
	public void productUpdate() {
		System.out.print("수정하고자하는 제품명 : ");
		String pName = sc.nextLine();

		boolean isName = false;
		for(int i=0; i<pro.size(); i++) {
			if(pro.get(i).getpName().equals(pName)) {
				System.out.print("변경할 제품명 : ");
				String newName = sc.nextLine();
				System.out.print("변경할 가격 : ");
				int newPrice = sc.nextInt();
				System.out.print("변경할 세금 : ");
				double newTax = sc.nextDouble();

//				pro.get(i).setpName(newName);
//				pro.get(i).setPrice(newPrice);
//				pro.get(i).setTax(newTax);
				pro.set(i, new Product(pro.get(i).getpId(), newName, newPrice, newTax));

				isName = true;
			}
		}
		if (isName) {
			System.out.println("변경 완료되었습니다.");
		} else {
			System.out.println("없는 상품입니다.");
		}
	}

}
