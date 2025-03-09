package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.AdministratorController;
import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;

import java.util.Scanner;

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
        manageShopInformation(user);
    }

    public void manageShopInformation(User user) {
        System.out.println("=====가게 정보 관리 페이지=====");
        while (true) {
            System.out.println("""
                    1. 가게 정보 조회
                    2. 가게 이름 수정
                    3. 가게 주소 수정
                    4. 가게 마스터 id 수정
                    0. 종료하기
                    """);
            try {
                int functionNum = Integer.parseInt(sc.nextLine());

                if (functionNum == 0) {
                    return;
                }
                if (functionNum == 1) {
                    printShopInformation();
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

    public void printShopInformation() {
        System.out.println(administratorController.getShop());
    }

}
