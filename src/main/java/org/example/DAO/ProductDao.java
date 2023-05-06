package org.example.DAO;

import org.example.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}
