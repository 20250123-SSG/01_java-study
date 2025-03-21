package com.sotogito.coffeeshop.serivce;

import com.sotogito.coffeeshop.dao.PaymentFileWriter;
import com.sotogito.coffeeshop.exception.order.EmptyCartException;
import com.sotogito.coffeeshop.exception.order.UserAmountShortException;
import com.sotogito.coffeeshop.exception.order.UserAmountShortThanMinPriceException;
import com.sotogito.coffeeshop.exception.order.UserAmountZeroException;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;
import com.sotogito.coffeeshop.model.User;

import java.util.Map;


public class UserOrderService {
    private PaymentFileWriter paymentFileWriter = new PaymentFileWriter();

    public void chargeAmount(User user, int amount) {
        user.chargeAmount(amount);
    }


    public void addCartByOne(User user, Product product) {
        validateZeroAmount(user);
        validateOverAmountByMinProduct(user, Shop.getMinimumPrice());
        validateAmountAfterPurchase(user, product.getPrice());

        user.addCart(product);
    }

    public void purchase(User user) {
        if (user.isEmptyCart()) {
            throw new EmptyCartException("장바구니가 비어있어요.");
        }
        user.purchase();
        user.updatePaymentFile(paymentFileWriter);
        user.clearCart();
    }

    public Map<Product, Integer> getCart(User user) {
        Map<Product, Integer> orders = user.getOrders();
        if (orders.isEmpty()) {
            throw new EmptyCartException("장바구니가 비어있어요.");
        }
        return orders;
    }

    public void clearCart(User user) {
        user.clearCart();
    }


    public void validateOverAmountByMinProduct(User user, int minPrice) {
        if (!user.isOverAmountThanProductPrice(minPrice)) {
            throw new UserAmountShortThanMinPriceException("상품의 최소 금액보다 잔액이 부족합니다.");
        }
    }

    public void validateZeroAmount(User user) {
        if (user.isZeroAmount()) {
            throw new UserAmountZeroException("잔액이 없습니다.");
        }
    }

    private void validateAmountAfterPurchase(User user, int productPrice) {
        if (user.isNegativeAmountAfterPurchase(productPrice)) {
            throw new UserAmountShortException("해당상품을 구매할 잔액이 부족합니다.");
        }
    }

}
