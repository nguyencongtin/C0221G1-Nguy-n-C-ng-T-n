package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Ipad", "5000", "White","America"));
        products.put(2, new Product(2, "Xiaomi", "7000", "Black","China"));
        products.put(3, new Product(3, "Bphone", "10000", "Black","Vietnam"));
        products.put(4, new Product(4, "Razer", "20000", "Red","America"));
        products.put(5, new Product(5, "Iphone", "25000", "Gold","America"));
        products.put(6, new Product(6, "Samsung", "15000", "Grey","Korea"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product>  searchByName(String name) {
        List<Product> productList= new ArrayList<>(products.values());
        List<Product> searchProduct= new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(name)){
                searchProduct.add(p);
            }
        }
        return searchProduct;
    }
}