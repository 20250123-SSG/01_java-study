package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.exception.NoSuchProductException;
import com.sotogito.coffeeshop.exception.UserAmountShortException;
import com.sotogito.coffeeshop.exception.UserAmountShortThanMinPriceException;
import com.sotogito.coffeeshop.exception.UserAmountZeroException;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserView {
    private final Scanner sc = new Scanner(System.in);

    private final ShopController shopController;
    private final UserController userController;

    public UserView(ShopController shopController, UserController userController) {
        this.shopController = shopController;
        this.userController = userController;
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

    public void chargeAmount(User user) {
        System.out.println("금액을 충전하시겠나요? y/n");
        String input = sc.nextLine();

        try {
            if (input.equalsIgnoreCase("y")) {
                System.out.println("얼마를 충전하시겠어요?");
                int charging = sc.nextInt();
                sc.nextLine();

                userController.changeAmount(user, charging);
                System.out.println("충전이 완료되었습니다.");
                System.out.println(user);

            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("충전하지않습니다.");
            } else {
                System.out.println("존재하지 않는 기능입니다.");
            }

        } catch (InputMismatchException e) {
            System.out.println("금액을 숫자로 입력해주세요.");
            sc.nextLine(); //todo 왜지 왜 있어야하지
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void printUserInformation(User user) {
        System.out.println(user);
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
        //todo 일단 사용자가 구매 가능한 상태인지 확인해야함
        /**
         * 1. 상품의 최소 금액보다 큰지
         * 2. 금액이 0원인지
         * -> 상관 없나?
         */
        System.out.println("==커피==");
        shopController.getCoffeeList().forEach(System.out::println);
        System.out.println("==빵==");
        shopController.getBreadList().forEach(System.out::println);

        while (true) {
            try {
                System.out.println("구매할 상품을 입력해주세요.");
                System.out.println("구매를 멈추고 싶으면 -> 그만 <- 이라고 입력해주세요");

                String input = sc.nextLine().trim();
                if (input.equals("그만")) {
                    return;
                }
                userController.order(user, input);
                System.out.println("구매 성공");

            } catch (NoSuchProductException | UserAmountShortException e) {
                System.out.println(e.getMessage()); //상품이 존재하지 않을때는 그냥 계속 입력
            } catch (UserAmountZeroException | UserAmountShortThanMinPriceException e) {
                System.out.println(e.getMessage()); //돈이 부족하면 구매 중지
                return;
            }
            /**
             * - 구매 중단
             * 1. 잔액 0원
             * 2. 최소 금액 상품 > 잔액
             *
             * - 구매 재시도
             * 1. 지금 구매하려는 상품 금액 > 잔액
             */
        }
    }

}
