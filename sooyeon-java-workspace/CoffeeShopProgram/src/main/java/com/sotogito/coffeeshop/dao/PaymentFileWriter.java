package com.sotogito.coffeeshop.dao;


import com.sotogito.coffeeshop.model.Product;

import java.io.*;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class PaymentFileWriter {
    private final static String USER_PAYMENT_ORDERS_FORMAT = "%s,%d,%d\n";

    public void paymentFileSave(String userName, Map<Product, Integer> cartList) {
        File paymentFolder = new File("payment");
        if (!paymentFolder.exists()) {
            paymentFolder.mkdirs();
        }

        String fileName = userName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment\\" + fileName))) {

            for (Map.Entry<Product, Integer> entry : cartList.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                int amount = product.getPrice() * quantity;

                String line = String.format(USER_PAYMENT_ORDERS_FORMAT, product.getName(), amount, quantity);
                writer.write(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
