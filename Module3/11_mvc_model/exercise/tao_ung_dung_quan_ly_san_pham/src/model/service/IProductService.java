package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findByAll();
    Product findById (String id);
    void update (String id, Product product);
    void create (String id, Product product);
    void remove (String id);
}
