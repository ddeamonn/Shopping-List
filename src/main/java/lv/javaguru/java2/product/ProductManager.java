package lv.javaguru.java2.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.jdbc.ProductDAOImpl;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 11/25/2016.
 */
@Component
public class ProductManager {

    @Autowired
    ProductDAO productDAO;

    public void createProduct(Product product) throws RuntimeException {
        //ProductDAO productDAO = new ProductDAOImpl();
        productDAO.create(product);
    }

    public List<Product> getProducts() {
        //ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.getAll();
    }
}
