package lv.javaguru.java2.data.product;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
public class ProductInputData {
    String inputProductName;
    String inputProductCategory;

    public String getInputProductName() {
        return inputProductName;
    }

    public void setInputProductName(String inputProductName) {
        this.inputProductName = inputProductName;
    }

    public String getInputProductCategory() {
        return inputProductCategory;
    }

    public void setInputProductCategory(String inputProductCategory) {
        this.inputProductCategory = inputProductCategory;
    }
}
