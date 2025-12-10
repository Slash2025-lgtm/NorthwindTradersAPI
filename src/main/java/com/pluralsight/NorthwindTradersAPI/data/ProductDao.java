package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public List<Product> get5thProduct();
    public void add(int productID, String productName, int categoryID, double unitPrice);
}