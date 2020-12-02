package day1;

public class Day1Main {

    public static void main(String[] args) {
        InputProvider inputProvider = new InputProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day1\\inputDay1.txt");
        ExpenseReport report = new ExpenseReport(inputProvider);
        System.out.println(report.getProduct());
        System.out.println(report.getTripleProduct());
    }
}
