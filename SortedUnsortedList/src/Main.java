import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testForTrees();

    }
    public static void testForTrees(){
        int[] sizes = {500,1000,2000,4000,8000,16000};
        int round = 10000;
        double minTime,t0,t1,time;
        for (int s : sizes) {
            int[] sortedArray = ArrayFiller.sortedList(s);
            int[] k = fillKeys(s);

            minTime = Double.POSITIVE_INFINITY;
            //Warmup
            for (int key : k) {
                Search.binarySearch(sortedArray,key);
            }
            //Test starts
            for (int i = 0; i < round; i++) {
                t0 = System.nanoTime();
                for (int key : k)
                    Search.binarySearch(sortedArray,key);
                t1 = System.nanoTime();
                time = (t1 - t0) / s;

                if (time < minTime)
                    minTime = time;
            }

            System.out.printf("%10d%15.1f\n" ,s, minTime );
        }


    }

    private static int[] fillKeys(int s) {
        int[] keys = new int[s];
        Random random = new Random();
        for(int i = 0; i < s; i++)
            keys[i] = random.nextInt(s);
        return keys;
    }

    private static void firstTest(){
        int rounds = 1000;
        int[] arraySizesFirst = {100,1000,10000,100000,1000000};
        int[] arraySizesSecond = {500,1000,2000,4000,8000,16000};

        System.out.printf("Array size grows by 10x\n%10s %20s %20s\n","Size","Linear sorted", "Linear unsorted");
        for (int size: arraySizesFirst){
            int[] unSortedArray = ArrayFiller.unsortedList(size);
            int[] sortedArray = ArrayFiller.sortedList(size);
            Benchmark.linearBench(unSortedArray, rounds);
            double unSortedMinTime = Benchmark.linearBench(unSortedArray, rounds);
            double sortedMinTime = Benchmark.linearBench(sortedArray, rounds);

            System.out.printf("%10d %15.2f %15.2f\n",size, unSortedMinTime,sortedMinTime);
        }

        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear sorted", "Linear unsorted");
        for (int size: arraySizesSecond){
            int[] unSortedArray = ArrayFiller.unsortedList(size);
            int[] sortedArray = ArrayFiller.sortedList(size);
            Benchmark.linearBench(unSortedArray, rounds);
            double unSortedMinTime = Benchmark.linearBench(unSortedArray, rounds);
            double sortedMinTime = Benchmark.linearBench(sortedArray, rounds);

            System.out.printf("%10d %15.2f %15.2f\n",size, unSortedMinTime,sortedMinTime);
        }
    }

    private static void firstTestWithKeys(){
        int rounds = 10000;
        int numberOfKeys = 1000;
        int[] arraySizes = {500,1000,2000,4000,8000,16000};


        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear unsorted", "Linear sorted");
        for (int size: arraySizes){
            int[] unSortedArray = ArrayFiller.unsortedList(size);
            int[] sortedArray = ArrayFiller.sortedList(size);
            int[] keys = ArrayFiller.keyFiller(numberOfKeys,size);
            Benchmark.linearBenchWithKeys(unSortedArray,keys, rounds);
            double unSortedMinTime = Benchmark.linearBenchWithKeys(unSortedArray,keys, rounds);
            double sortedMinTime = Benchmark.linearBenchWithKeys(sortedArray,keys, rounds);

            System.out.printf("%10d %15.2f %15.2f\n",size, unSortedMinTime,sortedMinTime);
        }
    }

    private static void firstTestBinaryAndLinear(){
        int rounds = 10000;
        int numberOfKeys = 1000;
        int[] arraySizes = {500,1000,2000,4000,8000,16000};

        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear", "Binary");
        for (int size: arraySizes){
            int[] sortedArray = ArrayFiller.sortedList(size);
            int[] keys = ArrayFiller.keyFiller(numberOfKeys,size);

            double linearMinTime = Benchmark.linearBenchWithKeys(sortedArray,keys, rounds);
            double binaryMinTime = Benchmark.binaryBenchWithKeys(sortedArray,keys, rounds);
            System.out.printf("%10d %15.2f %15.2f\n",size, linearMinTime,binaryMinTime);
        }
    }


    private static void secondTestBinaryAndLinear(){
        int rounds = 1000;
        int[] arraySizes = {500,1000,2000,4000,8000,16000};

        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear", "Binary");
        for (int size: arraySizes){
            int[] sortedArray = ArrayFiller.sortedList(size);
            double linearMinTime = Benchmark.linearBench(sortedArray, rounds);
            double binaryMinTime = Benchmark.binaryBenchWC(sortedArray, rounds);
            System.out.printf("%10d %15.2f %15.2f\n",size, linearMinTime,binaryMinTime);
        }
    }

    private static void binary64Mil(){
        int[] array = ArrayFiller.sortedList((int) 64E6);
        int[] unmatchedKeys ={Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE, 0};
        for(int i = 0; i < 10; i++){
            double time = Benchmark.binaryBenchWithKeys(array,unmatchedKeys, 100000);
            System.out.println(time);
        }
    }

    private static void duplicateFirstTest(){
        int rounds = 10000;
        int[] arraySizes = {100,200,400,800,1600,3200,6400,12800};
        int listLength = arraySizes.length;
        double[] results = new double[listLength *3];
        System.out.printf("Array size grows by 2x\n%10s %15s %15s %15s\n","Size","Linear", "Binary","Pointer");
        for (int i = 0; i < listLength; i++) {
            int size = arraySizes[i];
            int[] firstArray = ArrayFiller.unsortedList(size);
            int[] secondArray = ArrayFiller.sortedList(size);

            System.gc();
            System.out.printf("%10d",size);
            results[i] = Benchmark.linearBenchDuplicate(firstArray, secondArray, rounds);
            results[i + listLength] = Benchmark.binaryBenchDuplicate(firstArray, secondArray, rounds);
            results[i + (listLength*2)] = Benchmark.pointerBenchDuplicate(firstArray, secondArray, rounds);
            System.out.println();
        }
        double avgRatioLinear= 0,avgRatioBinary =0, avgRatioPointer =0;
        for(int i = 1; i < listLength; i++){
            avgRatioLinear += results[i]/results[i-1];
            avgRatioBinary += results[i+ listLength]/results[i+listLength -1];
            avgRatioPointer += results[i+ listLength*2]/results[i+listLength*2 -1];

        }
        System.out.printf("Average growth ratio for linear: %.2f\n",avgRatioLinear/(listLength-1));
        System.out.printf("Average growth ratio for binary: %.2f\n",avgRatioBinary/(listLength-1));
        System.out.printf("Average growth ratio for pointer: %.2f\n",avgRatioPointer/(listLength-1));
    }




}




