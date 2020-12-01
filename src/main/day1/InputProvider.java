package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputProvider {
    private final String path;

    public InputProvider(String path) {
        this.path = path;
    }

    public List<Integer> getInput() {
        List<Integer> input = new ArrayList<>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                input.add(scanner.nextInt());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return input;
    }
}
