package com.cloudbees.ecommerce.app.pojoModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Complaint POJO Model For The Discount Tax Operations
 */
@NoArgsConstructor
@Getter
@Setter
public class DiscOrTaxComplaint {
    /**
     * The Product ID
     */
    public Long productId;

    /**
     * The Discount Object
     */
    public Discount discount;

    /**
     * The Tax Object
     */
    public Tax tax;
}
