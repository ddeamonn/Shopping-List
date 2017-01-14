package lv.javaguru.java2.product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DMC on 11/25/2016.
 */
@Component
public class ProductManager {

    @Autowired
    @Qualifier("JPAProduct")
    ProductDAO productDAO;

    public void createProduct(Product product) throws RuntimeException {
        productDAO.create(product);
    }

    public List<Product> getProducts() {
        return productDAO.getAll();
    }
}
