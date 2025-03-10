package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;

import java.util.List;

/**
 *  2) 가게 상품 관리
 *  	 	 2_1) 판매중인 커피 목록 조회
 *  		 2_2) 판매중인 빵 목록 조회
 *  		 2_3) 신규 커피 메뉴 추가
 *  			   ㄴ 동일한 이름, 동일한 가격 정보 조회시 추가 불가하도록 해놓았음
 *  		 2_4) 신규 빵 메뉴 추가
 *  			   ㄴ 동일한 이름, 동일한 가격 정보 조회시 추가 불가하도록 해놓았음
 */
public class ShopProductManager {
    private final Shop shop;

    public ShopProductManager(Shop shop) {
        this.shop = shop;
    }

    public List<Product> getCoffeeList(){
        return shop.getCoffees();
    }

    public List<Product> getBreadList(){
        return shop.getBreads();
    }

    public void addNewCoffeeProduct(Product product){
        shop.addProduct(product);
    }

    public Product findProductByName(String name){
        return shop.findProductByName(name);
    }

}
