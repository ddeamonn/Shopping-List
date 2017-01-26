package lv.javaguru.java2.registration;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.user.BuildUserHelper;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.register.RegistrationInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

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

        try {
            inputDataValidator.validate(inputData);

            RegistrationInputData formattedInputData = registrationDataFormatter.format(inputData);

            User user = buildUserHelper
                .createUser()
                .withRegistrationInputData(formattedInputData)
                .withCurrentAddedTime()
                .build();

            registration.register(user);

            modelAndView = doRedirectToResultPage();
        } catch (ValidationException exception) {
            modelAndView = doRedirectToValidationErrorPage(exception.getMessage());
        } catch (Exception exception) {
            modelAndView = doRedirectToErrorPage();
        }
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }

    private ModelAndView doRedirectToResultPage() {
        return new ModelAndView("addShoplistResult", "info", "User registered");
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView("error", "error", errorMessage);
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error", "error" , "Registration validation error occurred");
    }
}
