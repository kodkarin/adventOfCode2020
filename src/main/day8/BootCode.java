package day8;

import java.util.List;

public class BootCode {

    private List<Instruction> instructions;

    public BootCode(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public Instruction getInstructionAtIndex(int index) {
        return instructions.get(index);
    }
}
