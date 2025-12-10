package com.pluralsight.NorthwindTradersAPI.control;

import com.pluralsight.NorthwindTradersAPI.data.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao customerDAO) {
        this.categoryDao = customerDAO;
    }

    @RequestMapping(path="/category", method = RequestMethod.GET)
    public List<Category> getAllCustomers() {
        return categoryDao.getAll();
    }

    @RequestMapping(path="/category/17", method = RequestMethod.GET)
    public List<Category> Get1stCategory() {
        return categoryDao.get1stCategory();
    }

    @RequestMapping(path = "/category", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category insertCategory (@RequestBody Category category) {
        return categoryDao.insert(category);
    }
}