package lv.javaguru.java2.servlet.product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.jdbc.ProductDAOImpl;
import lv.javaguru.java2.domain.Product;

import java.util.List;

/**
 * Created by DMC on 11/25/2016.
 */
public class ProductManager {

    public ProductManager() {}

    public void createProduct(Product product) throws RuntimeException {
        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.create(product);
    }

    public List<Product> getProducts() {
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.getAll();
    }
}
