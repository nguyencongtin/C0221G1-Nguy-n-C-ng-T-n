package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findByAll() {
        return productRepository.findByAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void create(String id,Product product) {
        productRepository.create(id,product);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }

}
