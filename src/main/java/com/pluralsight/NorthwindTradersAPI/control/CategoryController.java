package com.pluralsight.NorthwindTradersAPI.control;

import com.pluralsight.NorthwindTradersAPI.data.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao customerDAO) {
        this.categoryDao = customerDAO;
    }

    @RequestMapping(path="/customers", method = RequestMethod.GET)
    public List<Category> getAllCustomers() {
        return categoryDao.getAll();
    }

    @RequestMapping(path="/products/17", method = RequestMethod.GET)
    public List<Category> productGet1stCategory() {
        return categoryDao.get1stCategory();
    }
}