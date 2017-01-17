package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("UniqueUserRule")
public class UniqueShoplistNameRule implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "Shoppinglist name already is in use";

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    Session session;

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTransformer<User, UserDTO> userDTOTransformer;

    @Override
    public boolean validate(ShoplistInputData shoplistInputData) {

        try {
            String shoplistName = shoplistInputData.getShoplistName();
            UserDTO userDTO = session.getSessionUser();
            User user = userDTOTransformer.transform(userDTO);

            ShoplistEntity shoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);
            if (shoplistEntity == null ){
                return true;
            }
        } catch (NoResultException nre) {
            return true;
        }

        throw new ValidationException(ERROR_MESSAGE);
    }
}
