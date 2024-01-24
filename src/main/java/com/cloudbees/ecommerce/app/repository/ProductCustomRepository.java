package com.cloudbees.ecommerce.app.repository;


import java.util.List;


/**
 * Custom Repository Interface For The Product API Operations
 */
public interface ProductCustomRepository {

    /**
     * Repository Method To Fetch Product Data;
     **/
    public List findByProductId(long id);
}
