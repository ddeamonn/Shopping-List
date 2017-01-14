package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class AddShoplistController implements MVCController {

    @Autowired
    @Qualifier("shoplistInput")
    InputDataParser<Map, ShoplistInputData> inputDataParser;

    @Autowired
    ShoplistInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @Override
    public MVCModel processPost(HttpServletRequest req) {

        String view;
        Object data;

        try {
            ShoplistInputData inputData = inputDataParser.parse(req.getParameterMap());

            inputDataValidator.validate(inputData);

            ShoplistEntityDTO shoplistEntityDTO = shoplistManager.populateShoplistFromInputData(inputData);
            shoplistManager.createShoplist(shoplistEntityDTO);

            data = "Shopping list saved";
            view = "/addShoplistResult.jsp";
        } catch (ValidationException exception) {
            view = "/error.jsp";
            data = exception.getMessage();
        } catch (Exception exception) {
            exception.printStackTrace();
            view = "/error.jsp";
            data = "Error occurred during process shoplist";
        }

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

}
