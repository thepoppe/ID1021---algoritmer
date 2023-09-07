public class Benchmark {



    public static double linearBench(int[] unsortedList, int rounds) {
        int nonExistingKey = -1;
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {
            double t0 = System.nanoTime();
            for (int j = 0; j < 100; j++)
                Search.linearSearch(unsortedList, nonExistingKey);
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }
        }
        return minTime / 100;
    }

    public static double linearBenchWithKeys(int[] list, int[] keys, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {
            double t0 = System.nanoTime();

            for (int currentKey : keys) {
                Search.linearSearch(list, currentKey);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

        }
        return minTime / keys.length;
    }



    public static double binaryBenchWithKeys(int[] sortedList, int[] keys, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {

            double t0 = System.nanoTime();
            for (int currentKey : keys) {
                Search.binarySearch(sortedList, currentKey);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

        }
        return minTime / keys.length;
    }

    public static double binaryBenchWC(int[] sortedArray, int rounds) {
        int worstKey = 0;
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {
            double t0 = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                Search.binarySearch(sortedArray, worstKey);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }
        }
        return minTime / 1000;
    }


    public static double binaryBenchDuplicate(int[] firstArray, int[] secondArray, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {

            double t0 = System.nanoTime();

            for (int currentElement : firstArray) {
                    Search.binarySearch(secondArray, currentElement);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

        }
        return minTime;


    }
    public static double linearBenchDuplicate(int[] firstArray, int[] secondArray,  int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {

            double t0 = System.nanoTime();
            for (int currentElement : firstArray) {
                Search.linearSearch(secondArray, currentElement);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

        }
        return minTime ;


    }



}
