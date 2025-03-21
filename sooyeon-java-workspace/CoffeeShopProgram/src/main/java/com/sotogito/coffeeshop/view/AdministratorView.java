package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.controller.ShopProductController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.serivce.UserService;
import com.sotogito.coffeeshop.exception.*;
import com.sotogito.coffeeshop.dto.PaymentDetailsDTO;
import com.sotogito.coffeeshop.model.*;
import com.sotogito.coffeeshop.model.products.Bread;
import com.sotogito.coffeeshop.model.products.Coffee;
import com.sotogito.coffeeshop.view.printer.PaymentPrinter;

import java.util.*;

public class AdministratorView {
    private final Scanner sc = new Scanner(System.in);

    private final ShopInformationController shopInformationController;
    private final ShopProductController shopProductController;
    private final UserController userController;

    public AdministratorView(
            ShopInformationController shopInformationController, ShopProductController shopProductController, UserController userController) {
        this.shopInformationController = shopInformationController;
        this.shopProductController = shopProductController;
        this.userController = userController;
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
                printAllPaymentDetails();
            } else if (functionNum == 2) {
                printUserPaymentDetails();
            }

        }
    }

    private void printAllPaymentDetails() {
        Map<String, List<PaymentDetailsDTO>> paymentDetails = null;
        try {
            paymentDetails = shopInformationController.getPaymentDetails();
        } catch (EmptyPaymentHistory e) {
            System.out.println(e.getMessage());
            return;
        }

        for(String key : paymentDetails.keySet()) {
            System.out.println(PaymentPrinter.getPrintout(key, paymentDetails.get(key)));
        }
        System.out.println("조회완료");
    }

    private void printUserPaymentDetails() {
        System.out.println("조회하고 싶은 회원의 id를 입력하세요.");
        String id = sc.nextLine();

        User user = null;
        try {
            user = userController.findUserById(id);
        } catch (NoSuchUserException e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<String, List<PaymentDetailsDTO>> paymentDetails = null;
        try {
            paymentDetails = shopInformationController.getPaymentDetailsByUser(user);
        } catch (EmptyPaymentHistory e) {
            System.out.println(e.getMessage());
            return;
        }

        for(String key : paymentDetails.keySet()) {
            System.out.println(PaymentPrinter.getPrintout(key, paymentDetails.get(key)));
        }
        System.out.println("조회완료");
    }


    public void manageShopProduct() {
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
                    System.out.println(shopInformationController.getShop());
                } else {
                    editShopInformation(functionNum);
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해주세요");
            }
        }
    }

    public void editShopInformation(int functionNum) {
        Shop originShop = shopInformationController.getOriginShop();

        if (functionNum == 2) {
            editShopName();
        } else if (functionNum == 3) {
            editShopAddress();
        } else if (functionNum == 4) {
            editShopMasterId();
        }

        System.out.println("수정이 완료되었습니다.");
        System.out.println("변경 전 : " + originShop);
        System.out.println("변경 후 : " + shopInformationController.getShop());
    }

    public void editShopAddress() {
        System.out.println("수정할 가게 주소를 입력하세요.");
        String newAddress = sc.nextLine();

        shopInformationController.editShopAddress(newAddress);
    }

    public void editShopName() {
        System.out.println("수정할 가게 이름을 입력하세요.");
        String newName = sc.nextLine();

        shopInformationController.editShopName(newName);
    }

    public void editShopMasterId() {
        System.out.println("수정할 마스터 id을 입력하세요.");
        int newMasterId = Integer.parseInt(sc.nextLine());

        shopInformationController.editShopMasterId(newMasterId);
    }


    public void printCoffeeProducts() {
        shopProductController.getCoffeeList().forEach(System.out::println);
    }

    public void printBreadProducts() {
        shopProductController.getBreadList().forEach(System.out::println);
    }

}
