import java.util.Random;

public class Bench {


    private LinkedList list;
    private int[] array;
    private int size;
    private int rounds;


    Bench(int size, int rounds){
        this.list = new LinkedList();
        this.array = new int[size];
        this.size = size;
        this.rounds = rounds;
        fillArrayAndList();
    }

    private void fillArrayAndList(){
        Random random = new Random();
        for(int i =0; i < size; i++){
            int rndVal = random.nextInt(size*5);
            this.array[i] = rndVal;
            this.list.add(rndVal);
        }
    }

    public double benchArray(){
        double t0,t1,time = 0.000,minT = Double.MAX_VALUE;

        for (int i= 0; i < rounds; i++){
            int[] copy  = createCopy(this.array);
            t0 = System.nanoTime();
            Sort.quickSort(copy);
            t1 = System.nanoTime();
            time = (t1-t0);
            if (time  < minT)
                minT = time;
        }
        return minT;
    }

    public double benchList(){
        double t0,t1,time = 0.000,minT = Double.MAX_VALUE;

        for (int i= 0; i < rounds; i++){
            LinkedList newList = list.createCopy();
            t0 = System.nanoTime();
            newList.quicksort();
            t1 = System.nanoTime();
            time = (t1-t0);
            if (time  < minT)
                minT = time;
        }
        return minT;
    }



    private int[] createCopy(int[] array) {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++){
            copy[i] = this.array[i];
        }
        return copy;
    }
}
