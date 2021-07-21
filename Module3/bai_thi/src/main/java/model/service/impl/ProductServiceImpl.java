package model.service.impl;

import model.bean.Category;
import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public boolean addNewProduct(Product product) {
        return productRepository.addNewProduct(product);
    }

    @Override
    public List<Product> findByAll() {
        return productRepository.findByAll();
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        return false;
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Category> findByAllCategory() {
        return productRepository.findByAllCategory();
    }
}
