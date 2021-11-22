package com.nab.icommerce.repository;

import com.nab.icommerce.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for brand persistence layer
 */
@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    List<Product> findProduct(String title, String category, String brand, String color) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        Predicate namePredicate = cb.equal(product.get("code"), "%" + title + "%");
        Predicate codePredicate = cb.like(product.get("name"), "%" + title + "%");
        cq.where(codePredicate, namePredicate);

        TypedQuery<Product> query = em.createQuery(cq);
        return query.getResultList();
    }
}
