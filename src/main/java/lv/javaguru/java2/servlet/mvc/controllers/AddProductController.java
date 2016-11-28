package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.data.product.HTTProductInputDataParser;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.product.ProductInputDataParser;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.validator.product.ProductInputDataValidator;

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

            ProductInputDataParser parser = new HTTProductInputDataParser(request);
            ProductInputData inputData = parser.parse();

            ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
            productDataValidator.validate(inputData);

            ProductManager productManager = new ProductManager();

            Product product = productManager.populateProduct(inputData);

            productManager.createProduct(product);

            jspResult = "/addProductResult.jsp";

            message = "Product added successfully";
        } catch (RuntimeException exception) {
            jspResult = "/error.jsp";
            message = exception.getMessage();
        } catch (Exception exception) {
            jspResult = "/error.jsp";
            message = "Error occurred during adding a product";
        }

        return new MVCModel(jspResult, message);
    }

}