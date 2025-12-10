package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.models.Category;
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
public class JdbcCategoryDao implements CategoryDao {
    private List<Category> category;
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.category = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        this.category.clear();
        String query = "SELECT CategoryID, CategoryName \" +\n" +
                "                \"FROM Categories ";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                this.category.add(new Category(result.getInt(1), result.getString(2)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.category;
    }

    @Override
    public List<Category> get1stCategory() {
        this.category.clear();
        String query = "SELECT CategoryID, CategoryName " +
                "FROM Categories " +
                "WHERE categoryID = 1";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                this.category.add(new Category(result.getInt(1), result.getString(2)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.category;
    }

    @Override
    public void add(int categoryId, String companyName) {
        String query = "INSERT INTO Products (CategoryID, CompanyName) VALUES (?, ?);";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, categoryId);
                statement.setString(2, companyName);
            }
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
