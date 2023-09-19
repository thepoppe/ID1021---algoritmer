import java.util.Random;

public class Bench {

    /*
    You should benchmark how long time it takes to unlink a cell and then insert
it and do this for k randomly selected cells (k being for example 1000). You
should run the benchmark using both a doubly and single linked list. The
length of the lists should increase to see how the two data structures behave
as the lists become longer.
In order to randomly select a cell you could try something like follows.
Create a list of n cells but when you create the cells you not only add them
to the list but also keep a reference to them in an array of length n (let’s
call this the cell array).
Create an array of k random numbers between 0 and n − 1; this is the
array of indices of cells that you should unlink. In the benchmark you
measure the time it takes to run through all k indices and for each index
find the cell in the cell array. Given the cell reference you first unlink the
cell and then add it to beginning of the list.
     */


    static void run(){
        int[] sizes = {1000,2000,4000,8000};
        for (int size : sizes){

            LinkedLists list1 =  new DoublyLinked(0);
            Cell[] listOfDoubly = setUpList(list1,size);
            LinkedLists list2 = new Linked(0);
            Cell[] listOfLinked = setUpList(list2,size);
            int[] ks = fillToN(size);

            System.out.println("Warm Up...");
            LinkedLists list3 =  new Linked(0);
            Cell[] listOf3 = setUpList(list3,size);
            for(Cell cell : listOf3){
                list3.unlink(cell);
                list3.insert(cell);
            }

            System.out.print("Benchmark starts...\n");
            double t0,t1,timeDoub = Double.POSITIVE_INFINITY,timeSin = Double.POSITIVE_INFINITY;
            for (int i = 0; i <1000; i++){
                t0 =System.nanoTime();
                for (int k: ks){
                    list1.unlink(listOfDoubly[k]);
                    list1.insert(listOfDoubly[k]);

                }
                t1 = System.nanoTime();
                if (timeDoub > (t1-t0))
                    timeDoub = (t1-t0);

                t0 =System.nanoTime();
                for (int k: ks){
                    list2.unlink(listOfLinked[k]);
                    list2.insert(listOfLinked[k]);

                }
                t1 = System.nanoTime();
                if (timeSin > (t1-t0))
                    timeSin = (t1-t0);
            }


            System.out.printf("Size: %d\tTime for Doubly Linked : %.1f\n",size,timeDoub/1000);
            System.out.printf("Size: %d\tTime for Single Linked : %.1f\n",size,timeSin/1000);




        }

    }
    private static int[] fillToN(int size){
        Random random = new Random();
        int[] newInt = new int[size];
        for (int i = 0; i < size; i++)
            newInt[i] = random.nextInt(size-1);
        return newInt;
    }

    private static Cell[] setUpList ( LinkedLists list, int size){
        Random random = new Random();
        Cell[] listOfDoubly = new Cell[size];
        for (int i = listOfDoubly.length-1  ; i >= 0; i--){
            int randomValue = random.nextInt(size*2);
            listOfDoubly[i] = new Cell(randomValue,null,null);
            list.insert(listOfDoubly[i] );
        }
        return listOfDoubly;
    }
}
