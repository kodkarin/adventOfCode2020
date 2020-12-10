package day9;

import java.util.List;

public class XMASAnalyzer {

    private List<Long> xmasData;

    public XMASAnalyzer(List<Long> xmasData) {
        this.xmasData = xmasData;
    }

    public Long getInvalidNumber() {
        for (int i = 25; i < xmasData.size(); i++) {
            if (!isValidNumberAtPosition(i)) {
                return xmasData.get(i);
            }
        }
        return 0L;
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
