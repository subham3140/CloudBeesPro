package com.cloudbees.ecommerce.app.service;

import com.cloudbees.ecommerce.app.model.Product;
import com.cloudbees.ecommerce.app.pojoModel.Discount;
import com.cloudbees.ecommerce.app.pojoModel.Tax;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    /**
     * Method To Create Product;
     **/
    public Product createProduct(Product product);

    /**
     * Method To Apply Product Discount;
     **/
    public Product applyDiscount(Discount discount, Product product);

    /**
     * Method To Apply Product Tax;
     **/
    public Product applyTax(Tax tax, Product product);

    /**
     * Method To Fetch Product Data;
     **/
    public Product getProduct(Long productId);

    /**
     * Method To Update Product Data;
     **/
    public Product updateProduct(Product product);

    /**
     * Method To Delete Product Data;
     **/
    public Product deleteProduct(Long productId);

}
