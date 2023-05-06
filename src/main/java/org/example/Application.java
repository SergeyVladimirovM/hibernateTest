package org.example;

import org.example.DAO.ProductDao;
import org.example.DAO.ProductDaoImpl;
import org.example.entity.Product;

public class Application {

    private static final ProductDao productDao = new ProductDaoImpl();

    public static void main(String[] args) {
        productDao.saveOrUpdate(new Product(5L, "Coca-Cola", 125));
        productDao.deleteById(6L);
        productDao.findAll().forEach(System.out::println);
        System.out.println(productDao.findById(0L));
    }
}