package com.sotogito.coffeeshop.view.printer;

import com.sotogito.coffeeshop.dto.PaymentDetailsDTO;

import java.util.List;

public class PaymentPrinter {
    private final static String PAYMENT_PRINTOUT = "%s님{\n  %s \n 총액 : %,d원}\n\n";
    private final static String DETAILS_PRINTOUT = "          %s | %,d개 | %,d원\n";

    public static String getPrintout(String name, List<PaymentDetailsDTO> details) {
        StringBuilder sb = new StringBuilder();
        int totalAmount = 0;

        for (PaymentDetailsDTO detail : details) {
            String productName = detail.productName();
            int amount = detail.amount();
            int quantity = detail.quantity();

            totalAmount += (amount * quantity);
            sb.append(String.format(DETAILS_PRINTOUT, productName, quantity, amount));
        }

        return String.format(PAYMENT_PRINTOUT, name, sb.toString(), totalAmount);
    }

}
