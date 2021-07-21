package model.service;

import model.bean.Category;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    boolean addNewProduct(Product product);
    List<Product> findByAll();
    boolean deleteProduct(int id);
    boolean updateProduct(int id, Product product);
    Product getProductById(int id);
    List<Product> findByName(String name);
    List<Category> findByAllCategory();
}
