package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
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

        ModelAndView modelAndView;

        try {
            ShoplistInputData inputData = inputDataParser.parse(req.getParameterMap());

            inputDataValidator.validate(inputData);

            ShoplistEntityDTO shoplistEntityDTO = shoplistManager.populateShoplistFromInputData(inputData);
            shoplistManager.createShoplist(shoplistEntityDTO);

            modelAndView = doRedirectToResultPage();
        } catch (ValidationException exception) {
            modelAndView = doRedirectToValidationErrorPage(exception.getMessage());
        } catch (Exception exception) {
            modelAndView = doRedirectToErrorPage();
        }

        Object data = modelAndView.getData();
        String view = modelAndView.getView();
        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

    private ModelAndView doRedirectToResultPage() {
        return new ModelAndView("Shopping list saved", "/addShoplistResult.jsp");
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView(errorMessage, "/error.jsp");
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("Shoplist validation error occurred", "/error.jsp");
    }

}
