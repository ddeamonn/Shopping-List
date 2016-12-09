package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by DMC on 11/23/2016.
 */
public class ProductDAOImplTest extends DBUnitTestCase {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/ProductDAOImplTest.xml";
    }

    @Test
    public void findAllProductTest() {
        List<Product> products = productDAO.getAll();
        boolean isProducts = products.size() > 0;
        assertTrue(isProducts);
    }
}
