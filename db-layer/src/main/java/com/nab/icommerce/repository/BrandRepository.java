package com.nab.icommerce.repository;

import com.nab.icommerce.entity.Brand;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Repository for brand persistence layer
 */
@Repository
public class BrandRepository {

    @PersistenceContext
    private EntityManager em;

    List<Brand> findBrandsByCodeOrName(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);

        Root<Brand> brand = cq.from(Brand.class);
        Predicate namePredicate = cb.equal(brand.get("code"), "%" + title + "%");
        Predicate codePredicate = cb.like(brand.get("name"), "%" + title + "%");
        cq.where(codePredicate, namePredicate);

        TypedQuery<Brand> query = em.createQuery(cq);
        return query.getResultList();
    }
}
