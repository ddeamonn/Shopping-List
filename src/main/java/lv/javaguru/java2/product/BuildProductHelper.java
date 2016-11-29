package lv.javaguru.java2.product;

import lv.javaguru.java2.data.DateUtils;
import lv.javaguru.java2.data.IPAddressUtils;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductBuilder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by DMC on 11/28/2016.
 */
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
