package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;
import com.sotogito.coffeeshop.exception.product.DuplicateProductException;
import com.sotogito.coffeeshop.exception.product.NoSuchProductException;
import com.sotogito.coffeeshop.model.products.Bread;
import com.sotogito.coffeeshop.model.products.Coffee;

import java.util.*;

public class Shop {
    private int masterId;
    private String name;
    private String address;
    private final EnumMap<ProductType, List<Product>> products = new EnumMap<>(ProductType.class);

    private static int minimumPrice;

    {
        List<Product> coffees = new ArrayList<>();
        List<Product> breads = new ArrayList<>();

        coffees.add(new Coffee("아아", 200));
        coffees.add(new Coffee("라떼", 221431200));
        coffees.add(new Coffee("아인슈페너", 3259222));

        breads.add(new Bread("식빵", 18));
        breads.add(new Bread("소금빵", 40005));

        products.put(ProductType.COFFEE, coffees);
        products.put(ProductType.BREAD, breads);

        minimumPrice = findMinimumPrice();
    }


    public Shop(int masterId, String name, String address) {
        this.masterId = masterId;
        this.name = name;
        this.address = address;
    }


    public void addProduct(Product product) {
        updateMinimumPrice(product);
        List<Product> result = products.get(product.getType());

        if (!result.contains(product)) {
            result.add(product);
            return;
        }
        throw new DuplicateProductException("이미 존재하는 상품입니다.");
    }

    public void removeProduct(Product product) {
        List<Product> result = products.get(product.getType());

        if (result.contains(product)) {
            result.remove(product);
            return;
        }
        throw new NoSuchProductException("존재하지 않는 상품입니다.");
    }

    public Product findProductByName(String name) {
        return products.values().stream()
                .flatMap(List::stream) //todo
                .filter(product -> product.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NoSuchProductException("존재하지 않는 상품입니다.: " + name));
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

    public Shop getOriginalShopContainInfo() {
        return new Shop(masterId, name, address);
    }

    public static int getMinimumPrice() {
        return minimumPrice;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "masterId=" + masterId +
                ", name='" + name + '\'' +
                ", address='" + address;
    }

    private void updateMinimumPrice(Product product) {
        if (product.getPrice() < minimumPrice) {
            minimumPrice = product.getPrice();
        }
    }

    public int findMinimumPrice() {
        List<Integer> productsPrice = new ArrayList<>();

        products.values().stream()
                .flatMap(List::stream)
                .forEach(product -> productsPrice.add(product.getPrice()));

        return Collections.min(productsPrice);
    }


}
