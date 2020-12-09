package day8;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private BootCodeProvider provider;
    private BootCode bootCode;
    private int accumulator;
    private int index;
    private List<Integer> indicesUsed;

    public Game(BootCodeProvider provider) {
        this.provider = provider;
        this.bootCode = provider.getBootCode();
        this.accumulator = 0;
        this.indicesUsed = new ArrayList<>();
    }

    public int runGame() {
        while (!(indicesUsed.contains(index))) {
            runInstruction(bootCode.getInstructionAtIndex(index));
        }
        return accumulator;
    }

    private void runInstruction(Instruction instruction) {
        indicesUsed.add(index);

        String operation = instruction.getOperation();
        switch (operation) {
            case "acc":
                accumulator += instruction.getArgument();
                index++;
                break;
            case "jmp":
                index += instruction.getArgument();
                break;
            case "nop":
                index++;
                break;
            default:
        }
    }
}
