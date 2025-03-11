package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.controller.ShopProductController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.controller.UserOrderController;
import com.sotogito.coffeeshop.exception.*;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

import java.util.Map;
import java.util.Scanner;

public class UserView {
    private final Scanner sc = new Scanner(System.in);

    private final UserOrderController userOrderController;
    private final ShopProductController shopProductController;

    public UserView(UserOrderController userOrderController, ShopProductController shopProductController) {
        this.userOrderController = userOrderController;
        this.shopProductController = shopProductController;
    }

    public void run(User user) {
        System.out.println("========== 사용자 페이지입니다. ==========");
        while (true) {
            System.out.println("""
                    1. 사용자 정보 조회
                    2. 장바구니 조회
                    3. 메뉴 주문 하기
                    0. 종료하기
                    """);
            int functionNum = sc.nextInt();
            sc.nextLine();

            if (functionNum == 0) {
                return;
            }
            if (functionNum == 1) {
                printUserInformation(user);
                chargeAmount(user);
            } else if (functionNum == 2) {
                printCartList(user);
            } else if (functionNum == 3) {
                order(user);
            }
        }
    }

    public void printUserInformation(User user) {
        System.out.println(user);
    }

    public void chargeAmount(User user) {
        System.out.println("금액을 충전하시겠나요? y/n");
        String input = sc.nextLine();

        try {
            if (input.equalsIgnoreCase("y")) {
                System.out.println("얼마를 충전하시겠어요?");
                int charging = Integer.parseInt(sc.nextLine());

                userOrderController.changeAmount(user, charging);
                System.out.println("충전이 완료되었습니다.");
                System.out.println(user);

            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("충전하지않습니다.");
            } else {
                System.out.println("존재하지 않는 기능입니다.");
            }

        } catch (NumberFormatException e) {
            System.out.println("금액을 숫자로 입력해주세요.");
        } catch (MinimumChargeException e) {
            System.out.println(e.getMessage());
        }

    }


    public void printCartList(User user) {
        Map<Product, Integer> orders = user.getOrders();
        if (orders.isEmpty()) {
            System.out.println("장바구니가 비어있어요.");
        }
        for (Map.Entry<Product, Integer> entry : orders.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }

    public void order(User user) {
        try {
            userOrderController.validateCanPurchaseStatus(user);
        } catch (UserAmountZeroException | UserAmountShortThanMinPriceException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("==커피==");
        shopProductController.getCoffeeList().forEach(System.out::println);
        System.out.println("==빵==");
        shopProductController.getBreadList().forEach(System.out::println);

        while (true) {
            try {
                System.out.println("구매할 상품을 입력해주세요.");
                System.out.println("구매를 멈추고 싶으면 -> 그만 <- 이라고 입력해주세요");
                System.out.println("잔액 : " + userOrderController.getUserBalance(user));

                String input = sc.nextLine().trim();
                if (input.equals("그만")) {
                    return;
                }
                userOrderController.order(user, input);
                System.out.println("구매 성공");

            } catch (NoSuchProductException | UserAmountShortException e) {
                System.out.println(e.getMessage());
            } catch (UserAmountZeroException | UserAmountShortThanMinPriceException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

}
