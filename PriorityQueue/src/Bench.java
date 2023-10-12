
import java.util.ArrayList;


import java.util.Random;



public class Bench {

    public static void benchArrayHeap(int[] sizes, int rounds){


        System.out.printf("%10s%20s%20s\n","Size","linked","array");
        for (int size : sizes){
            int[] listToAdd = createAddList(size);
            ArrayHeap array = new ArrayHeap(size);
            Heap linked = new Heap();
            for(int i = 0; i < rounds; i++){
                array.clear();
                linked.clear();
                for(int item : listToAdd){
                    array.add(item);
                    linked.enqueue(item);
                }
            }

            double minT1 = Double.MAX_VALUE, minT2 =Double.MAX_VALUE;
            double t0,t1,time;
            for(int i = 0; i<rounds; i++){
               array.clear();
               linked.clear();

                t0 = System.nanoTime();
                for(int item : listToAdd){
                    linked.enqueue(item);
                    linked.dequeue();
                }
                t1 = System.nanoTime();
                time = (t1-t0);
                if (time < minT1)
                    minT1 = time;

                t0 = System.nanoTime();
                for(int item : listToAdd){
                    linked.enqueue(item);
                    linked.dequeue();
                }
                t1 = System.nanoTime();
                time = (t1-t0);
                if (time < minT2)
                    minT2 = time;

            }

            System.out.printf("%5d%20.0f%20.0f\n",size,minT1,minT2);


        }
    }

    public static  void benchHeap(int[] sizes, int rounds){
        Heap test = new Heap();

        int[] listToAdd = random1023(0,10000);
        int[] listToPush = random1023(10,100);
        ArrayList<Integer> depthOfPush = new ArrayList<>();


        System.out.printf("%10s%20s%20s%20s\n", "run","adding", "pushing", "removing&adding");
        for ( int size : sizes){

            //adding 1023 random elements to the heap
            System.out.printf("%10d",1023);
            double minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                double t0,t1,time;

                test.clear();
                t0 = System.nanoTime();
                for (int item : listToAdd)
                    test.enqueue(item);
                t1 = System.nanoTime();

                time = (t1-t0);

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.1f", minT);

            //test to increment all values
            if (size == 1000){
                test.clear();
                for (int item : listToAdd)
                    test.enqueue(item);
                for (int item : listToPush)
                    depthOfPush.add(test.push(item));
            }



            //time to push 1023 elements
            minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                double t0,t1,time;
                test.clear();
                for (int item : listToAdd)
                    test.enqueue(item);

                t0 = System.nanoTime();
                for (int item : listToPush)
                    test.push(item);
                t1 = System.nanoTime();
                time = (t1-t0);

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.1f", minT);




            minT = Double.MAX_VALUE;
            for (int i = 0; i < rounds; i++) {
                double t0,t1,time;

                test.clear();
                for (int item : listToAdd)
                    test.enqueue(item);
                t0 = System.nanoTime();
                for (int item : listToAdd){
                    test.dequeue();
                    test.enqueue(item);
                }
                t1 = System.nanoTime();

                time = (t1-t0);

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.1f\n", minT);

        }


        System.out.println(depthOfPush.toString());

    }
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
    private static int[] random1023(int origin, int bound){
        Random rnd = new Random();
        int[] list = new int[1023];
        for(int i =0; i < 1023; i++){
            int next = rnd.nextInt(origin,bound);
            list[i] =next;
        }
        return list;
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
