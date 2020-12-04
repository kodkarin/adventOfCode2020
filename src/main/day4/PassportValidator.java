package day4;

import java.util.Arrays;
import java.util.List;

public class PassportValidator {

    private List<String> parametersToFind;
    private static final String BIRTH_YEAR = "byr";
    private static final String ISSUE_YEAR = "iyr";
    private static final String EXPIRATION_YEAR = "eyr";
    private static final String HEIGHT = "hgt";
    private static final String HAIR_COLOR = "hcl";
    private static final String EYE_COLOR = "ecl";
    private static final String PASSPORT_ID = "pid";


    public PassportValidator(List<String> parametersToFind) {
        this.parametersToFind = parametersToFind;
    }

    public boolean validate(String passportData) {

        for(String parameter : parametersToFind) {
            if (!passportData.contains(parameter + ":")) {
                return false;
            }
        }
        return validateParameters(passportData);
    }

    private boolean validateParameters(String passportData) {
        return validateBirthYear(passportData) && validateIssueYear(passportData)
                && validateExpirationYear(passportData) && validateHeight(passportData)
                && validateHairColor(passportData) && validateEyeColor(passportData)
                && validatePassportId(passportData);
    }

    private boolean validateBirthYear(String passportData) {
        String birthYearString = getParameterData(BIRTH_YEAR, passportData);
        if(birthYearString.length() != 4) {
            return false;
        }
        try {
            int birthYear = Integer.parseInt(birthYearString);
            return (birthYear >= 1920 && birthYear <= 2002);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateIssueYear(String passportData) {
        String issueYearString = getParameterData(ISSUE_YEAR, passportData);
        if(issueYearString.length() != 4) {
            return false;
        }
        try {
            int issueYear = Integer.parseInt(issueYearString);
            return (issueYear >= 2010 && issueYear <= 2020);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateExpirationYear(String passportData) {
        String expirationYearString = getParameterData(EXPIRATION_YEAR, passportData);
        if(expirationYearString.length() != 4) {
            return false;
        }
        try {
            int expirationYear = Integer.parseInt(expirationYearString);
            return (expirationYear >= 2020 && expirationYear <= 2030);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateHeight(String passportData) {
        String height = getParameterData(HEIGHT, passportData);
        String unit = height.substring(height.length() - 2);
        if(isValidHeightUnit(unit)) {
            return isValidHeight(height.substring(0, height.length() - 2), unit);
        }
        return false;
    }

    private boolean validateHairColor(String passportData) {
        String hairColor = getParameterData(HAIR_COLOR, passportData);
        return hairColor.matches("^#[0-9a-f]{6}$");
    }

    private boolean validateEyeColor(String passportData) {
        List<String> validEyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        String eyeColor = getParameterData(EYE_COLOR, passportData);

        return validEyeColors.contains(eyeColor);
    }

    private boolean validatePassportId(String passportData) {
        String passportId = getParameterData(PASSPORT_ID, passportData);
        return (passportId.length() == 9 && isInteger(passportId));
    }

    private String getParameterData(String parameter, String passportData) {
        String[] parts = passportData.split(parameter + ":");
        String[] parts2 = parts[1].split(" ");
        return parts2[0];
    }

    private boolean isValidHeightUnit(String unit) {
        return (unit.equals("cm") || unit.equals("in"));
    }

    private boolean isValidHeight(String heightString, String unit) {
        int height;
        try {
           height = Integer.parseInt(heightString);
        } catch (NumberFormatException e) {
            return false;
        }

        if (unit.equals("cm")) {
            return (height >= 150 && height <= 193);
        } else if (unit.equals("in")) {
            return (height >= 59 && height <= 76);
        }
        return false;
    }

    private boolean isInteger(String possibleNumber) {
        try {
            Integer.parseInt(possibleNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
