package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.domain.User;
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
    DataTransformer<User, UserDTO> userDTOTransformer;

    @Autowired
    @Qualifier("ShoplistEntityToDTO")
    DataTransformer<ShoplistEntityDTO, ShoplistEntity> shoplistEntityToDTOTransformer;

    @Autowired
    @Qualifier("ShoplistEntityWithOrderItemToDTO")
    DataTransformer<ShoplistEntityDTO, ShoplistEntity> shoplistEntityWithOrderItemToDTO;

    @Transactional(readOnly = true)
    Collection<ShoplistEntityDTO> findAllUserShoplistOrders(UserDTO userDTO) {

        User user = userDTOTransformer.transform(userDTO);
        Collection<ShoplistEntity> shoplistEntities  = shoplistEntityDAO.getByUser(user);
        Collection<ShoplistEntityDTO> shoplistEntityDTOs = new HashSet<>();

        shoplistEntities.forEach(shoplistEntity -> {
            ShoplistEntityDTO shoplistEntityDTO = shoplistEntityToDTOTransformer.transform(shoplistEntity);
            shoplistEntityDTOs.add(shoplistEntityDTO);
        });

        return shoplistEntityDTOs;
    }

    ShoplistEntityDTO findShoplistEntityByID(Long shoplistEntiryID) {
        ShoplistEntity shoplistEntity = shoplistEntityDAO.getWithOrderItemsById(shoplistEntiryID);

        return shoplistEntityWithOrderItemToDTO.transform(shoplistEntity);
    }


    Collection<ShoplistEntityDTO> findShoplistEntityByUserAndPeriod(UserDTO userDTO, Date startDate, Date endDate) {

        User user = userDTOTransformer.transform(userDTO);
        Collection<ShoplistEntity> shoplistEntities  = shoplistEntityDAO.getByUserAndPeriod(user, startDate, endDate);
        Collection<ShoplistEntityDTO> shoplistEntityDTOs = new HashSet<>();

        shoplistEntities.forEach(shoplistEntity -> {
            ShoplistEntityDTO shoplistEntityDTO = shoplistEntityToDTOTransformer.transform(shoplistEntity);
            shoplistEntityDTOs.add(shoplistEntityDTO);
        });

        return shoplistEntityDTOs;
    }
}
