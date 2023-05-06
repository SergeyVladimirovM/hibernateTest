package org.example.DAO;

import org.example.entity.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final EntityManagerFactory entityManagerFactory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();
    private final EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(em.createQuery("select p from Product p").getResultList());
    }

    @Override
    public Product findById(Long id) {
        Product product;

        em.getTransaction().begin();
        product = em.find(Product.class, id);
        em.getTransaction().commit();

        return product;
    }

    @Override
    public void deleteById(Long id) {
        try {
            em.remove(findById(id));
        } catch (IllegalArgumentException e) {
            System.out.println("Продукт не найден");
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        return product;
    }
}
