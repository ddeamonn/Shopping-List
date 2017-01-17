package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.dto.*;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by DMC on 12/21/2016.
 */
@Component
public class PopulateShoplistDataHelper {

    @Autowired
    Session session;

    ShoplistEntityDTO populateFromInputData(ShoplistInputData inputData) {
        String shoplistName = inputData.getShoplistName();
        String shopListID = inputData.getShoplistID();

        List<String> inputProductNames = (List<String>)inputData.getProductNames();
        List<String> inputQtyOfProducts = (List<String>)inputData.getProductQtys();
        List<String> inputPriceOfProducts = (List<String>)inputData.getProductPrices();

        ShoplistEntityDTO shoplistEntityDTO = ShoplistEntityDTOBuilder
                .createShoplistEntity()
                .withShoplistName(shoplistName)
                .withAddedTime(DateUtils.getCurrentTimestamp())
                .build();

        int i = 0;
        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        while (i < inputProductNames.size()) {
            String productName = inputProductNames.get(i);
            ProductDTO productDTO = ProductDTOBuilder
                    .createProduct()
                    .withProductName(productName)
                    .withAddedTime(DateUtils.getCurrentTimestamp())
                    .build();

            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setProduct(productDTO);
            Integer productQty = Integer.parseInt(inputQtyOfProducts.get(i));
            orderItemDTO.setProductQty(productQty);

            BigDecimal productPrice = new BigDecimal(inputPriceOfProducts.get(i));
            productPrice = productPrice.setScale(2,BigDecimal.ROUND_HALF_UP);

            orderItemDTO.setProductPrice(productPrice);
            orderItemDTOs.add(orderItemDTO);
            shoplistEntityDTO.setUserDTO(session.getSessionUser());
            i++;
        }

        shoplistEntityDTO.setOrderItemsDTO(orderItemDTOs);

        return shoplistEntityDTO;
    }
}
