package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        this.products.clear();
        String query = "SELECT P.ProductID, P.ProductName, C.CategoryName, P.UnitPrice " +
                "FROM Products AS P JOIN " +
                "Categories AS C ON (P.CategoryID = C.CategoryID) ";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                this.products.add(new Product(result.getInt(1), result.getString(2), result.getString(3),result.getDouble(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public List<Product> get5thProduct() {
        this.products.clear();
        String query = "SELECT P.ProductID, P.ProductName, C.CategoryName, P.UnitPrice " +
                "FROM Products AS P JOIN " +
                "Categories AS C ON (P.CategoryID = C.CategoryID) " +
                "WHERE P.ProductID = 5";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                this.products.add(new Product(result.getInt(1), result.getString(2), result.getString(3),result.getDouble(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void add(int productID, String productName, int categoryID, double unitPrice) {
        String query = "INSERT INTO Products (ProductID, ProductName, CategoryId, UnitPrice) VALUES (?, ?, ?, ?);";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, productID);
                statement.setString(2, productName);
                statement.setInt(3, categoryID);
                statement.setDouble(4, unitPrice);
            }
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
