package com.sotogito.coffeeshop.view.shop;

import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.dto.PaymentDetailsDTO;
import com.sotogito.coffeeshop.exception.payment.EmptyPaymentHistoryException;
import com.sotogito.coffeeshop.exception.user.NoSuchUserException;
import com.sotogito.coffeeshop.model.User;
import com.sotogito.coffeeshop.view.printer.PaymentPrinter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShopSalesManagementView {
    private final Scanner sc = new Scanner(System.in);
    private final ShopInformationController shopInformationController;
    private final UserController userController;

    public ShopSalesManagementView(ShopInformationController shopInformationController, UserController userController) {
        this.shopInformationController = shopInformationController;
        this.userController = userController;
    }


    public void run() {
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
        } catch (EmptyPaymentHistoryException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (String key : paymentDetails.keySet()) {
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
        } catch (EmptyPaymentHistoryException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (String key : paymentDetails.keySet()) {
            System.out.println(PaymentPrinter.getPrintout(key, paymentDetails.get(key)));
        }
        System.out.println("조회완료");
    }

}
