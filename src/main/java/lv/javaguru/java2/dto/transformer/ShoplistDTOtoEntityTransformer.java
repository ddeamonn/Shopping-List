package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */
@Component
@Qualifier("ShoplistDTOtoEntity")
public class ShoplistDTOtoEntityTransformer implements DataTransformer<ShoplistEntity, ShoplistEntityDTO> {

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTransformer<User, UserDTO> userDTOToEntityTransformer;

    @Override
    public ShoplistEntity transform(ShoplistEntityDTO dataDTO) {

        ShoplistEntity shoplistEntity = new ShoplistEntity();
        shoplistEntity.setShoplistID(dataDTO.getShoplistID());
        shoplistEntity.setShoplistName(dataDTO.getShoplistName());
        shoplistEntity.setAddedTime(dataDTO.getAddedTime());

        User user = userDTOToEntityTransformer.transform(dataDTO.getUserDTO());
        shoplistEntity.setUser(user);

        return shoplistEntity;
    }
}
