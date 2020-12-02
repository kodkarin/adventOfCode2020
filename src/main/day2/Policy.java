package day2;

public class Policy {

    private int minValue;
    private int maxValue;
    private char letter;

    public Policy(String policyString) {
        setRules(policyString);
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    private void setRules(String policyString) {
        String[] firstParts = separateLetterFromNumbers(policyString);
        String[] minMaxValues = getSeparateNumbers(firstParts[0]);

        setMinValue(Integer.parseInt(minMaxValues[0]));
        setMaxValue(Integer.parseInt(minMaxValues[1]));
        setLetter(firstParts[1].trim().charAt(0));
    }

    private String[] separateLetterFromNumbers(String policy) {
        return policy.split(" ");
    }

    private String[] getSeparateNumbers(String minMaxValues) {
        return minMaxValues.split("-");
    }
}
