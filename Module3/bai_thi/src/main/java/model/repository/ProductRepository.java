package model.repository;


import model.bean.Category;
import model.bean.Customer;
import model.bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<Product> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from san_pham");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 int productId=resultSet.getInt("id_san_pham");
                 String productName=resultSet.getString("ten_san_pham");
                 int productCost=resultSet.getInt("gia");
                 int productAmount=resultSet.getInt("so_luong");
                 String productColor=resultSet.getString("mau_sac");
                 String productDescription=resultSet.getString("mo_ta");
                 int productCategory=resultSet.getInt("danh_muc");
                Product product = new Product(productId,productName,productCost,productAmount,productColor,productDescription,productCategory);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public boolean addNewProduct(Product product) {
            Connection connection = baseRepository.connectDataBase();
            boolean check = false;
            try {
                CallableStatement callableStatement = connection.prepareCall("{call create_product(?,?,?,?,?,?)}");
                callableStatement.setString("p_ten_san_pham", product.getProductName());
                callableStatement.setInt("p_gia", product.getProductCost());
                callableStatement.setInt("p_so_luong", product.getProductAmount());
                callableStatement.setString("p_mau_sac", product.getProductColor());
                callableStatement.setString("p_mo_ta", product.getProductDescription());
                callableStatement.setInt("p_danh_muc", product.getProductCategory());
                check = callableStatement.executeUpdate() > 0;
                callableStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return check;
        }

    public boolean deleteProduct(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from san_pham where id_san_pham=?");
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Category> findByAllCategory() {
        Connection connection = baseRepository.connectDataBase();
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from danh_muc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id_danh_muc");
                String name=resultSet.getString("ten_danh_muc");
                categoryList.add(new Category(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public Product getProductById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from san_pham where id_san_pham=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId=resultSet.getInt("id_san_pham");
                String productName=resultSet.getString("ten_san_pham");
                int productCost=resultSet.getInt("gia");
                int productAmount=resultSet.getInt("so_luong");
                String productColor=resultSet.getString("mau_sac");
                String productDescription=resultSet.getString("mo_ta");
                int productCategory=resultSet.getInt("danh_muc");
                product = new Product(productId,productName,productCost,productAmount,productColor,productDescription,productCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> findByName(String name) {
        Connection connection = baseRepository.connectDataBase();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from san_pham where ten_san_pham like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId=resultSet.getInt("id_san_pham");
                String productName=resultSet.getString("ten_san_pham");
                int productCost=resultSet.getInt("gia");
                int productAmount=resultSet.getInt("so_luong");
                String productColor=resultSet.getString("mau_sac");
                String productDescription=resultSet.getString("mo_ta");
                int productCategory=resultSet.getInt("danh_muc");
                Product product = new Product(productId,productName,productCost,productAmount,productColor,productDescription,productCategory);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
