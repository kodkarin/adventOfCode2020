package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordInputProvider {

    private final String path;

    public PasswordInputProvider(String path) {
        this.path = path;
    }

    public List<Password> getInput() {
        List<Password> input = new ArrayList<>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                input.add(new Password(scanner.nextLine()));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return input;
    }
}
