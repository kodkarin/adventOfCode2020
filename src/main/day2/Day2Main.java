package day2;

import java.util.List;

public class Day2Main {

    public static void main(String[] args) {
        PasswordInputProvider provider = new PasswordInputProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day2\\inputDay2.txt");
        List<Password> passwords =  provider.getInput();
        PasswordValidator validator = new PasswordValidator();
        int numberOfValidPasswords = 0;

        for (Password password : passwords) {
            if (validator.validatePassword(password)) {
                numberOfValidPasswords++;
            }
        }

        System.out.println(numberOfValidPasswords);

    }
}
