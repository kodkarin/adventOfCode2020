package day4;

import java.util.List;

public class PassportValidator {

    private List<String> parametersToFind;

    public PassportValidator(List<String> parametersToFind) {
        this.parametersToFind = parametersToFind;
    }

    public boolean validate(String passportData) {

        for(String parameter : parametersToFind) {
            if (!passportData.contains(parameter + ":")) {
                return false;
            }
        }
        return true;
    }
}
