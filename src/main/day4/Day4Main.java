package day4;

import java.util.Arrays;
import java.util.List;

public class Day4Main {

    public static void main(String[] args) {

        PassportDataProvider provider = new PassportDataProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day4\\inputDay4.txt");
        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
        List<String> passports = provider.getPassportData();
        int validPassports = 0;

        for (String passport : passports) {
            if(validator.validate(passport)) {
                validPassports++;
            }
        }
        System.out.println(validPassports);
    }
}
