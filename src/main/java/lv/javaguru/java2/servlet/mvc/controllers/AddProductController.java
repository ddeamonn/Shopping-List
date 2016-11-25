package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.data.HTTPInputDataFacade;
import lv.javaguru.java2.data.InputDataFacade;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.product.ProductManager;

import javax.servlet.http.HttpServletRequest;

public class AddProductController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/error.jsp", "Incorrect request");
    };

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        String jspResult;
        String message = "";

        try {
            InputDataFacade inputData = new HTTPInputDataFacade(request);
            Product product = inputData.getProduct();

            ProductManager productManager = new ProductManager();
            productManager.createProduct(product);

            jspResult = "/addProductResult.jsp";

            message = "Product added successfully";
        } catch (Exception exception) {
            jspResult = "/error.jsp";

            message = "Error occurred during adding a product";
        }

        return new MVCModel(jspResult, message);
    }

}
