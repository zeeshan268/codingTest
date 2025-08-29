package com.promotion.model;

public class Product {
    private String sku;
    private int price;

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }

    public Product(String sku, int price) {
        this.sku = sku;
        this.price = price;
    }



}
