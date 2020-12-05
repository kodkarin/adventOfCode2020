package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardingPassDataProvider {

    private String path;

    public BoardingPassDataProvider(String path) {
        this.path = path;
    }

    public List<BoardingPass> getBoardingPassData() {

        List<BoardingPass> input = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(new BoardingPass(scanner.nextLine()));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return input;
    }
}
