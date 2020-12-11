package day10;

import java.util.Collections;
import java.util.List;

public class Day10Main {

    public static void main(String[] args) {

        JoltProvider provider = new JoltProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day10\\inputDay10.txt");
        List<Integer> jolts = provider.getInput();
        JoltAnalyzer analyzer = new JoltAnalyzer(jolts);

        System.out.println(analyzer.analyzeJoltageDifferences());

    }
}
