package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistDetails;

import java.util.List;

public interface ShoplistDetailsDAO {

    void create(ShoplistDetails shoplistDetails);

    ShoplistDetails getById(Long id);

    void delete(Long id);

    void update(ShoplistDetails shoplistDetails);

    List<ShoplistDetails> getAll();
}
