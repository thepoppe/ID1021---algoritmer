import java.util.Arrays;
import java.util.Random;

public class benchMarks {
    public static void main(String[] args) {
        int i = 0;
        while( i < 10) {
            runBench();
            i++;
        }

    }
    private static void runBench(){
        Stack staticStack = new StaticStack(1024);
        Stack dynamicStack = new DynamicStack(4);
        int rounds = 1000;

        System.out.println("The 100 minimum static results");
        long[] staticResults = run1000x(rounds,staticStack);
        long[] sortedStatic = find100Min(staticResults);
        System.out.println(Arrays.toString(sortedStatic));

        System.out.println("\nThe 100 minimum dynamic results");
        long[] dynamicResults = run1000x(rounds,dynamicStack);
        long[] sortedDynamic = find100Min(dynamicResults);
        System.out.println(Arrays.toString(sortedDynamic));
        System.out.println();
        /*
        System.out.println("\nThe median value from static : " + median(staticResults));
        System.out.println("The 10 avg worst value from static : " + worst10Avg(staticResults));
        System.out.println("The median value from dynamic : " + median(dynamicResults));
        System.out.println("The 10 avg worst value from dynamic : " + worst10Avg(dynamicResults));
        System.out.println("\n");
        */
    }

    private static long worst10Avg(long[] allResults){
        long result = 0;
        for(int i = allResults.length-10;  i< allResults.length; i++){
            result += allResults[i];
        }
        return result/10;
    }
    private static long median(long[] allResults){
        return allResults[allResults.length/2];
    }
    private static long[] find100Min(long[] allResults){

        long[] minimum100 = new long[100];
        System.arraycopy(allResults,0,minimum100,0,100);
        return minimum100;
    }
    private static long[] run1000x(int rounds, Stack stack){
        long[] results = new long[1000];
        for (int i = 0; i  < 1000; i++){
            results[i] = pushAndPop(rounds,stack);
        }
        Arrays.sort(results);
        return results;
    }

    private static long pushAndPop(int rounds, Stack stack) {
        Random random = new Random();
        int value = random.nextInt();
        long t0,t1;
        t0 = System.nanoTime();
        for (int i = 0; i < rounds; i++)
            stack.push(10);
        for(int i = 0; i < rounds; i++)
            stack.pop();
        t1 = System.nanoTime();
        long time = (t1-t0)/rounds*2;
        return time;
    }
}
