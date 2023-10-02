import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] sizes = {500,1000,2000,4000,8000,16000};
        int  rounds = 10000;
        functionalityTestIterator();
    }


    private static void functionalityTestIterator(){
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
    private static void functionalityPrinting() {
        BinaryTree tree = setUpTree(50);
        tree.root.print();
    }


    private static void functionalityTestBST(){
        BinaryTree tree = new BinaryTree();

        System.out.println("Valid keys 10,9,8,7,11,12");
        tree.add(10,100);
        tree.add(9,90);
        tree.add(7,70);
        tree.add(8,80);
        tree.add(12,120);
        tree.add(11,110);

        System.out.println("Key 6 -> "+ tree.lookup(6));
        System.out.println("Key 10 -> "+ tree.lookup(10));
        System.out.println("Key 9 -> "+ tree.lookup(9));
        System.out.println("Key 8 -> "+ tree.lookup(8));
        System.out.println("Key 7 -> "+ tree.lookup(7));
        System.out.println("Key 11 -> "+ tree.lookup(11));
        System.out.println("Key 12 -> "+ tree.lookup(12));
        System.out.println("Key 13 -> "+ tree.lookup(13));
    }

    private static void firstTest(int[] sizes, int rounds) {
        System.out.println("Test starts");
        System.out.printf("%10s%15s\n" ,"Size", "Search tree" );
        System.gc();
        double minTime, t0, t1, time;

        //testing each size
        for (int size : sizes) {
            BinaryTree tree = setUpTree(size);
            Integer[] listOfKeys = setUpKeys(size);
            minTime = Double.POSITIVE_INFINITY;

            //Warmup
            for (int key : listOfKeys)
                tree.lookup(key);

            //Test starts
            for (int i = 0; i < rounds; i++) {
                t0 = System.nanoTime();
                for (int key : listOfKeys)
                    tree.lookup(key);
                t1 = System.nanoTime();
                time = (t1 - t0) / listOfKeys.length;

                if (time < minTime)
                    minTime = time;
            }
            System.out.printf("%10d%15.1f\n" ,size, minTime );
        }
        System.out.println("Test Over");
    }


    private static Integer[] setUpKeys(int size) {
        Integer[] keys = new Integer[size];
        Random random = new Random();
        for(int i = 0 ; i < size; i++)
            keys[i] = random.nextInt(size*2);
        return keys;
    }

    private static BinaryTree setUpTree(int size) {

        BinaryTree tree = new BinaryTree();
        Random random = new Random();
        int rootKey = size/2, key;
        tree.add(rootKey,0);

        for (int i = 1; i < size; i++){
            do {
                key = random.nextInt(size);
            }while ( key == rootKey);

            tree.add(key, i);
        }
        return tree;
    }


}
