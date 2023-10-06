
public class Bench {


    private FirstQueue listQueue;
    private SecondQueue arrayQueue;
    private int size;
    private int rounds;


    Bench(int size, int rounds){
        this.listQueue = new FirstQueue();
        this.arrayQueue = new SecondQueue();
        this.size = size;
        this.rounds = rounds;
    }



    public double benchArray(){
        double t0,t1,time = 0.000,minT = Double.MAX_VALUE;

        for (int i= 0; i < rounds; i++){
            arrayQueue.clear();
            t0 = System.nanoTime();
            for ( int j =0; j< size; j++)
                arrayQueue.add(j);
            for ( int j =0; j< size; j++)
                arrayQueue.remove();

            t1 = System.nanoTime();
            time = (t1-t0)/size;
            if (time  < minT)
                minT = time;
        }
        return minT;
    }

    public double benchList(){
        double t0,t1,time = 0.000,minT = Double.MAX_VALUE;

        for (int i= 0; i < rounds; i++){
            listQueue.clear();
            t0 = System.nanoTime();
            for ( int j =0; j< size; j++)
                listQueue.add(j);
            for ( int j =0; j< size; j++)
                listQueue.remove();

            t1 = System.nanoTime();
            time = (t1-t0)/size;
            if (time  < minT)
                minT = time;
        }
        return minT;
    }

}

