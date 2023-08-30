public class mathOperation {
    private InputType type;
    private int value = 0;

    public mathOperation(InputType type) {
        this.type = type;
    }

    public mathOperation(InputType type, int value) {
        this.type = type;
        this.value = value;
    }

    public static mathOperation Value(int valueToAdd) {
        return new mathOperation(InputType.VALUE, valueToAdd);
    }

    public static mathOperation Mul() {
        return new mathOperation(InputType.MUL);
    }

    public static mathOperation Add() {
        return new mathOperation(InputType.ADD);
    }

    public static mathOperation Sub() {
        return new mathOperation(InputType.SUB);
    }

    public InputType getType() {
        return type;
    }

    public int getValue() {
        return this.value;
    }
}
