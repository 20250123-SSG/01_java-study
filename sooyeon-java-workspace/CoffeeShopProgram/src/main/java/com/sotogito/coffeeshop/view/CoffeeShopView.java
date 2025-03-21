package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.controller.ShopInformationController;
import com.sotogito.coffeeshop.controller.ShopProductController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.serivce.UserService;
import com.sotogito.coffeeshop.controller.UserOrderController;
import com.sotogito.coffeeshop.dao.*;
import com.sotogito.coffeeshop.exception.user.DuplicateIdException;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;
import com.sotogito.coffeeshop.serivce.ShopInformationService;
import com.sotogito.coffeeshop.serivce.ShopProductService;
import com.sotogito.coffeeshop.serivce.UserOrderService;

import java.util.Optional;
import java.util.Scanner;

public class CoffeeShopView {
    private final Scanner scanner = new Scanner(System.in);
    private final AdministratorView administratorView;
    private final UserView userView;

    private final UserController userController;
    private final UserOrderController userOrderController;
    private final ShopInformationController shopInformationController;
    private final ShopProductController shopProductController;

    public CoffeeShopView() {
        Shop shop = new Shop(1, "스타벅스", "평택");

        UserRepository userRepository = new UserRepository();
        UserOrderService orderManager = new UserOrderService();

        ShopInformationService shopInformationManager = new ShopInformationService(shop);
        UserService userService = new UserService(userRepository);
        ShopProductService productManager = new ShopProductService(shop);
        PaymentFileWriter fileMaker = new PaymentFileWriter();


        userController = new UserController(userService);
        userOrderController = new UserOrderController(orderManager, productManager);
        shopInformationController = new ShopInformationController(shopInformationManager);
        shopProductController = new ShopProductController(productManager);


        administratorView = new AdministratorView(shopInformationController, shopProductController, userController);
        userView = new UserView(userOrderController, shopProductController);
    }


    public void run() {
        while (true) {
            System.out.println("아이디 비번을 입력하세요. (완전히 종료하고 싶으면 -> 0 <- 을 입력하시오)");
            String id = scanner.nextLine();
            String pwd = scanner.nextLine();

            if (id.equals("0") || pwd.equals("0")) {
                return;
            }
            User user = getUser(id, pwd);
            System.out.printf("%s님 안녕하세요.\n", user.getName());

            checkAdmin(user);
        }
    }

    public void checkAdmin(User user) {
        if (user.getRole().equals(Role.ADMIN)) {
            administratorView.run(user);
        } else {
            userView.run(user);
        }
    }

    private User getUser(String id, String pwd) {
        Optional<User> foundUser = userController.login(id, pwd);

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

                return userController.join(id, pwd, name, amount);

            } catch (DuplicateIdException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("충전 금액은 숫자로 입력해주세요.");
            }
        }
    }

}
