package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.AdministratorController;
import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.dao.*;
import com.sotogito.coffeeshop.exception.DuplicateIdException;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class CoffeeShopView {
    private final Scanner scanner = new Scanner(System.in);
    private final AdministratorView administratorView;
    private final UserView userView;

    private final ShopController shopController;
    private final AdministratorController administratorController;
    private final UserController userController;

    public CoffeeShopView() {
        Shop shop = new Shop(1, "스타벅스", "평택");

        UserRepository ur = new UserRepository();
        UserOrderManager orderManager = new UserOrderManager();

        ShopInformationEditor shopEditor = new ShopInformationEditor(shop);
        ShopProductManager productManager = new ShopProductManager(shop);
        ShopSalesFileMaker fileMaker = new ShopSalesFileMaker();


        shopController = new ShopController(productManager, ur);
        administratorController = new AdministratorController(shopEditor, productManager, fileMaker);
        userController = new UserController(orderManager, productManager);

        administratorView = new AdministratorView(shopController, administratorController);
        userView = new UserView(shopController, userController);
    }

    public void run() {
        while (true) {
            System.out.println("아이디 비번을 입력하세요. (완전히 종료하고 싶으면 -> 0 <- 을 입력하시오)");
            String id = scanner.nextLine();
            String pwd = scanner.nextLine();

            if(Objects.equals(id, "0") || pwd.equals("0")){
                return;
            }
            User user = getUser(id, pwd);
            System.out.printf("%s님 안녕하세요.\n", user.getName());

            checkAdmin(user);
        }
    }

    public void checkAdmin(User user) {
        if (user.isIdAdministrator()) {
            administratorView.run(user);
        } else {
            userView.run(user);
        }
    }

    private User getUser(String id, String pwd) {
        Optional<User> foundUser = shopController.login(id, pwd);

        if (foundUser.isEmpty()) {
            return createUser();
        }
        return foundUser.get();
    }

    private User createUser() {
        while (true) {
            try {
                System.out.println("가입하세요");
                System.out.println("아이디, 비번, 이름, 충전금액을 순서대로 입력하세요.");
                String id = scanner.nextLine();
                String pwd = scanner.nextLine();
                String name = scanner.nextLine();
                int amount = Integer.parseInt(scanner.nextLine());

                return shopController.join(id, pwd, name, amount);

            } catch (DuplicateIdException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("충전 금액은 숫자로 입력해주세요.");
            }
        }
    }

}
