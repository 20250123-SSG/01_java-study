package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.AdministratorController;
import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.controller.UserController;
import com.sotogito.coffeeshop.dao.*;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;

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
        System.out.println("아이디 비번을 입력하세요. ");
        String id = scanner.nextLine();
        String pwd = scanner.nextLine();

        User user = getUser(id, pwd);
        System.out.printf("%s님 안녕하세요.\n", user.getName());

        checkAdmin(user);


    }

    public void checkAdmin(User user) {
        if(user.isIdAdministrator()){
            administratorView.run(user);
        }else {
            userView.run(user);
        }
    }


    private User getUser(String id,String pwd) { //fixme view에 두는게 맞나?
        Optional<User> foundUser = shopController.login(id, pwd);

        if (foundUser.isEmpty()) {
            User newUser = createUser();
            shopController.join(newUser);
            return newUser;
        }
        return foundUser.get();
    }

    private User createUser() {
        System.out.println("가입하세요");
        System.out.println("아이디, 비번, 이름, 충전금액을 순서대로 입력하세요.");
        String id = scanner.nextLine();
        String pwd = scanner.nextLine();
        String name = scanner.nextLine();
        int amount = scanner.nextInt();
        scanner.nextLine();

        return new User(id, pwd, name, amount);
    }


}
