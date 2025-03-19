package com.sotogito.serivce;

import com.sotogito.coffeeshop.dao.UserPurchaseFileWriter;
import com.sotogito.coffeeshop.exception.EmptyCartException;
import com.sotogito.coffeeshop.exception.UserAmountShortThanMinPriceException;
import com.sotogito.coffeeshop.exception.UserAmountZeroException;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;


public class UserOrderService {
    private UserPurchaseFileWriter userPurchaseFileWriter = new UserPurchaseFileWriter();

    public void chargeAmount(User user, int amount) {
        user.chargeAmount(amount);
    }

    ///  그냥 상품을 추가하기만 함
    public void addCartByOne(User user, Product product) {
        user.addCart(product);
    }

    ///  상품들 payment 파일에 저장
    /// 결제
    public void purchase(User user) {
        if(user.isEmptyCart()){
            throw new EmptyCartException("장바구니가 비어있어요.");
        }
        user.purchase();
        user.updatePurchaseFile(userPurchaseFileWriter);
        user.clearCart();
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

}
