import java.util.Arrays;

public class BenchMarks {
    public static void main(String[] args) {
        for(int i= 0; i < 10;i++)
            runBench();

    }
    private static void runBench(){
        Stack staticStack = new StaticStack(102400);
        Stack dynamicStack = new DynamicStack(4);
        int rounds = 100000;
        run(10000,staticStack);
        run(10000,dynamicStack);

        System.out.println("The 100 minimum static results");
        long[] staticResults = run(rounds,staticStack);
        long[] sortedStatic = find100Min(staticResults);
        System.out.println(Arrays.toString(sortedStatic));

        System.out.println("\nThe 100 minimum dynamic results");
        long[] dynamicResults = run(rounds,dynamicStack);
        long[] sortedDynamic = find100Min(dynamicResults);
        System.out.println(Arrays.toString(sortedDynamic));
        System.out.println();

        System.out.println("\nThe median value from static : " + median(staticResults));
        System.out.println("The 10 avg worst value from static : " + worst10Avg(staticResults));
        System.out.println("The median value from dynamic : " + median(dynamicResults));
        System.out.println("The 10 avg worst value from dynamic : " + worst10Avg(dynamicResults));
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
    private static long[] run(int rounds, Stack stack){
        long[] results = new long[rounds];
        for (int i = 0; i  < rounds; i++){
            results[i] = pushAndPop1000x(stack);
        }
        Arrays.sort(results);
        return results;
    }

    private static long pushAndPop1000x(Stack stack) {
        long t0,t1;
        int sum = 0;
        t0 = System.nanoTime();
        for (int i = 0; i < 1000; i++)
            stack.push(1);
        for(int i = 0; i < 1000; i++)
            sum += stack.pop();
        t1 = System.nanoTime();
        long time = (t1-t0);
        return time;
    }
}
