package lv.javaguru.java2.data.product;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by DMC on 11/28/2016.
 */
public class HTTProductInputDataParser implements ProductInputDataParser {

    Logger logger =  Logger.getLogger(HTTProductInputDataParser.class);

    HttpServletRequest request;

    public HTTProductInputDataParser(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ProductInputData parse() {
        ProductInputData productData = new ProductInputData();
        productData.setInputProductName(request.getParameter("pname"));
        productData.setInputProductCategory(request.getParameter("pcategory"));
        return productData;
    }
}
