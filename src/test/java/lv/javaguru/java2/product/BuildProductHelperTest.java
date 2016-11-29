package lv.javaguru.java2.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.domain.Product;
import org.junit.Test;

/**
 * Created by DMC on 11/28/2016.
 */
public class BuildProductHelperTest {

    @Test
    public void buildProductFromHelperTest() {

        String ipAddress = "127.0.0.1";

        ProductInputData inputData;
        inputData = new ProductInputData();
        inputData.setInputProductName("Milk");

        BuildProductHelper productHelper = new BuildProductHelper();
        Product product = productHelper
                .createProduct()
                .withInputData(inputData)
                .withIPAddress(ipAddress)
                .withCurrentAddedTime()
                .build();

        System.out.println("product:"+ product);
    }
}
