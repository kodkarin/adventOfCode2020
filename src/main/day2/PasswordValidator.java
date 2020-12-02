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
}
