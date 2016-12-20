package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputDataParser;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Component
public class AddShoplistController implements MVCController {

    @Autowired
    ShoplistInputDataParser inputDataParser;

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

            ShoplistEntity shoplistEntity = shoplistManager.populateShoplistFromInputData(inputData);
            shoplistManager.createShoplist(shoplistEntity);

            data = "Shopping list saved";
            view = "/addShoplistResult.jsp";
        } catch (ValidationException exception) {
            view = "/error.jsp";
            data = exception.getMessage();
        } catch (Exception exception) {
            view = "/error.jsp";
            data = "Error" + exception.getMessage();
        }

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

}
