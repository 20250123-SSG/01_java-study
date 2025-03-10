package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;

import javax.swing.plaf.PanelUI;
import java.util.*;

public class Shop {
    private int masterId;
    private String name;
    private String address;

    private final EnumMap<ProductType, List<Product>> products = new EnumMap<>(ProductType.class);

    {
       List<Product> coffees = new ArrayList<>();
       List<Product> breads = new ArrayList<>();

       coffees.add(new Coffee("아아",200));
       coffees.add(new Coffee("라떼",221431200));
       coffees.add(new Coffee("아인슈페너",3259222));

       breads.add(new Bread("식빵",18));
       breads.add(new Bread("소금빵",40005));

       products.put(ProductType.COFFEE,coffees);
       products.put(ProductType.BREAD,breads);
    }

    public Shop() {
    }

    public Shop(int masterId, String name, String address) {
        this.masterId = masterId;
        this.name = name;
        this.address = address;
    }

    public Product findProductByName(String name) {
        return products.values().stream()
                .flatMap(List::stream) //todo
                .filter(product -> product.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 상품입니다.: " + name));
    }

    public void addProduct(Product product) {
        List<Product> result = products.get(product.getType());

        if(!result.contains(product)) {
            result.add(product);
            return;
        }
        throw new IllegalArgumentException("이미 존재하는 상품입니다.");
    }

    public List<Product> getCoffees() {
        return Collections.unmodifiableList(products.get(ProductType.COFFEE));
    }

    public List<Product> getBreads() {
        return Collections.unmodifiableList(products.get(ProductType.BREAD));
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
