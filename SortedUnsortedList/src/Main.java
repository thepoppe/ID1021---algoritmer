public class Main {
    public static void main(String[] args) {
        binary64Mil();

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
        int[] arraySizesFirst = {100,1000,10000,100000,1000000};
        int[] arraySizesSecond = {500,1000,2000,4000,8000,16000};


        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear unsorted", "Linear sorted");
        for (int size: arraySizesSecond){
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
            double binaryMinTime = Benchmark.binarybenchWithKeys(sortedArray,keys, rounds);
            System.out.printf("%10d %15.2f %15.2f\n",size, linearMinTime,binaryMinTime);
        }
    }


    private static void secondTestBinaryAndLinear(){
        int rounds = 1000;
        int numberOfKeys = 1000;
        int[] arraySizes = {500,1000,2000,4000,8000,16000};

        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear", "Binary");
        for (int size: arraySizes){
            int[] sortedArray = ArrayFiller.sortedList(size);


            double linearMinTime = Benchmark.linearBench(sortedArray, rounds);
            double binaryMinTime = Benchmark.binarybench(sortedArray, rounds);
            System.out.printf("%10d %15.2f %15.2f\n",size, linearMinTime,binaryMinTime);
        }
    }

    private static void binary64Mil(){
        int[] array = ArrayFiller.sortedList((int) 64E6);
        int unmatchedKeys[] ={Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE, 0};
        for(int i = 0; i < 10; i++){
            double time = Benchmark.binarybenchWithKeys(array,unmatchedKeys, 100000);
            System.out.println(time);
        }
    }




}




