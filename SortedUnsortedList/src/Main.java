public class Main {
    public static void main(String[] args) {
        duplicateFirstTest();

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
        int rounds = 100000;
        int[] arraySizes = {100,200,400,800,1600};
        double[] results = new double[arraySizes.length *2];
        System.out.printf("Array size grows by 2x\n%10s %15s %15s\n","Size","Linear", "Binary");
        for (int i = 0; i < arraySizes.length; i++) {
            int size = arraySizes[i];
            int[] firstArray = ArrayFiller.unsortedList(size);
            int[] secondArray = ArrayFiller.sortedList(size);


            results[i] = Benchmark.linearBenchDuplicate(firstArray, secondArray, rounds);
            results[i + arraySizes.length] = Benchmark.binaryBenchDuplicate(firstArray, secondArray, rounds);
            System.out.printf("%10d %15.2f %15.2f\n", size,  results[i], results[i + arraySizes.length]);
        }
        double avgRatioLinear= 0,avgRatioBinary =0;
        for(int i = 1; i < arraySizes.length; i++){
            avgRatioLinear += results[i]/results[i-1];
            avgRatioBinary += results[i+ arraySizes.length]/results[i+arraySizes.length -1];
        }
        System.out.printf("Average growth ratio for linear: %.2f\n",avgRatioLinear/(arraySizes.length-1));
        System.out.printf("Average growth ratio for linear: %.2f\n",avgRatioBinary/(arraySizes.length-1));
    }




}




