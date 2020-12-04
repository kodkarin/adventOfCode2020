package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PassportDataProvider {

    private final String path;

    public PassportDataProvider(String path) {
        this.path = path;
    }

    public List<String> getPassportData() {

        List<String> input = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            String passportData = "";

            while (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();
                if (!inputString.isBlank()) {
                    passportData += " " + inputString;
                } else {
                    input.add(passportData);
                    passportData = "";
                }
            }
            if(!passportData.equals("")) {
                input.add(passportData);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return input;
    }
}
