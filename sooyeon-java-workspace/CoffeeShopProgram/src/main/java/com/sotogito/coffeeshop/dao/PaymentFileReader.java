package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.dto.PaymentDetailsDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentFileReader {

    public Map<String, List<PaymentDetailsDTO>> readAllPaymentDetails() {
        File paymentFolder = new File("payment");
        File[] paymentFileList = paymentFolder.listFiles();

        if (paymentFileList == null) {
            return  new HashMap<>();
        }

        Map<String, List<PaymentDetailsDTO>> result = new HashMap<>();

        for(File paymentFile : paymentFileList) {
            String fileName = paymentFile.getName();
            String userName = fileName.substring(0, fileName.indexOf("_"));

            List<PaymentDetailsDTO> paymentDetails = getUserPaymentDetails(result, userName);

            if(paymentDetails.isEmpty()) {
                result.put(userName, paymentDetails);
            }
            readByOneFile(paymentDetails, fileName);
        }
        return result;
    }

    private void readByOneFile( List<PaymentDetailsDTO> paymentDetails, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("payment\\" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for(String paymentLine : line.split("\n")) {
                    String[] token = paymentLine.split(",");

                    String productName = token[0];
                    int quantity = Integer.parseInt(token[1]);
                    int amount = Integer.parseInt(token[2]);

                    paymentDetails.add(new PaymentDetailsDTO(productName, quantity, amount));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private List<PaymentDetailsDTO> getUserPaymentDetails(Map<String, List<PaymentDetailsDTO>> result, String userName) {
        if(result.containsKey(userName)) {
            return result.get(userName);
        }
        return new ArrayList<>();
    }



}
