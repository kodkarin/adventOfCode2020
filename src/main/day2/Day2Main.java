package day2;

import java.util.List;

public class Day2Main {

    public static void main(String[] args) {
        PasswordInputProvider provider = new PasswordInputProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day2\\inputDay2.txt");
        List<Password> passwords =  provider.getInput();
        PasswordValidator validator = new PasswordValidator();

        System.out.println(getNumberOfValidPasswordsPart1(passwords, validator));
        System.out.println(getNumberOfValidPasswordsPart2(passwords, validator));
    }

    public static int getNumberOfValidPasswordsPart1(List<Password> passwords, PasswordValidator validator) {
        int numberOfValidPasswords = 0;

        for (Password password : passwords) {
            if (validator.validatePassword(password)) {
                numberOfValidPasswords++;
            }
        }
        return numberOfValidPasswords;
    }

    public static int getNumberOfValidPasswordsPart2(List<Password> passwords, PasswordValidator validator) {
        int numberOfValidPasswords = 0;

        for (Password password : passwords) {
            if (validator.validatePasswordPartTwo(password)) {
                numberOfValidPasswords++;
            }
        }
        return numberOfValidPasswords;
    }
}
