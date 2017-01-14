package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;

import java.util.List;

public interface ProductDAO {

    void create(Product product);

    Product getById(Long id);

    Product getByName(String name);

    void delete(Long id);

    void update(Product product);

    List<Product> getAll();

}
