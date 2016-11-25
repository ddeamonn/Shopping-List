package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.product.ProductManager;

import javax.servlet.http.HttpServletRequest;

public class ViewProductController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        String view;
        Object data;

        try {
            ProductManager productManager = new ProductManager();
            data = productManager.getProducts();

            view = "/startpage.jsp";
        } catch (Exception exception) {
            view = "/error.jsp";
            data = "Error";
        }

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return null;
    }

}
