package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAll();
    public List<Category> get1stCategory();
    public void add(int categoryID, String companyName);
}