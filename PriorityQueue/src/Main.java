public class Main {
    public static void main(String[] args) {
        int[] sizes = {100,200,400,800,1600,3200,6400,12800};
        int rounds = 1000;
        Bench.firstBench(sizes,rounds);
        System.out.println("Done");
    }
}
