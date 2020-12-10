package day9;

import java.util.List;

public class Day9Main {

    public static void main(String[] args) {
        InputProvider provider = new InputProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day9\\inputDay9.txt");

        List<Long> numbers = provider.getInput();
        XMASAnalyzer analyzer = new XMASAnalyzer(numbers);

        System.out.println(analyzer.getInvalidNumber());
    }
}
