package day3;

import java.util.List;

public class TrajectoryAnalyzer {

    private Trajectory trajectory;
    private LandscapeProvider provider;
    private List<String> landscapeMap;

    public TrajectoryAnalyzer(Trajectory trajectory, LandscapeProvider provider) {
        this.trajectory = trajectory;
        this.provider = provider;
        this.landscapeMap = provider.getLandscape().getLandscapeMap();
    }

    public int getNumberOfOccurrences(char characterToFind) {
        int number = 0;
        int x = trajectory.getXDistance();
        int y = trajectory.getYDistance();

        while (y < landscapeMap.size()) {
            char characterAtStop = landscapeMap.get(y).charAt(x);
            if (characterAtStop == characterToFind) {
                number++;
            }
            x += trajectory.getXDistance();
            if (x >= landscapeMap.get(y).length()) {
                doubleLandscapeWidth();
            }
            y +=trajectory.getYDistance();
        }
        return number;
    }

    private void doubleLandscapeWidth() {
        for (int i = 0; i < landscapeMap.size(); i++) {
            String row = landscapeMap.get(i);
            landscapeMap.set(i, row + row);
        }
    }
}
