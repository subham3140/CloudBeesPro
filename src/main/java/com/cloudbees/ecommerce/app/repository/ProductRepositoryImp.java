package com.cloudbees.ecommerce.app.repository;

import com.cloudbees.ecommerce.app.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository Interface Implementation For The Product API Operations
 */
@Repository
public class ProductRepositoryImp implements ProductCustomRepository {

    private static final Logger LOGGER = LogManager.getLogger(Product.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Repository Method To Fetch Product Data;
     *
     * @param productId:- The Long
     * @return list:- The List
     **/
    @Override
    public List findByProductId(long productId) {
        Query query;
        try {
            LOGGER.debug("fetching a product from in-build database..");
            query = entityManager.createNativeQuery("SELECT * FROM product_table " + "WHERE product_id = ?", Product.class);
            query.setParameter(1, productId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.debug("product data retrieval failed due to " + e);
            return new ArrayList();
        }
    }
}
