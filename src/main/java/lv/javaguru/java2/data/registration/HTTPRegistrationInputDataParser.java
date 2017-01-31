package lv.javaguru.java2.data.registration;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("RegistrationInput")
public class HTTPRegistrationInputDataParser implements InputDataParser<Map, RegistrationInputData> {

    Logger logger =  Logger.getLogger(HTTPRegistrationInputDataParser.class);

    @Override
    public RegistrationInputData parse(Map requestMap) {

        RegistrationInputData inputData = new RegistrationInputData();

        String[] mail = (String[])requestMap.get("customerMail");
        inputData.setEmail(mail[mail.length-1]);

        String[] repeatMail = (String[])requestMap.get("repeatCustomerMail");
        inputData.setRepeatEmail(repeatMail[repeatMail.length-1]);

        String[] password = (String[])requestMap.get("customerPassword");
        inputData.setPassword(password[password.length-1]);

        String[] repeatPassword = (String[])requestMap.get("repeatCustomerPassword");
        inputData.setRepeatPassword(repeatPassword[repeatPassword.length-1]);

        return inputData;
    }
}
