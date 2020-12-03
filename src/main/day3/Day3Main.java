package day3;

public class Day3Main {

    public static void main(String[] args) {

        LandscapeProvider provider = new LandscapeProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day3\\inputDay3.txt");
        Trajectory trajectory = new Trajectory(3,1);
        TrajectoryAnalyzer analyzer = new TrajectoryAnalyzer(trajectory, provider);

        System.out.println(analyzer.getNumberOfOccurrences('#'));

    }
}
