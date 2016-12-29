package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by DMC on 11/23/2016.
 */
public class JDBCProductDAOImplTest extends DBUnitTestCase {

    private ProductDAO productDAO = new JDBCProductDAOImpl();

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
