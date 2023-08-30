public class DynamicStack extends Stack{
    private int[] memorySlot;
    private int stackPointer;


    public DynamicStack(int arraySize){
        memorySlot = new int[arraySize];
        stackPointer = -1;
    }

    public int pop() {
        if (stackPointer < 0)
            throw new IllegalArgumentException("Stack is empty");

        if (stackPointer < memorySlot.length/3 )
            decreaseStackSizeBy2x();

        return memorySlot[stackPointer--];

    }

    public void push(int i) {
        if(stackPointer == memorySlot.length-1){
            increaseStackSizeBy2x();
        }
        memorySlot[++stackPointer] = i;
    }

    private void increaseStackSizeBy2x() {
        int[] newStack = new int[(int) (memorySlot.length * 2)];
        System.arraycopy(memorySlot, 0, newStack, 0, memorySlot.length);
        memorySlot = newStack;
    }
    private void decreaseStackSizeBy2x(){
        int[] newStack = new int[(memorySlot.length /2)];
        System.arraycopy(memorySlot, 0, newStack, 0, newStack.length);
        memorySlot = newStack;
    }

}


