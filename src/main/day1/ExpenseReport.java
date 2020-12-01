package day1;

import java.util.List;

public class ExpenseReport {

    private InputProvider provider;

    public ExpenseReport(InputProvider provider) {
        this.provider = provider;
    }

    public int getProduct() {

        List<Integer> expenses = provider.getInput();
        int sumToFind = 2020;
        for (int expense : expenses) {
            int matchingNumber = findMatchingNumber(expense, sumToFind, expenses);
            if ( matchingNumber != -1) {
                return expense * matchingNumber;
            }
        }
        return -1;
    }

    private int findMatchingNumber(int number, int sum, List<Integer> expenses) {
        for (int expense : expenses) {
            if (expense + number == sum) {
                return expense;
            }
        }
        return -1;
    }
}
