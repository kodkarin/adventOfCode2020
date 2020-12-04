package day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PassportValidatorTest {

    @Test
    public void validateReturnsTrueForValidData() {

        String data1 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f";
        String data2 = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";
        String data3 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022";
        String data4 = "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertTrue(validator.validate(data1));
        assertTrue(validator.validate(data2));
        assertTrue(validator.validate(data3));
        assertTrue(validator.validate(data4));
    }

    @Test
    public void validateReturnsFalseForInvalidBirthYear() {

        String data1 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:2003 hcl:#623a2f";
        String data2 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:19805 hcl:#623a2f";
        String data3 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:198a hcl:#623a2f";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidIssueYear() {

        String data1 = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2009 pid:896056539 hcl:#a97842 hgt:165cm";
        String data2 = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:201 pid:896056539 hcl:#a97842 hgt:165cm";
        String data3 = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2a14 pid:896056539 hcl:#a97842 hgt:165cm";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidExpirationYear() {

        String data1 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2031";
        String data2 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:20225";
        String data3 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2019";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidHeight() {

        String data1 = "iyr:2010 hgt:158in hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";
        String data2 = "iyr:2010 hgt:59cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";
        String data3 = "iyr:2010 hgt:158 hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidHairColor() {

        String data1 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2g";
        String data2 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f5";
        String data3 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:1623a2f";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidEyeColor() {

        String data1 = "eyr:2029 ecl:bla cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";
        String data2 = "eyr:2029 ecl:blur cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";
        String data3 = "eyr:2029 ecl:yellow cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }

    @Test
    public void validateReturnsFalseForInvalidPassportId() {

        String data1 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:5457662380 ecl:hzl eyr:2022";
        String data2 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:0545766238 ecl:hzl eyr:2022";
        String data3 = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766a38 ecl:hzl eyr:2022";

        PassportValidator validator = new PassportValidator(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        assertFalse(validator.validate(data1));
        assertFalse(validator.validate(data2));
        assertFalse(validator.validate(data3));
    }
}