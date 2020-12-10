package day8;

public class Instruction {

    private String operation;
    private int argument;

    public Instruction(String operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getArgument() {
        return argument;
    }
}
