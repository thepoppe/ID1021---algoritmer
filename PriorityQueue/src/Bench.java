import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class Bench {



    public static void firstBench(int[] sizes, int rounds){
        FirstPriority addConstant = new FirstPriority("add");
        FirstPriority removeConstant = new FirstPriority("remove");
        for ( int size : sizes){

            int[] listToAdd = createAddList(size);
            //warmup
            for (int i = 0; i < 100; i++) {
                for (int item : listToAdd)
                    addConstant.add(item);
                for (int j = 0; j < 100; j++)
                    addConstant.remove();
            }

            double minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                addConstant.clear();
                double t0,t1,time;
                t0 = System.nanoTime();
                for (int item : listToAdd)
                    addConstant.add(item);
                for (int j = 0; j < size; j++)
                    addConstant.remove();
                t1 = System.nanoTime();
                time = t1-t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%10d%20.2f",size,minT);


            //warmup
            for (int i = 0; i < 100; i++) {
                for (int item : listToAdd)
                    removeConstant.add(item);
                for (int j = 0; j < 100; j++)
                    removeConstant.remove();
            }

            minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                removeConstant.clear();
                double t0,t1,time;
                t0 = System.nanoTime();
                for (int item : listToAdd)
                    removeConstant.add(item);
                for (int j = 0; j < size; j++)
                    removeConstant.remove();
                t1 = System.nanoTime();
                time = t1-t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.2f\n",minT);

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
