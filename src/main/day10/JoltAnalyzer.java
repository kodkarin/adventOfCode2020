package day10;

import java.util.Collections;
import java.util.List;

public class JoltAnalyzer {

    private List<Integer> jolts;

    public JoltAnalyzer(List<Integer> jolts) {
        this.jolts = jolts;
    }

    public int analyzeJoltageDifferences() {

        Collections.sort(jolts);

        int oneJoltDifferences = 0;
        int threeJoltDifferences = 0;

        if (jolts.get(0) == 1) {
            oneJoltDifferences++;
        } else if (jolts.get(0) == 3) {
            threeJoltDifferences++;
        }

        for (int i = 0; i < jolts.size() - 1; i++) {
            if (jolts.get(i + 1) - jolts.get(i) == 1) {
                oneJoltDifferences++;
            }
            else if (jolts.get(i + 1) - jolts.get(i) == 3) {
                threeJoltDifferences++;
            }
        }
        return oneJoltDifferences * (threeJoltDifferences + 1);
    }
}
