package day3;

import java.util.ArrayList;
import java.util.List;

public class Day3Main {

    public static void main(String[] args) {

        LandscapeProvider provider = new LandscapeProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day3\\inputDay3.txt");

        //part one
        Trajectory trajectory = new Trajectory(3,1);
        TrajectoryAnalyzer analyzer = new TrajectoryAnalyzer(trajectory, provider);

        System.out.println(analyzer.getNumberOfOccurrences('#'));

        //part two
        List<Trajectory> trajectories = new ArrayList<>();
        Trajectory trajectory1 = new Trajectory(1,1);
        Trajectory trajectory2 = new Trajectory(3,1);
        Trajectory trajectory3 = new Trajectory(5,1);
        Trajectory trajectory4 = new Trajectory(7,1);
        Trajectory trajectory5 = new Trajectory(1,2);
        trajectories.add(trajectory1);
        trajectories.add(trajectory2);
        trajectories.add(trajectory3);
        trajectories.add(trajectory4);
        trajectories.add(trajectory5);

        long result = 1;
        for (Trajectory trajectoryToUse : trajectories) {
            analyzer.setTrajectory(trajectoryToUse);
            int numberOfTrees = analyzer.getNumberOfOccurrences('#');
            result *= numberOfTrees;
        }
        System.out.println(result);
    }
}
