package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<String, Product> map = new HashMap<>();
    static {
        map.put("1",new Product("1","Ferrari",4444,"Black","America"));
        map.put("2",new Product("2","Lamboghrini",4444,"Black","Korea"));
        map.put("3",new Product("3","Mercedes",4444,"Black","Japan"));
        map.put("4",new Product("4","Kiamorning",4444,"Black","VietNam"));
        map.put("5",new Product("5","Limousine",4444,"Black","Singapore"));
    }
    public List<Product> findByAll(){
        return new ArrayList<>(map.values());
    }
    public void update(String id, Product product){
        map.put(id,product);
    }

    public Product findById(String id) {
        return map.get(id);
    }
    public void create(String id, Product product) {
        map.put(id,product);
    }
    public void remove(String id){
        map.remove(id);
    }

}
