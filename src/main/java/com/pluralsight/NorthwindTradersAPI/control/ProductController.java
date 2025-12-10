package com.pluralsight.NorthwindTradersAPI.control;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return productDao.getSpecificProduct(150);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product insertProduct (@RequestBody Product product) {
        return productDao.insert(product);
    }
}
