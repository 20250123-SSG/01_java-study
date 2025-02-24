package com.sotogito.practice7.run;

import com.sotogito.practice7.controller.ProductManager;
import com.sotogito.practice7.controller.ProductManager_ArrayList;

public class Application {
    public static void main(String[] args) {
        ProductManager_ArrayList productManager = new ProductManager_ArrayList();
        productManager.mainMenu();
    }
}
