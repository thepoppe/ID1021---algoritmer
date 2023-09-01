public class MathOperation {
    private InputType type;
    private int value = 0;

    public MathOperation(InputType type) {
        this.type = type;
    }

    public MathOperation(InputType type, int value) {
        this.type = type;
        this.value = value;
    }

    public static MathOperation Value(int valueToAdd) {
        return new MathOperation(InputType.VALUE, valueToAdd);
    }

    public static MathOperation Mul() {
        return new MathOperation(InputType.MUL);
    }

    public static MathOperation Add() {
        return new MathOperation(InputType.ADD);
    }

    public static MathOperation Sub() {
        return new MathOperation(InputType.SUB);
    }

    public InputType getType() {
        return type;
    }

    public int getValue() {
        return this.value;
    }
}
