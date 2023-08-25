import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        String line = "\n--------------------------------------------------\n\n";
        long t0, t1;
        int sum;
        int[] givenArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        out.println(line + "Test with arrays starts" + line);
        out.println("Test for testing the clock;");
        for (int i = 0; i < 10; i++) {
            t0 = nanoTime();
            t1 = nanoTime();
            out.println("Res = " + (t1 - t0) + " ns");
        }
        out.println(line);


        out.println("Test for accessing 1 element in an array");
        sum = 0;
        for (int i = 0; i < 10; i++) {
            t0 = nanoTime();
            sum += givenArray[i];
            t1 = nanoTime();
            out.println("Res = " + (t1 - t0) + " ns");
        }


        out.println(line + "Test for accessing 1 random element in an array");
        Random random = new Random();
        sum = 0;
        t0 = nanoTime();
        for (int i = 0; i < 1000; i++) {
            sum += givenArray[random.nextInt(10)];
        }
        t1 = nanoTime();
        out.println("Time for accessing one random element = " + (t1 - t0) / 1000 + " ns");


        out.println(line + "Test to access random element in an array using method access from pdf");
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < 10; i++) {
            double t = access(n);
            System.out.println(" access: " + t + " ns");
        }

        out.println(line + "Test with sorting the arrays");
        int turns = 1000;
        double[] time = new double[turns];
        sum = 0;
        for (int i = 0; i < turns; i++) {
            double t = access(n);
            time[i] = t;
            sum += t;

        }
        Arrays.sort(time);
        System.out.println(" avg: " + sum/turns);
        System.out.println(" min: " + time[0]);
        System.out.println(" med: " + time[turns/2]);
        System.out.println(" max: " + time[turns-1]);



        out.println(line + "Test for only the minimum value");
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 30000, 300000};
        bench(1000);
        for(int size : sizes) {
            double t = bench(size);
            System.out.println(size + " " + t);
        }


        out.println(line + "Test to find a specific value");
        int[] keys= {1, 2, 155, 162, 1111, 1234, 10512,14070};
        search(1000);
        for(int key : keys) {
            double t = search(key);
            System.out.println(key + " " + t);
        }

        out.println(line + "Test to find a duplicate of a specific value");
        searchDuplicate(1000);
        for(int key : keys) {
            double t = searchDuplicate(key);
            System.out.println(key + " " + t);
        }



    }
    private static double searchDuplicate(int n){
        int loop = 1000;
        Random random = new Random();
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for(int i = 0; i < n; i++){
            firstArray[i] = random.nextInt(n*2);
            secondArray[i] = random.nextInt(n*2);
        }
        int[] keys = new int[loop];
        for (int k = 0; k < loop; k++) {
            keys[k] = random.nextInt(n*2);
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            int key = keys[i];
            for (int j = 0; j < n; j++) {
                if (key == firstArray[j]) {
                    sum++;
                    for(int k =0; k < n; k++) {
                        if (key == secondArray[k]) ;
                        sum++;
                        break;
                    }
                }
            }
        }
        long t1 = System.nanoTime();
        return (double)(t1 - t0)/loop;


    }

    private static double search(int n) {
        int loop = 1000;
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(n*2);
        }
        int[] keys = new int[loop];
        for (int k = 0; k < loop; k++) {
            keys[k] = rnd.nextInt(n*2);
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            int key = keys[i];
            for (int j = 0; j < n; j++) {
                if (key == array[j]) {
                    sum++;
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        return (double)(t1 - t0)/loop;


    }

    /**
     * Copied from Array.pdf kth
     * @param n The arraySize to test
     * @return the fastest time to access one random element in the array
     */
    public static double bench(int n) {
        int turns = 1000;
        double min = Double.POSITIVE_INFINITY;;
        for (int i = 0; i < turns; i++) {
            double t = access(n);
            if (t < min) {
                min = t;
            }
        }
        return min;
    }



    /**
     * Copied from Array.pdf kth
     * @param n The arraySize to test
     * @return the time to access one random element in the array
     */
    public static double access(int n) {
        int loop = 1000;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i;
        int[] indx = new int[loop];
        Random rnd = new Random();
        for (int k = 0; k < loop; k++) {
            indx[k] = rnd.nextInt(n);
        }
        long t0 = System.nanoTime();
        int sum = 0;
        for (int k = 0; k < loop; k++) {
            sum += array[indx[k]];
        }
        long t1 = System.nanoTime();
        return (double)(t1 - t0)/loop;
    }

}