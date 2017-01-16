package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by DMC on 11/25/2016.
 */
@Component
public class ShoplistManager {

    @Autowired
    PopulateShoplistDataHelper dataHelper;

    @Autowired
    CreateShoplistHelper createShoplistHelper;

    @Autowired
    FindShoplistHelper findShoplistHelper;

    public ShoplistEntityDTO populateShoplistFromInputData(ShoplistInputData inputData) {
        return dataHelper.populateFromInputData(inputData);
    }

    public void createShoplist(ShoplistEntityDTO shoplist) throws RuntimeException {
        createShoplistHelper.create(shoplist);
    }

    public Collection<ShoplistEntityDTO> findUserShoplistOrders(UserDTO user) {
        return findShoplistHelper.findAllUserShoplistOrders(user);
    }

    public ShoplistEntityDTO findShoplistByID(Long shoplistID) {
        return findShoplistHelper.findShoplistEntityByID(shoplistID);
    }
}
