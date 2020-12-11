package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoltProvider {

    private final String path;

    public JoltProvider(String path) {
        this.path = path;
    }

    public List<Integer> getInput() {
        List<Integer> input = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(Integer.parseInt(scanner.nextLine()));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        return input;
    }
}
