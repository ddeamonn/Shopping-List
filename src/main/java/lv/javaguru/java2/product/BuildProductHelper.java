package lv.javaguru.java2.product;

import lv.javaguru.java2.utils.DateUtils;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductBuilder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
public class BuildProductHelper {

    ProductBuilder builder;

    public BuildProductHelper createProduct()    {

        this.builder = ProductBuilder.createProduct();
        return this;
    }

    public BuildProductHelper withInputData(ProductInputData inputData) {
        this.builder.withProductName(inputData.getInputProductName());
        this.builder.withProductCategory(inputData.getInputProductCategory());
        return this;
    }

    public BuildProductHelper withIPAddress(String ipAddress) {
        this.builder.withIPAddress(ipAddress);
        return this;
    }

    public BuildProductHelper withCurrentAddedTime() {
        Timestamp currentTime = DateUtils.getCurrentTimestamp();
        this.builder.withAddedTime(currentTime);
        return this;
    }

    public Product build () {
        return builder.build();
    }
}
