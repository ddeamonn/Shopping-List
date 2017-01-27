package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DoUpdateShoplistController {

    @Autowired
    @Qualifier("shoplistInput")
    InputDataParser<Map, ShoplistInputData> inputDataParser;

    @Autowired
    ShoplistInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @RequestMapping(value = "doUpdateShoplist", method = {RequestMethod.POST})
    public ModelAndView processPost(HttpServletRequest req) {

        ModelAndView modelAndView;

        try {
            ShoplistInputData inputData = inputDataParser.parse(req.getParameterMap());

            //inputDataValidator.validate(inputData);

            ShoplistEntityDTO shoplistEntityDTO = shoplistManager.populateShoplistFromInputData(inputData);
            shoplistManager.updateShoplistOrderItemStatus(shoplistEntityDTO);

            modelAndView = doRedirectToResultPage();
        } catch (ValidationException exception) {
            modelAndView = doRedirectToValidationErrorPage(exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
            modelAndView = doRedirectToErrorPage();
        }

        return modelAndView;
    }

    private ModelAndView doRedirectToResultPage() {
        return new ModelAndView("addShoplistResult", "info", "Shopping list updated");
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView("error", "error", errorMessage);
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error","error","Shoplist validation error occurred");
    }

}
