import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testList = {5,2,3,1,9,7};
        Sort.mergeSort(testList);
        System.out.println(Arrays.toString(testList));


        int[] arraySize = {100,200,400,800,1600};
        int[] arraySizes2 = {50,100,200,400,800,1600,3600,6400,6400*2,6400*2*2};
        int rounds = 1000;

        System.out.println("First test selection vs insertion");
        //Bench.firstBench(arraySize,rounds);
        Bench.firstBench(arraySizes2,rounds);
        /*System.out.println("Second test selection, insertion, merge");
        Bench.secondBench(arraySize,rounds);
        System.out.println("Third test merge and quick sort");
        Bench.thirdBench(arraySizes2,rounds);*/
    }
}
