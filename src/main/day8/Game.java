package day8;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private BootCode bootCode;
    private int accumulator;
    private int index;
    private List<Integer> indicesUsed;

    public Game(BootCode bootCode) {
        this.bootCode = bootCode;
        this.accumulator = 0;
        this.index = 0;
        this.indicesUsed = new ArrayList<>();
    }

    public void setBootCode(BootCode bootCode) {
        this.bootCode = bootCode;
    }

    public int runGame() {

        while (index != bootCode.getInstructions().size()) {
            if (!indicesUsed.contains(index)) {
                runInstruction(bootCode.getInstructionAtIndex(index));
            } else {
                accumulator = 0;
                index = 0;
                indicesUsed.clear();
                return -1;
            }
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
