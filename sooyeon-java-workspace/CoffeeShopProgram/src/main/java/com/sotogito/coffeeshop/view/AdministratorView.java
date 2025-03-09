package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.AdministratorController;
import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.dao.Sales;
import com.sotogito.coffeeshop.exception.DuplicateProductException;
import com.sotogito.coffeeshop.exception.ProductInformationUpdateException;
import com.sotogito.coffeeshop.model.*;
import org.w3c.dom.css.CSS2Properties;

import java.util.*;

public class AdministratorView {
    private final Scanner sc = new Scanner(System.in);

    private final ShopController shopController;
    private final AdministratorController administratorController;

    public AdministratorView(ShopController shopController, AdministratorController administratorController) {
        this.shopController = shopController;
        this.administratorController = administratorController;
    }

    public void run(User user) {
        System.out.println("관리자 페이지입니다.");
        while (true) {
            System.out.println("""
                    1. 가게 정보 관리
                    2. 가게 상품 관리
                    3. 가게 매출 관리
                    0. 종료하기
                    """);
            int functionNum = Integer.parseInt(sc.nextLine());

            if (functionNum == 0) {
                return;
            }
            switch (functionNum) {
                case 1:
                    manageShopInformation();
                    break;
                case 2:
                    manageShopProduct();
                    break;
                case 3:
                    manageShopSales();
                    break;

            }
        }
    }

    public void manageShopSales() {
        System.out.println("=====가게 매출 관리 페이지=====");
        while (true) {
            System.out.println("""
                    1. 전체 판매 내역 조회
                    2. 특정 고객 구매 내역 조회
                    0. 뒤로가기
                    """);
            int functionNum = Integer.parseInt(sc.nextLine());

            if (functionNum == 0) {
                return;
            }
            if (functionNum == 1) {
                System.out.println(Sales.SALES);
            } else if (functionNum == 2) {
                showUserPurchaseHistory();
            }

        }
    }

    public void showUserPurchaseHistory() {
        System.out.println("조회하고 싶은 회원의 id를 입력하세요.");
        String id = sc.nextLine();

        Optional<User> user = shopController.findUserById(id);
        if (user.isEmpty()) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }
        Map<Product, Integer> orders = user.get().getOrders();

        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.");
            return;
        }
        for (Map.Entry<Product, Integer> entry : orders.entrySet()) {
            String productName = entry.getKey().getName();
            int count = entry.getValue();
            System.out.printf("%s : %d개\n", productName, count);
        }
    }


    public void manageShopProduct() {
        System.out.println("=====가게 상품 관리 페이지=====");
        while (true) {
            System.out.println("""
                    1. 판매중인 커피 목록 조회
                    2. 판매중인 빵 목록 조회
                    3. 신규 커피 메뉴 추가
                    4. 신규 빵 메뉴 추가
                    0. 뒤로가기
                    """);
            int functionNum = Integer.parseInt(sc.nextLine());

            if (functionNum == 0) {
                return;
            }

            if (functionNum == 1) {
                shopController.getCoffeeList().forEach(System.out::println);
            } else if (functionNum == 2) {
                shopController.getBreadList().forEach(System.out::println);
            } else {
                addNewProduct(functionNum);
            }
        }
    }

    public void addNewProduct(int functionNum) {
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

            administratorController.addNewProduct(new Bread(name, price));
        } catch (DuplicateProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewCoffeeProduct() {
        System.out.println("추가할 커피의 이름과 가격을 입력하세요.");
        try {
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());

            administratorController.addNewProduct(new Coffee(name, price));
        } catch (DuplicateProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public void manageShopInformation() {
        System.out.println("=====가게 정보 관리 페이지=====");
        while (true) {
            System.out.println("""
                    1. 가게 정보 조회
                    2. 가게 이름 수정
                    3. 가게 주소 수정
                    4. 가게 마스터 id 수정
                    0. 뒤로가기
                    """);
            try {
                int functionNum = Integer.parseInt(sc.nextLine());

                if (functionNum == 0) {
                    return;
                }

                if (functionNum == 1) {
                    System.out.println(administratorController.getShop());
                } else {
                    editShopInformation(functionNum);
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해주세요");
            }
        }
    }

    public void editShopInformation(int functionNum) {
        Shop originShop = administratorController.getOriginShop();

        if (functionNum == 2) {
            editShopName();
        } else if (functionNum == 3) {
            editShopAddress();
        } else if (functionNum == 4) {
            editShopMasterId();
        }

        System.out.println("수정이 완료되었습니다.");
        System.out.println("변경 전 : " + originShop);
        System.out.println("변경 후 : " + administratorController.getShop());
    }

    public void editShopAddress() {
        System.out.println("수정할 가게 주소를 입력하세요.");
        String newAddress = sc.nextLine();

        administratorController.editShopAddress(newAddress);
    }

    public void editShopName() {
        System.out.println("수정할 가게 이름을 입력하세요.");
        String newName = sc.nextLine();

        administratorController.editShopName(newName);
    }

    public void editShopMasterId() {
        System.out.println("수정할 마스터 id을 입력하세요.");
        int newMasterId = Integer.parseInt(sc.nextLine());

        administratorController.editShopMasterId(newMasterId);
    }

}
