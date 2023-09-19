public class Main {

    public static void main(String[] args) {
        Bench.firstTest();
        Bench.secondTest();

        LinkedStack stack = new LinkedStack();
        stack.push(5);
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Bench.thirdTest();
        Bench.fourthTest();
        Bench.allocationCost();
    }
}
