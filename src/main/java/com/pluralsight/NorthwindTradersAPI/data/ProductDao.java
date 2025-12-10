package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public List<Product> getSpecificProduct(int productId);
    public Product insert(Product product);
}