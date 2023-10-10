public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000,2000,4000,8000,16000,32000};
        int rounds = 1000;
        Bench.firstBench(sizes,rounds);
        System.out.println("Done");
    }


}
