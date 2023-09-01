public class Calculator {
    MathOperation[] expression;
    int instructionPointer;
    Stack stack;

    public Calculator(MathOperation[] expression, Stack stack) {
        this.expression = expression;
        this.instructionPointer = 0;
        this.stack = stack;
    }
    public void setStack(Stack newStack){
        this.stack = newStack;
    }

    public void setExpression(MathOperation[] expression) {
        this.expression = expression;
        this.instructionPointer = 0;
    }
    //More code

    public int run() {
        while (instructionPointer < expression.length) {
            step();
        }
        return stack.pop();
    }

    public void step() {

        MathOperation nextOperation = expression[instructionPointer++];
        switch (nextOperation.getType()) {
            case ADD -> {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);

            }
            case SUB -> {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);

            }
            case MUL -> {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);

            }
            case DIV -> {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);

            }
            case VALUE -> {
                int value = nextOperation.getValue();
                stack.push(value);
            }
        }
    }
}