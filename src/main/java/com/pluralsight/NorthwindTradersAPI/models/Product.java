package com.pluralsight.NorthwindTradersAPI.models;

public class Product {
    private int productId, categoryId;
    private String productName, category;
    private double price;

    public Product(int productId, String productName, int categoryId, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.category = category;
        this.price = price;
    }

    public Product(String productName, int categoryId, double price) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
    }

    public Product () {

    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
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
