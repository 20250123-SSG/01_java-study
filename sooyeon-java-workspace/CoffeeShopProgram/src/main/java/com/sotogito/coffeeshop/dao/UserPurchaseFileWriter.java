package com.sotogito.coffeeshop.dao;


import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/*
만약 구매 결과가 하나의 파일에 모든 고객이 누적되어 저장되면 User를 매개변수로 받아서 처리하는 것을
고려할 수 있지만 곡개마다 개객이느이 파일이 생성된다면 User에 Writer를 중비해주는 방식도 괜찮다고 생각한다.
 */
public class UserPurchaseFileWriter {
    private final static String SALES_FILE_PATH = "";
    private final static String USER_PAYMENT_ORDERS_FORMAT = "%s : %d";

    public void paymentFileSave(String userName, Map<Product, Integer> cartList) {
        File paymentFolder = new File("payment");
        if (!paymentFolder.exists()) {
            paymentFolder.mkdirs();
        }

        String fileName = userName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".dat";


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("payment\\" + fileName))) {

            for (Map.Entry<Product, Integer> entry : cartList.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();

                out.writeObject(String.format(USER_PAYMENT_ORDERS_FORMAT, product.getName(), quantity));
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
