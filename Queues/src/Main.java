public class Main {

    public static void main(String[] args) {

        functionalityArrayQueueDynamicModulo();
    }

    private static void functionalityArrayQueueDynamicModulo() {
        SecondQueue queue = new SecondQueue();
        System.out.println("add: 1");
        System.out.println("add: 2");
        System.out.println("add: 3");
        queue.addModulo(1);
        queue.addModulo(2);
        queue.addModulo(3);
        System.out.println(queue.removeModulo());
        System.out.println(queue.removeModulo());
        System.out.println(queue.removeModulo());

        System.out.println("add: 10");
        queue.addModulo(10);
        System.out.println("add: 20");
        queue.addModulo(20);
        System.out.println("add: 30");
        queue.addModulo(30);
        System.out.println("add: 40");
        queue.addModulo(40);
        System.out.println("add: 50");
        queue.addModulo(50);
        System.out.println("add: 60");
        queue.addModulo(60);
    }
    private static void functionalityArrayQueueDynamic2() {
        SecondQueue queue = new SecondQueue();
        System.out.println("add: 1");
        System.out.println("add: 2");
        System.out.println("add: 3");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("add: 10");
        queue.add(10);
        System.out.println("add: 20");
        queue.add(20);
        System.out.println("add: 30");
        queue.add(30);
        System.out.println("add: 40");
        queue.add(40);
        System.out.println("add: 50");
        queue.add(50);
        System.out.println("add: 60");
        queue.add(60);
    }

    private static void functionalityArrayQueueDynamic() {
        SecondQueue queue = new SecondQueue();
        System.out.println("add: 1");
        queue.add(1);
        System.out.println("add: 2");
        queue.add(2);
        System.out.println("add: 3");
        queue.add(3);
        System.out.println("add: 4");
        queue.add(4);
        System.out.println("add: 5");
        queue.add(5);
        System.out.println("add: 6");
        queue.add(6);
        System.out.println("add: 7");
        queue.add(7);

    }

    private static void functionalityArrayQueueStatic2() {
        SecondQueue queue = new SecondQueue();
        System.out.println("add: 1");
        queue.add(1);
        System.out.println("add: 2");
        queue.add(2);
        System.out.println("add: 3");
        queue.add(3);
        System.out.println("add: 4");
        queue.add(4);
        System.out.println("add: 5");
        queue.add(5);
        System.out.println("Remove 5");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }

    private static void functionalityArrayQueueStatic() {
        SecondQueue queue = new SecondQueue();
        System.out.println("add: 1");
        System.out.println("add: 2");
        System.out.println("add: 3");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println("add: 4");
        System.out.println("add: 5");
        System.out.println("add: 6");
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println("add: 1");
        queue.add(1);
        System.out.println("add: 2");
        queue.add(2);
        System.out.println("add: 3");
        queue.add(3);
        System.out.println("add: 4");
        queue.add(4);
        System.out.println("add: 5");
        queue.add(5);
        System.out.println("add: 6");
        queue.add(6);
    }

    private static void functionalityBreadthFirst() {
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        for (int i : tree)
            System.out.println("next value " + i);
    }

    private static void functionalityTestQueue1() {
        FirstQueue queue = new FirstQueue();
        System.out.println("add: 1");
        System.out.println("add: 2");
        System.out.println("add: 3");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());


    }


}
