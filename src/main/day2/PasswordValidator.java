package day2;

public class PasswordValidator {

    public boolean validatePassword(Password password) {

        String passwordString = password.getPassword();
        int numberOfLetter = 0;

        for(int i=0; i < passwordString.length(); i++)
        {    if (passwordString.charAt(i) == password.getPolicy().getLetter())
            numberOfLetter++;
        }
        return (numberOfLetter >= password.getPolicy().getMinValue() && numberOfLetter <= password.getPolicy().getMaxValue());
    }

    public boolean validatePasswordPartTwo(Password password) {

        String passwordString = password.getPassword();
        char letter = password.getPolicy().getLetter();

        boolean isMatchOne = matchAtPosition(passwordString, letter, password.getPolicy().getMinValue());
        boolean isMatchTwo = matchAtPosition(passwordString, letter, password.getPolicy().getMaxValue());

        return (isMatchOne != isMatchTwo);
    }

    private boolean matchAtPosition(String password, char letter, int position) {
        return (letter == password.charAt(position - 1));
    }
}
