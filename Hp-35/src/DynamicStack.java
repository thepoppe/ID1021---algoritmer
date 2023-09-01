public class DynamicStack extends Stack{
    private int[] stack;
    private int stackPointer;


    public DynamicStack(int arraySize){
        stack = new int[arraySize];
        stackPointer = -1;
    }

    public void push(int i) {
        if(stackPointer == stack.length-1){
            increaseStackSizeBy2x();
        }
        stack[++stackPointer] = i;
    }
    public int pop() {
        if (stackPointer < 0)
            throw new IllegalArgumentException("Stack is empty");

        if (stackPointer < stack.length/3 )
            decreaseStackSizeBy2x();

        return stack[stackPointer--];
    }

    private void increaseStackSizeBy2x() {
        int[] newStack = new int[(int) (stack.length * 2)];
        /*for (int i = 0; i < stack.length;i++){
            newStack[i] = stack[i];

        }*/
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
    private void decreaseStackSizeBy2x(){
        int[] newStack = new int[(stack.length /2)];
        /*for (int i = 0; i < newStack.length;i++){
            newStack[i] = stack[i];

        }*/
        System.arraycopy(stack, 0, newStack, 0, newStack.length);
        stack = newStack;
    }

}


