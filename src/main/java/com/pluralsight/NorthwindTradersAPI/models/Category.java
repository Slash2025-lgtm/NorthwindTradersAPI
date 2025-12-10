package com.pluralsight.NorthwindTradersAPI.models;

public class Category {
    private int categoryId;
    private String companyName;

    public Category(int categoryId, String companyName) {
        this.categoryId = categoryId;
        this.companyName = companyName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "--------- Product ---------" +
                "\n\tProduct ID: " + categoryId +
                "\n\tProduct Name: " + companyName + "\n";
    }
}
