package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

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

    @Autowired
    UpdateShoplistHelper updateShoplistHelper;

    @Autowired
    UpdateShoplistOrderItemHelper updateShoplistOrderItemStatusHelper;

    @Autowired
    DeleteShoplistHelper deleteShoplistHelper;

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

    public Collection<ShoplistEntityDTO> findUserShoplistOrdersByPeriod(UserDTO user, Date startDate, Date endDate) {
        return findShoplistHelper.findShoplistEntityByUserAndPeriod(user, startDate, endDate);
    }

    public void updateShoplist(ShoplistEntityDTO shoplist) throws RuntimeException {
        updateShoplistHelper.update(shoplist);
    }

    public void updateShoplistOrderItemStatus(ShoplistEntityDTO shoplist) throws RuntimeException {
        updateShoplistOrderItemStatusHelper.updateStatus(shoplist);
    }

    public void deleteShoplist(ShoplistEntityDTO shoplist) throws RuntimeException  {
        deleteShoplistHelper.delete(shoplist);
    }
}
