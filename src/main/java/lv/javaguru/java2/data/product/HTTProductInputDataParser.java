package lv.javaguru.java2.data.product;

import lv.javaguru.java2.data.InputDataParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("productInput")
public class HTTProductInputDataParser implements InputDataParser<Map, ProductInputData> {

    Logger logger =  Logger.getLogger(HTTProductInputDataParser.class);

    @Override
    public ProductInputData parse(Map requestMap) {

        ProductInputData productData = new ProductInputData();
        String[] productName = (String[])requestMap.get("pname");
        productData.setInputProductName(productName[productName.length-1]);

        String[] productCategory = (String[])requestMap.get("pcategory");
        productData.setInputProductCategory(productCategory[productCategory.length-1]);
        return productData;
    }
}
