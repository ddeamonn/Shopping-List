package lv.javaguru.java2.data;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DMC on 11/25/2016.
 */
public class HTTPInputDataFacade implements InputDataFacade {

    HttpServletRequest request;

    public HTTPInputDataFacade(HttpServletRequest request) {
        this.request = request;
    }

    //String method = req.getMethod();

    @Override
    public Product getProduct() {
        String productName = request.getParameter("pname");

        ProductBuilder builder = ProductBuilder
                .createProduct()
                .withProductName(productName);

        return builder.build();
    }

    public void setReq(HttpServletRequest req) {
        this.request = req;
    }

}
