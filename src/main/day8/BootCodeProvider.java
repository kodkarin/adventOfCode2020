package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BootCodeProvider {

    private String path;

    public BootCodeProvider(String path) {
        this.path = path;
    }

    public BootCode getBootCode() {

        List<Instruction> instructions = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String instructionData = scanner.nextLine();
                Instruction newInstruction = createInstruction(instructionData);
                instructions.add(newInstruction);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return new BootCode(instructions);
    }

    private Instruction createInstruction(String instructionData) {

        String[] instructionParts = instructionData.split(" ");
        String operation = instructionParts[0];
        int argument = Integer.parseInt(instructionParts[1]);
        return new Instruction(operation, argument);
    }
}
