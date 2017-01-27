package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.product.BuildProductHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static lv.javaguru.java2.domain.ProductBuilder.createProduct;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by DMC on 1/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, WebMVCConfig.class} )
@WebAppConfiguration
public class ProductDAOImplTest {

    @Autowired
    @Qualifier("JPAProduct")
    private ProductDAO productDAO;

    @Autowired
    BuildProductHelper buildProductHelper;

    @Test
    public void testCreate() throws Exception {

        String productName = "Milk";
        String ipAddress = "127.0.0.1";

        ProductInputData inputData;
        inputData = new ProductInputData();
        inputData.setInputProductName(productName);

        BuildProductHelper productHelper = new BuildProductHelper();
        Product product = productHelper
                .createProduct()
                .withInputData(inputData)
                .withIPAddress(ipAddress)
                .withCurrentAddedTime()
                .build();

        Product dbProduct = productDAO.getByName(productName);

        if (dbProduct != null) {
            productDAO.delete(dbProduct.getProductId());
        }

        productDAO.create(product);
        Product productFromDB = productDAO.getByName(product.getProductName());
        assertNotNull(productFromDB);
        assertEquals(product.getProductName(), productFromDB.getProductName());
    }
}
