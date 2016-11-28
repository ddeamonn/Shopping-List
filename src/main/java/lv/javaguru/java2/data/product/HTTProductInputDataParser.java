package lv.javaguru.java2.data.product;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DMC on 11/28/2016.
 */
public class HTTProductInputDataParser implements ProductInputDataParser {

    HttpServletRequest request;

    public HTTProductInputDataParser(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ProductInputData parse() {

        ProductInputData productData = new ProductInputData();
        productData.setProductName(request.getParameter("pname"));

        return productData;
    }
}
