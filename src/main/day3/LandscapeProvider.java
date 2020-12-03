package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LandscapeProvider {

    private final String path;

    public LandscapeProvider(String path) {
        this.path = path;
    }

    public Landscape getLandscape() {

        List<String> input = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return new Landscape(input);
    }
}
