package com.cloudbees.ecommerce.app.model;


import javax.persistence.*;

import lombok.*;


/**
 * The Product Model
 */
@Setter
@Getter
@Table(name = "product_table")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Product {

    /**
     * The Product Unique ID(Long)
     */
    @Id
    @Column(name = "product_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    /**
     * The Product Name(String)
     */
    private String name;

    /**
     * The Product Description(String)
     */
    private String description;

    /**
     * The Product Price(Double)
     */
    private Double price;


    /**
     * The Product Available Quantity(Integer)
     */
    private Integer quantityAvailable;


    /**
     * The Product String Representation(String)
     */
    @Override
    public String toString() {
        return "Product-" + getName();
    }

}
