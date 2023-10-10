import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class Bench {



    public static void firstBench(int[] sizes, int rounds){
        PriorityLinkedAdd addConstant = new PriorityLinkedAdd();
        PriorityLinkedRemove removeConstant = new PriorityLinkedRemove();
        for ( int size : sizes){

            int[] listToAdd = createAddList(size);
            //warmup

            System.out.printf("%10d",size);
            double minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                addConstant.clear();
                double t0,t1,time;

                t0 = System.nanoTime();
                for (int item : listToAdd)
                    addConstant.add(item);
                t1 = System.nanoTime();

                time = (t1-t0)/size;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.1f",
                    minT);



            minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                removeConstant.clear();
                double t0,t1,time;
                t0 = System.nanoTime();
                for (int item : listToAdd)
                    removeConstant.add(item);

                t1 = System.nanoTime();
                time = (t1-t0)/size;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.1f\n",minT);

        }




    }
    private static int[] createAddList(int size){
        Random rnd = new Random();
        int[] list = new int[size];
        for(int i =0; i < size; i++){
            int next = rnd.nextInt(size * 4);
            list[i] =next;
        }
        return list;
    }
}
