package lv.javaguru.java2.registration;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.user.BuildUserHelper;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.register.RegistrationInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by DMC on 1/6/2017.
 */

@Component
public class RegistrationService {

    @Autowired
    @Qualifier("RegistrationInput")
    InputDataParser<Map, RegistrationInputData> inputDataParser;

    @Autowired
    Registration registration;

    @Autowired
    RegistrationInputDataValidator inputDataValidator;

    @Autowired
    DataFormatter<RegistrationInputData, RegistrationInputData> registrationDataFormatter;

    @Autowired
    BuildUserHelper buildUserHelper;

    RegistrationInputData inputData;

    ModelAndView modelAndView;

    public void parseAndCollectInputData(Map inputData) {
        this.inputData = inputDataParser.parse(inputData);
    }

    public void process () {

        String view;
        Object data;

        try {
            inputDataValidator.validate(inputData);

            RegistrationInputData formattedInputData = registrationDataFormatter.format(inputData);

            User user = buildUserHelper
                .createUser()
                .withRegistrationInputData(formattedInputData)
                .build();

            registration.register(user);

            data = "User registered";
            view = "/addShoplistResult.jsp";

            modelAndView = new ModelAndView(data, view);
        } catch (ValidationException exception) {
            view = "/error.jsp";
            data = exception.getMessage();

            modelAndView = new ModelAndView(data, view);
        } catch (Exception exception) {
            view = "/error.jsp";
            data = "Error occurred during process shoplist";

            modelAndView = new ModelAndView(data, view);
        }
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }
}
