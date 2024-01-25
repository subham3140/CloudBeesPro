package com.cloudbees.ecommerce.app.pojoModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The  Tax POJO Class
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tax {

    /**
     * The  tax amount(double)
     */
    public double tax;
}