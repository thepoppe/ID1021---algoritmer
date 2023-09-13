import java.util.Random;
import java.util.stream.IntStream;

public class Bench {


    public static void firstBench(int[] sizes, int rounds){
        System.out.printf("%10s%20s","size","sel. unsorted");
        System.out.printf("%20s","sel. sorted");
        System.out.printf("%20s","sel. sorted H->L");
        System.out.printf("%20s","ins. unsorted");
        System.out.printf("%20s","ins. sorted");
        System.out.printf("%20s","ins. sorted H->L");
        System.out.println();

        for (int size : sizes){
            System.out.printf("%10s",size);
            selectionWUnsorted(size,rounds);
            selectionWSorted(size,rounds);
            selectionWSortedHighToLow(size,rounds);
            insertionWUnsorted(size,rounds);
            insertionWSorted(size,rounds);
            insertionWSortedHighToLow(size,rounds);

            System.out.println();
        }
    }

    public static void secondBench(int[] sizes, int rounds){
        System.out.printf("%10s","size");
        System.out.printf("%20s","sel unsorted");
        System.out.printf("%20s","ins unsorted");
        System.out.printf("%20s","merge unsorted");

        System.out.println();

        for (int size : sizes){
            System.out.printf("%10s",size);
            selectionWUnsorted(size,rounds/10);
            insertionWUnsorted(size,rounds/10);
            mergeWUnsorted(size,rounds);

            System.out.println();
        }
    }

    public static void thirdBench(int[] sizes, int rounds){
        System.out.printf("%10s","size");
        System.out.printf("%20s","merge unsorted");
        System.out.printf("%20s","merge sorted");
        System.out.printf("%20s","quick unsorted");
        System.out.printf("%20s","quick sorted");

        System.out.println();
        for (int size : sizes){
            System.out.printf("%10s",size);
            mergeWUnsorted(size,rounds);
            mergeWSorted(size,rounds);
            quickWUnsorted(size,rounds);
            quickWSorted(size,rounds);

            System.out.println();
        }
    }

    private static void quickWSorted(int size, int rounds) {
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] sortedList = ArrayFiller.sortedList(size);
            double t0 = System.nanoTime();
            Sort.quickSort(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);

    }

    private static void mergeWSorted(int size, int rounds) {
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] sortedList = ArrayFiller.sortedList(size);
            double t0 = System.nanoTime();
            Sort.mergeSort(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);

    }

    private static  void mergeWUnsorted(int size, int rounds){
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] unsortedList = IntStream.generate(() -> new Random().nextInt(size*5)).limit(size).toArray();
            double t0 = System.nanoTime();
            Sort.mergeSort(unsortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }

    private static  void quickWUnsorted(int size, int rounds){
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] unsortedList = ArrayFiller.unsortedList(size);
            double t0 = System.nanoTime();
            Sort.quickSort(unsortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }
    private static void selectionWUnsorted(int size, int rounds){
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] unsortedList = ArrayFiller.unsortedList(size);
            double t0 = System.nanoTime();
            Sort.selection(unsortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }


    private static void insertionWUnsorted(int size, int rounds){
        System.gc();
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            int[] unsortedList = ArrayFiller.unsortedList(size);
            double t0 = System.nanoTime();
            Sort.insertion(unsortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }
    private static void selectionWSorted(int size, int rounds){
        System.gc();
        int[] sortedList = ArrayFiller.sortedList(size);
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){

            double t0 = System.nanoTime();
            Sort.selection(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }


    private static void insertionWSorted(int size, int rounds){
        System.gc();
        int[] sortedList = ArrayFiller.sortedList(size);
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            double t0 = System.nanoTime();
            Sort.insertion(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }

    private static void selectionWSortedHighToLow(int size, int rounds){
        System.gc();
        int[] sortedList = ArrayFiller.sortedList(size);
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            Sort.selectionHighToLow(sortedList);
            double t0 = System.nanoTime();
            Sort.selection(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }


    private static void insertionWSortedHighToLow(int size, int rounds){
        System.gc();
        int[] sortedList = ArrayFiller.sortedList(size);
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++){
            Sort.selectionHighToLow(sortedList);
            double t0 = System.nanoTime();
            Sort.insertion(sortedList);
            double t1 = System.nanoTime();

            if((t1-t0) < minTime)
                minTime = (t1-t0);
        }

        System.out.printf("%20.1f",minTime/1000);
    }

}





