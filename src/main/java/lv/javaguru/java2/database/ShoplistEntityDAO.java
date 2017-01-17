package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoplistDetails;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;

import java.util.Collection;
import java.util.List;

public interface ShoplistEntityDAO {

    void create(ShoplistEntity shoplistEntity);

    ShoplistEntity getById(Long id);

    ShoplistEntity getWithOrderItemsById(Long id);

    void delete(Long id);

    void update(ShoplistEntity shoplistEntity);

    List<ShoplistEntity> getAll();

    Collection<ShoplistEntity> getByUser(User user);

    ShoplistEntity getByNameAndUser(String name, User user);
}
