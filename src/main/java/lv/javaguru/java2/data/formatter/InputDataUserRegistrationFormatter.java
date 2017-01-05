package lv.javaguru.java2.data.formatter;

import lv.javaguru.java2.data.formatter.formatters.RegistrationPasswordHashFormatter;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
public class InputDataUserRegistrationFormatter implements DataFormatter<RegistrationInputData, RegistrationInputData> {

    @Autowired
    @Qualifier("PasswordFormatter")
    DataFormatter<String, String> passwordFormatter;

    public RegistrationInputData format(RegistrationInputData inputData) {

        RegistrationInputData formattedInputData = new RegistrationInputData();
        formattedInputData.setEmail(inputData.getEmail());

        String password = inputData.getPassword();
        formattedInputData.setPassword(passwordFormatter.format(password));

        return formattedInputData;
    }
}
