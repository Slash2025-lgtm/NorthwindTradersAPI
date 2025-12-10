package com.pluralsight.NorthwindTradersAPI.models;

public class Product {
    private int productId;
    private String productName, category;
    private double price;

    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "--------- Product ---------" +
                "\n\tProduct ID: " + productId +
                "\n\tProduct Name: " + productName +
                "\n\tCategory: " + category  +
                "\n\tPrice: " + price + "\n";
    }
}
