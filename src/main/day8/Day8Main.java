package day8;

public class Day8Main {

    public static void main(String[] args) {

        BootCodeProvider provider = new BootCodeProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day8\\inputDay8.txt");
        GameRepairer repairer = new GameRepairer(provider);
        BootCode bootCode = provider.getBootCode();
        Game game = new Game(bootCode);

        int gameResult = game.runGame();
        while (gameResult == -1) {
            game.setBootCode(repairer.getNewBootCode());
            gameResult = game.runGame();
        }

        System.out.println(gameResult);
    }
}
