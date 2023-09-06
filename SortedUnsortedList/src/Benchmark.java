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
        return minTime / 101000;
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

    public static double duplicateLinearBenchWithKeys(int[] list1, int[] list2, int[] keys, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {
            double t0 = System.nanoTime();

            for (int currentKey : keys) {
                boolean found = Search.linearSearch(list1, currentKey);
                if (found)
                    Search.linearSearch(list2, currentKey);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

        }
        return minTime / keys.length;
    }


    public static double binarybenchWithKeys(int[] sortedList, int[] keys, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {

            double t0 = System.nanoTime();
            for (int j = 0; j < keys.length; j++) {
                int currentKey = keys[j];
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

    public static double binarybench(int[] sortedArray, int rounds) {
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


    public static double binarybench(int[] firstArray, int[] secondArray, int[] keys, int rounds) {
        double minTime = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {

            double t0 = System.nanoTime();

            for (int j = 0; j < keys.length; j++) {
                int currentKey = keys[j];
                boolean found = Search.binarySearch(firstArray, currentKey);
                if (found)
                    Search.binarySearch(secondArray, currentKey);
            }
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if (time < minTime) {
                minTime = time;
            }

            return minTime / keys.length;
        }


    }

}
