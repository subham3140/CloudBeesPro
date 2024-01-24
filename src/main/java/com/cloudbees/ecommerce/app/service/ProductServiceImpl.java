package com.cloudbees.ecommerce.app.service;

import com.cloudbees.ecommerce.app.model.Product;
import com.cloudbees.ecommerce.app.pojoModel.Discount;
import com.cloudbees.ecommerce.app.pojoModel.Tax;
import com.cloudbees.ecommerce.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Method To Apply Product Discount;
     *
     * @param discount:- The Discount
     * @param product:-  The Product
     * @return product:- The Product
     **/
    @Override
    public Product applyDiscount(Discount discount, Product product) {
        product.setPrice(product.getPrice() - (product.getPrice() * discount.getDiscount() / 100));
        productRepository.save(product);
        return product;
    }

    /**
     * Method To Apply Product Tax;
     *
     * @param tax:-     The Tax
     * @param product:- The Product
     * @return product:- The Product
     **/
    @Override
    public Product applyTax(Tax tax, Product product) {
        product.setPrice(product.getPrice() + (product.getPrice() * tax.getTax() / 100));
        productRepository.save(product);
        return product;
    }

    /**
     * Method To Get Product Data;
     *
     * @param productId:- The Long
     * @return product:- The Product
     **/
    @Override
    public Product getProduct(Long productId) {
        return (Product) productRepository.findByProductId(productId).get(0);
    }

    /**
     * Method To Update Product Data;
     *
     * @param product:- The Product
     * @return product:- The Product
     **/
    @Override
    public Product updateProduct(Product product) {
        Product updateProduct = (Product) productRepository.findByProductId(product.getProductId()).get(0);
        updateProduct.setDescription(product.getDescription());
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setQuantityAvailable(product.getQuantityAvailable());
        productRepository.save(updateProduct);
        return updateProduct;
    }

    /**
     * Method To Delete Product Data;
     *
     * @param productId:- The Long
     * @return product:- The Product
     **/
    @Override
    public Product deleteProduct(Long productId) {
        Product product = (Product) productRepository.findByProductId(productId).get(0);
        productRepository.delete(product);
        return product;
    }
}
