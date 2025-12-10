package com.pluralsight.NorthwindTradersAPI.control;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> productsGetAll() {
        return productDao.getAll();
    }

    @RequestMapping(path="/products/5", method = RequestMethod.GET)
    public List<Product> productGet5thProduct() {
        return productDao.get5thProduct();
    }
}
