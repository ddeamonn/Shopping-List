package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistIDValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by DMC on 1/4/2017.
 */

@Controller
public class DoViewShoplistController {

    @Autowired
    Session session;

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    @Qualifier("shoplistInput")
    InputDataParser<Map, ShoplistInputData> inputDataParser;

    @Autowired
    @Qualifier("ShoplistIDRule")
    ShoplistIDValidator shoplistIDValidator;

    @RequestMapping(value = "doViewShoplist", method = { RequestMethod.POST } )
    public ModelAndView processPost(HttpServletRequest req) {

        ModelAndView modelAndView;

        try {
            ShoplistInputData inputData = inputDataParser.parse(req.getParameterMap());
            shoplistIDValidator.validate(inputData);

            Long shoplistID = Long.parseLong(inputData.getShoplistID());

            modelAndView = doFindShoplistAndRedirect(shoplistID);
        } catch (ValidationException exception) {
            modelAndView = doRedirectToValidationErrorPage(exception.getMessage());
        } catch(Exception exception) {
            exception.printStackTrace();
            modelAndView = doRedirectToErrorPage();
        }

        return modelAndView;
    }

    private ModelAndView doFindShoplistAndRedirect(Long shoplistID) {
        return new ModelAndView("viewshoppinglist", "record", shoplistManager.findShoplistByID(shoplistID));
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView("error", "error", errorMessage);
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error", "error", "Shoplist validation error occurred");
    }
}
