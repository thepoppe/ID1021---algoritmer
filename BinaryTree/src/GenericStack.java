public class GenericStack<T> {
    private T[] stack;
    private int stackPointer;
    public GenericStack(){
        stack = (T[]) new Object[4];
        stackPointer = -1;
    }
    public void push(T i) {
        if(stackPointer == stack.length-1)
            increaseStackSizeBy2x();
        stack[++stackPointer] = i;
    }
    public T pop() {
        if (stackPointer < 0)
            throw new IllegalArgumentException("GenericStack is empty");
        if (stackPointer < stack.length/3 )
            decreaseStackSizeBy2x();
        return stack[stackPointer--];
    }
    public boolean isEmpty(){
        return stackPointer < 0;
    }
    private void increaseStackSizeBy2x() {
        T[] newStack = (T[]) new Object[(int) (stack.length * 2)];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
    private void decreaseStackSizeBy2x(){
        T[] newStack = (T[]) new Object[(stack.length / 2)];
        System.arraycopy(stack, 0, newStack, 0, newStack.length);
        stack = newStack;
    }
}

