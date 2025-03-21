package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.controller.ShopProductController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.model.*;
import com.sotogito.coffeeshop.view.shop.ShopInformationEditView;
import com.sotogito.coffeeshop.view.shop.ShopProductManagementView;
import com.sotogito.coffeeshop.view.shop.ShopSalesManagementView;

import java.util.*;

public class AdministratorView {
    private final Scanner sc = new Scanner(System.in);

    private final ShopInformationEditView shopInformationEditView;
    private final ShopProductManagementView shopProductManagementView;
    private final ShopSalesManagementView shopSalesManagementView;

    public AdministratorView(
            ShopInformationController shopInformationController, ShopProductController shopProductController, UserController userController) {

        shopInformationEditView = new ShopInformationEditView(shopInformationController);
        shopProductManagementView = new ShopProductManagementView(shopProductController);
        shopSalesManagementView = new ShopSalesManagementView(shopInformationController, userController);
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
                    shopInformationEditView.run();
                    break;
                case 2:
                    shopProductManagementView.run();
                    break;
                case 3:
                    shopSalesManagementView.run();
                    break;
            }
        }
    }

}
