package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XMASAnalyzer {

    private List<Long> xmasData;

    public XMASAnalyzer(List<Long> xmasData) {
        this.xmasData = xmasData;
    }

    public long findEncryptionWeakness() {

        long invalidNumber = getInvalidNumber();
        List<Long> possibleCombination = new ArrayList<>();

        for (int i = 0; i < xmasData.indexOf(invalidNumber); i++) {
            long sum = 0;
            possibleCombination.clear();
            int numbers = 0;

            while (sum < invalidNumber) {

                long currentNumber = xmasData.get(i + numbers);
                numbers++;
                sum += currentNumber;
                possibleCombination.add(currentNumber);

                if (sum == invalidNumber) {
                    Collections.sort(possibleCombination);
                    return possibleCombination.get(0) + possibleCombination.get(possibleCombination.size() - 1);
                }
            }
        }
        return -1;
    }

    public long getInvalidNumber() {
        for (int i = 25; i < xmasData.size(); i++) {
            if (!isValidNumberAtPosition(i)) {
                return xmasData.get(i);
            }
        }
        return -1;
    }

    private boolean isValidNumberAtPosition(int index) {
        long sum = xmasData.get(index);
        for (int i = index - 25; i < index - 1; i++) {
            long number1 = xmasData.get(i);
            for (int j = i + 1; j < index; j++) {
                long number2 = xmasData.get(j);
                if ((number1 + number2) == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}
