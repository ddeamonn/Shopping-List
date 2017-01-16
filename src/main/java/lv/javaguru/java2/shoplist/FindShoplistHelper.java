package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTranformer;
import lv.javaguru.java2.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by DMC on 1/16/2017.
 */

@Component
public class FindShoplistHelper {

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    @Qualifier("JPAProduct")
    ProductDAO productDAO;

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTranformer<User, UserDTO> userDTOTransformer;

    @Autowired
    @Qualifier("ShoplistEntityToDTO")
    DataTranformer<ShoplistEntityDTO, ShoplistEntity> shoplistEntityToDTOTransformer;

    @Transactional
    Collection<ShoplistEntityDTO> findAllUserShoplistOrders(UserDTO userDTO) {

        User user = userDTOTransformer.transform(userDTO);
        Collection<ShoplistEntity> shoplistEntities  = shoplistEntityDAO.getByUser(user);

        Collection<ShoplistEntityDTO> shoplistEntityDTOs = new HashSet<>();

        for (ShoplistEntity shoplistEntity : shoplistEntities) {
            ShoplistEntityDTO shoplistEntityDTO = shoplistEntityToDTOTransformer.transform(shoplistEntity);
            shoplistEntityDTOs.add(shoplistEntityDTO);
        }

        return shoplistEntityDTOs;
    }

    ShoplistEntityDTO findShoplistEntityByID(Long shoplistEntiryID) {
        ShoplistEntity shoplistEntity = shoplistEntityDAO.getById(shoplistEntiryID);

        return shoplistEntityToDTOTransformer.transform(shoplistEntity);
    }
}
