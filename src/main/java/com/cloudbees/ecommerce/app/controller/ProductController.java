package com.cloudbees.ecommerce.app.controller;


import com.cloudbees.ecommerce.app.model.Product;
import com.cloudbees.ecommerce.app.pojoModel.DiscOrTaxComplaint;
import com.cloudbees.ecommerce.app.repository.ProductRepository;
import com.cloudbees.ecommerce.app.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller Class For The Product API Operations
 */
@RestController
@RequestMapping("cloudbees/")
public class ProductController {

    private static final Logger LOGGER = LogManager.getLogger(Product.class.getName());

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    /**
     * End Point To Add Product Data;
     *
     * @param product:- The Product
     * @return if true:- The HttpStatus with status OK
     * @return if false:- The HttpStatus with the status 404
     **/
    @PostMapping("createProduct/")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        try {
            LOGGER.debug("generating a new entry Product data..");
            productRepository.save(product);
            LOGGER.debug("product created and saved successfully..");
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error occurred during creating object:- " + product);
            return new ResponseEntity<>("error occurred during creating object:- " + product, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * End Point To Apply Product Discount;
     *
     * @param complaint:- The DiscOrTaxComplaint
     * @return if true:- The HttpStatus with status OK
     * @return if false:- The HttpStatus with the status 404
     **/
    @PostMapping("applyDiscount/")
    public ResponseEntity<Object> applyDiscount(@RequestBody DiscOrTaxComplaint complaint) {
        try {
            Long productId = complaint.getProductId();
            LOGGER.debug("fetching a product data..");
            Product product = (Product) productRepository.findByProductId(productId).get(0);
            LOGGER.debug("product retrieved successfully..");
            if (complaint.getDiscount().getDiscount() != 0.0) {
                LOGGER.debug("applying a discount amount for the product.");
                productService.applyDiscount(complaint.getDiscount(), product);
            }
            if (complaint.getTax().getTax() != 0.0) {
                LOGGER.debug("applying a tax amount for the product.");
                productService.applyTax(complaint.getTax(), product);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error occurred during discounting product of id:- " + complaint + " with:- " + e);
            return new ResponseEntity<>("error occurred during discounting product of id:- " + complaint, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * End Point To Fetch Product Data;
     *
     * @param productId:- The Long
     * @return if true:- The HttpStatus with status OK
     * @return if false:- The HttpStatus with the status 404
     **/
    @GetMapping("readProduct/{productId}/")
    public ResponseEntity<Object> readProduct(@PathVariable Long productId) {
        try {
            LOGGER.debug("fetching a product..");
            Product product = productService.getProduct(productId);
            LOGGER.debug("product fetched a successfully..");
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error occurred during fetching product of id:- " + productId + " with:- " + e);
            return new ResponseEntity<>("error occurred during fetching product of id:- " + productId + " with:- No record found for the given id", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * End Point To Update Product Data;
     *
     * @param product:- The Product
     * @return if true:- The HttpStatus with status OK
     * @return if false:- The HttpStatus with the status 404
     **/
    @PutMapping("updateProduct/")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        try {
            LOGGER.debug("updating a product..");
            Product updateProduct = productService.updateProduct(product);
            LOGGER.debug("product updated successfully..");
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error occurred during updating object:- " + product + " with:- " + e);
            return new ResponseEntity<>("error occurred during updating object:- " + product, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * End Point To Delete Product Data;
     *
     * @param productId:- The Long
     * @return if true:- The HttpStatus with status OK
     * @return if false:- The HttpStatus with the status 404
     **/
    @DeleteMapping("deleteProduct/")
    public ResponseEntity<Object> deleteProduct(@RequestParam("productId") Long productId) {
        try {
            LOGGER.debug("deleting a product..");
            Product product = productService.deleteProduct(productId);
            LOGGER.debug("product deleted successfully..");
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error occurred during deleting product of id:- " + productId + " with:- " + e);
            return new ResponseEntity<>("error occurred during deleting product of id:- " + productId, HttpStatus.BAD_REQUEST);
        }
    }
}
