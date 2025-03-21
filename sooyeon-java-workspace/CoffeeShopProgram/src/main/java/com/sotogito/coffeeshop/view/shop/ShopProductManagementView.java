package com.sotogito.coffeeshop.view.shop;

import com.sotogito.coffeeshop.controller.ShopProductController;
import com.sotogito.coffeeshop.exception.product.DuplicateProductException;
import com.sotogito.coffeeshop.exception.product.NoSuchProductException;
import com.sotogito.coffeeshop.exception.product.ProductInformationUpdateException;
import com.sotogito.coffeeshop.model.products.Bread;
import com.sotogito.coffeeshop.model.products.Coffee;

import java.util.Scanner;

public class ShopProductManagementView {
    private final Scanner sc = new Scanner(System.in);
    private final ShopProductController shopProductController;

    public ShopProductManagementView(ShopProductController shopProductController) {
        this.shopProductController = shopProductController;
    }


    public void run() {
        System.out.println("=====가게 상품 관리 페이지=====");
        while (true) {
            System.out.println("""
                    1. 판매중인 커피 목록 조회
                    2. 판매중인 빵 목록 조회
                    3. 신규 커피 메뉴 추가
                    4. 신규 빵 메뉴 추가
                    5. 메뉴 삭제
                    0. 뒤로가기
                    """);
            int functionNum = Integer.parseInt(sc.nextLine());

            if (functionNum == 0) {
                return;
            }

            switch (functionNum) {
                case 1:
                    printCoffeeProducts();
                    break;
                case 2:
                    printBreadProducts();
                    break;
                case 3, 4:
                    addNewProduct(functionNum);
                    break;
                case 5:
                    deleteProduct();
                    break;
            }
        }
    }

    public void addNewProduct(int functionNum) {
        printCoffeeProducts();
        printBreadProducts();
        try {
            if (functionNum == 3) {
                addNewCoffeeProduct();
            } else if (functionNum == 4) {
                addNewBreadProduct();
            }
        } catch (DuplicateProductException | ProductInformationUpdateException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("가격은 숫자로 입력해주세요.");
        }
    }

    public void addNewBreadProduct() {
        System.out.println("추가할 빵의 이름과 가격을 입력하세요.");
        try {
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());

            shopProductController.addNewProduct(new Bread(name, price));
        } catch (DuplicateProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewCoffeeProduct() {
        System.out.println("추가할 커피의 이름과 가격을 입력하세요.");
        try {
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());

            shopProductController.addNewProduct(new Coffee(name, price));
        } catch (DuplicateProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct() {
        printCoffeeProducts();
        printBreadProducts();
        System.out.println("삭제할 상품 이름을 입력하세요.");
        try {
            String productName = sc.nextLine();

            shopProductController.deleteProductByName(productName);
            System.out.println("삭제되었습니다.");
        } catch (NoSuchProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printCoffeeProducts() {
        shopProductController.getCoffeeList().forEach(System.out::println);
    }

    public void printBreadProducts() {
        shopProductController.getBreadList().forEach(System.out::println);
    }

}
