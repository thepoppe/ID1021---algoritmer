import java.util.Arrays;

public class BenchMarks {
    public static void main(String[] args) {
        runBenchDifferentLoops();


    }
    private static void runBenchDifferentLoops(){
        Stack staticStack = new StaticStack(64400);
        Stack dynamicStack = new DynamicStack(4);
        int rounds = 100000;
        int[] loops = {1000,2000,4000,8000,16000,32000,64000};
        System.out.println("Warming up the cache");
        run(1000,10000,staticStack);
        run(1000,10000,dynamicStack);

        System.gc();
        System.out.println("The results");
        System.out.println("\tn\t\t|\t\tstat\t\t|\t\tdyna\t\t|\t\tRatio");

        for (int loop : loops) {
            long[] static_results =  run(loop,rounds,staticStack);
            long[] dynamic_results =  run(loop,rounds,dynamicStack);
            System.out.printf("\t%d\t|\t\t%4d\t\t|\t\t%d\t\t|\t\t%.2f\n"
                    ,loop,static_results[0],dynamic_results[0],(float)dynamic_results[0]/static_results[0]);
        }

    }
    private static void runBench(){
        int rounds = 10000;
        int loops = 1000;
        Stack staticStack = new StaticStack(loops);
        Stack dynamicStack = new DynamicStack(4);
        run(loops,rounds, staticStack);
        run(loops,rounds, dynamicStack);

        System.out.println("The 100 minimum static results");
        long[] staticResults = run(loops,rounds,staticStack);
        long[] sortedStatic = find100Min(staticResults);
        System.out.println(Arrays.toString(sortedStatic));

        System.out.println("\nThe 100 minimum dynamic results");
        long[] dynamicResults = run(loops,rounds,dynamicStack);
        long[] sortedDynamic = find100Min(dynamicResults);
        System.out.println(Arrays.toString(sortedDynamic));
        System.out.println();

        System.out.println("\nThe median value from static : " + median(staticResults));;
        System.out.println("The median value from dynamic : " + median(dynamicResults));
        System.out.println("The ratio: " + (double) sortedDynamic[0]/sortedStatic[0]);
        System.out.println("\n");

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
    private static long[] run(int loops, int rounds, Stack stack){
        long[] results = new long[rounds];
        for (int i = 0; i  < rounds; i++){
            results[i] = pushAndPop(loops, stack);
        }
        Arrays.sort(results);
        return results;
    }

    private static long pushAndPop(int loops, Stack stack) {
        long t0,t1;
        t0 = System.nanoTime();
        for (int i = 0; i < loops; i++)
            stack.push(10);
        for(int i = 0; i < loops; i++)
            stack.pop();
        t1 = System.nanoTime();
        return (t1-t0);

    }
}
