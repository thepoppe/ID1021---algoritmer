import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        bench();
    }

    private static void bench(){
        int[] sizes = {100,200,400,800,1600,3200,6400,12800,};
        int rounds = 1000;
        System.out.println("Test starts");
        System.out.printf("10s%15s%15s%15s%15s\n","size","array","linked", "compl array", "compl linked");
        for (int size : sizes){
            Bench bench = new Bench(size,rounds);
            Bench warmup = new Bench(size,rounds);

            warmup.benchArray();
            warmup.benchList();


            double b0 = bench.benchArray();
            double b1 = bench.benchList();
            double tc0 = (double)size*1000.0 / b0;
            double tc1 = (double) size*1000.0/ b1;
            System.out.printf("%10d%15.1f%15.1f%15.1f%15.1f\n",size,b0,b1,tc0,tc1);
            //System.out.printf("%10d%10d%15.1f%15.1f\n",2,size,b2,b3);

        }
    }

    private static void functionalityLinked2() {
        LinkedList list =new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printAll();
        list.quicksort();
        list.printAll();
    }

    private static void functionalityLinked() {
        LinkedList list =new LinkedList();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.printAll();
        list.quicksort();
        list.printAll();

    }

    private static void functionalityLinkedEdge(){

        LinkedList list = new LinkedList();
        // Edge case 1: An empty list
        System.out.println("Edge Case 1: Empty List");
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();
        // Edge case 2: A list with a single element
        System.out.println("Edge Case 2: List with a Single Element");
        list.add(42);
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();
        // Edge case 3: A list with duplicate elements
        System.out.println("Edge Case 3: List with Duplicate Elements");
        list.clear();
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(2);
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();
        // Edge case 4: A large list with random order
        System.out.println("Edge Case 4: Large List with Random Order");
        list.clear();
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(15);
        list.add(1);
        list.add(7);
        list.add(6);
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();
        // Edge case 5: A list already sorted in ascending order
        System.out.println("Edge Case 5: List Already Sorted in Ascending Order");
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();
        // Edge case 6: A list sorted in descending order
        System.out.println("Edge Case 6: List Sorted in Descending Order");
        list.clear();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println("Original list:");
        list.printAll();
        list.quicksort();
        System.out.println("Sorted list:");
        list.printAll();
        System.out.println();

    }

    private static void functionalityArrayEdge() {
        // Edge case 1: An empty array
        System.out.println("Edge Case 1: Empty Array");
        int[] emptyArray = new int[0];
        System.out.println("Original array: " + Arrays.toString(emptyArray));
        Sort.quickSort(emptyArray);
        System.out.println("Sorted array: " + Arrays.toString(emptyArray));
        System.out.println();

        // Edge case 2: An array with a single element
        System.out.println("Edge Case 2: Array with a Single Element");
        int[] singleElementArray = {42};
        System.out.println("Original array: " + Arrays.toString(singleElementArray));
        Sort.quickSort(singleElementArray);
        System.out.println("Sorted array: " + Arrays.toString(singleElementArray));
        System.out.println();

        // Edge case 3: An array with duplicate elements
        System.out.println("Edge Case 3: Array with Duplicate Elements");
        int[] duplicateArray = {5, 3, 5, 2, 3, 2};
        System.out.println("Original array: " + Arrays.toString(duplicateArray));
        Sort.quickSort(duplicateArray);
        System.out.println("Sorted array: " + Arrays.toString(duplicateArray));
        System.out.println();

        // Edge case 4: A large array with random order
        System.out.println("Edge Case 4: Large Array with Random Order");
        int[] randomArray = {10, 5, 8, 2, 9, 15, 1, 7, 6};
        System.out.println("Original array: " + Arrays.toString(randomArray));
        Sort.quickSort(randomArray);
        System.out.println("Sorted array: " + Arrays.toString(randomArray));
        System.out.println();

        // Edge case 5: An array already sorted in ascending order
        System.out.println("Edge Case 5: Array Already Sorted in Ascending Order");
        int[] ascendingArray = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(ascendingArray));
        Sort.quickSort(ascendingArray);
        System.out.println("Sorted array: " + Arrays.toString(ascendingArray));
        System.out.println();

        // Edge case 6: An array sorted in descending order
        System.out.println("Edge Case 6: Array Sorted in Descending Order");
        int[] descendingArray = {5, 4, 3, 2, 1};
        System.out.println("Original array: " + Arrays.toString(descendingArray));
        Sort.quickSort(descendingArray);
        System.out.println("Sorted array: " + Arrays.toString(descendingArray));
        System.out.println();
    }

}
