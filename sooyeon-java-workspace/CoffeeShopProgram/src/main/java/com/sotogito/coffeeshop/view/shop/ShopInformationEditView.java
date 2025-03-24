package com.sotogito.coffeeshop.view.shop;

import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.model.Shop;

import java.util.Scanner;

public class ShopInformationEditView {
    private final Scanner sc = new Scanner(System.in);
    private final ShopInformationController shopInformationController;

    public ShopInformationEditView(ShopInformationController shopInformationController) {
        this.shopInformationController = shopInformationController;
    }


    public void run() {
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

}
