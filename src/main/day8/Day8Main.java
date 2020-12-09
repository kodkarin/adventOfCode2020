package day8;

public class Day8Main {

    public static void main(String[] args) {
        BootCodeProvider provider = new BootCodeProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day8\\inputDay8.txt");
        Game game = new Game(provider);

        System.out.println(game.runGame());
    }
}
