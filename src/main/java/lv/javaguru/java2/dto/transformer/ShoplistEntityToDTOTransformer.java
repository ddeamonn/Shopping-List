package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("ShoplistEntityToDTO")
public class ShoplistEntityToDTOTransformer implements DataTransformer<ShoplistEntityDTO, ShoplistEntity> {

    @Autowired
    ShoplistEntityDTOBuilder shoplistEntityDTOBuilder;

    @Override
    public ShoplistEntityDTO transform(ShoplistEntity shoplistEntity) {
        ShoplistEntityDTO shoplistEntityDTO = shoplistEntityDTOBuilder
                .createShoplistEntity()
                .withShoplistID(shoplistEntity.getShoplistID())
                .withShoplistName(shoplistEntity.getShoplistName())
                .withAddedTime(shoplistEntity.getAddedTime())
                .build();

        return shoplistEntityDTO;
    }
}
