public class StaticStack extends Stack {

    int[] memorySlot;
    int stackPointer;

    public StaticStack(int stackSize){
        memorySlot = new int[stackSize];
        stackPointer = -1;
    }

    public void push(int i) {
        if(stackPointer == memorySlot.length-1)
            throw new IllegalArgumentException("Stack is Full");

        memorySlot[++stackPointer] = i;
    }
    public int pop() {
        if (stackPointer < 0)
            throw new IllegalArgumentException("Stack is empty");

        return memorySlot[stackPointer--];
    }



}
