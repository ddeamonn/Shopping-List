package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.authorisation.AuthorisationContext;
import lv.javaguru.java2.authorisation.AuthorisationService;
import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistIDRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
public class DoViewShoplistController implements MVCController {

    @Autowired
    Session session;

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    @Qualifier("shoplistInput")
    InputDataParser<Map, ShoplistInputData> inputDataParser;

    @Autowired
    @Qualifier("ShoplistIDRule")
    ShoplistIDRule shoplistIDValidator;

    public MVCModel processPost(HttpServletRequest req) {

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

        Object data = modelAndView.getData();
        String view = modelAndView.getView();

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

    private ModelAndView doFindShoplistAndRedirect(Long shoplistID) {
        return new ModelAndView(shoplistManager.findShoplistByID(shoplistID), "/viewshoppinglist.jsp");
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView(errorMessage, "/error.jsp");
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("Shoplist validation error occurred", "/error.jsp");
    }
}
