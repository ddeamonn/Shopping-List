package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.utils.IPAddressUtils;
import lv.javaguru.java2.data.InputDataException;
import lv.javaguru.java2.data.product.HTTProductInputDataParser;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.product.ProductInputDataParser;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.product.BuildProductHelper;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.validator.product.ProductInputDataValidator;
import lv.javaguru.java2.validator.product.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AddProductController implements MVCController {

    @Autowired
    ProductInputDataParser parser;

    @Autowired
    ProductManager productManager;

    @Autowired
    ProductInputDataValidator productDataValidator;

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/error.jsp", "Incorrect request");
    };

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        String jspResult;
        String message = "";

        try {
            ProductInputData inputData = parser.parse(request.getParameterMap());

            productDataValidator.validate(inputData);

            String ipAddress = IPAddressUtils.getIpAddressFromRequest(request);

            BuildProductHelper productHelper = new BuildProductHelper();
            Product product = productHelper
                    .createProduct()
                    .withInputData(inputData)
                    .withIPAddress(ipAddress)
                    .withCurrentAddedTime()
                    .build();

            productManager.createProduct(product);

            jspResult = "/addProductResult.jsp";

            message = "Product added successfully";
        } catch (ValidationException exception) {
            jspResult = "/error.jsp";
            message = exception.getMessage();
        } catch (InputDataException exception) {
            jspResult = "/error.jsp";
            message = "Error occurred during adding a product";
        } catch (Exception exception) {
            jspResult = "/error.jsp";
            message = "Error occurred during adding a product";
        }

        return new MVCModel(jspResult, message);
    }

}
