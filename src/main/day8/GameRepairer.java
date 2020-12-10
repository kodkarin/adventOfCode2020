package day8;

public class GameRepairer {

    private BootCodeProvider provider;
    private int indexLastChanged;

    public GameRepairer(BootCodeProvider provider) {
        this.provider = provider;
        this.indexLastChanged = -1;
    }

    public BootCode getNewBootCode () {

        BootCode originalBootCode = provider.getBootCode();

        for (int i = indexLastChanged + 1; i < originalBootCode.getInstructions().size(); i++) {
            Instruction instruction = originalBootCode.getInstructionAtIndex(i);
            if (instruction.getOperation().equals("jmp")) {
                 return createNewBootCode(originalBootCode, "nop", i);
            } else if (instruction.getOperation().equals("nop")) {
                return createNewBootCode(originalBootCode, "jmp", i);
            }
        }
        return originalBootCode;
    }

    private BootCode createNewBootCode(BootCode bootCode, String operation, int index) {

        indexLastChanged = index;
        bootCode.getInstructionAtIndex(index).setOperation(operation);
        return bootCode;
    }
}
