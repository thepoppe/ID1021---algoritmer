import java.util.Arrays;

public class

Bench {




    public static void firstTest(){
        Linked firstList = new Linked(5);
        Linked secondList = new Linked(10);
        System.out.println("length of first: \n"+firstList.length());
        System.out.println("find element 2: \n"+firstList.find(2));
        System.out.println("Print List1: ");
        firstList.printAllItems();
        System.out.println("Remove  2: ");
        firstList.remove(2);
        firstList.printAllItems();
        System.out.println("add  2: ");
        firstList.add(2);
        firstList.printAllItems();
        System.out.println("Remove  2: ");
        firstList.remove2(2);
        firstList.printAllItems();
        System.out.println("Append list2 to list1: ");
        firstList.append(secondList);
        firstList.printAllItems();

        System.out.println();
        int[] sizesFirst = {5000,10000,20000,40000,80000,160000};
        int rounds = 1000;



        System.out.printf("%10s%15s\n","Size","Append");
        for (int size: sizesFirst) {
            for (int i = 0; i < 100; i++) {
                firstList = new Linked(size);
                secondList = new Linked(5000);
                firstList.append(secondList);
            }


            double minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                firstList = new Linked(size);
                secondList = new Linked(5000);
                double t0 = System.nanoTime();
                firstList.append(secondList);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }


            System.out.printf("%10d%15.1f\n",size ,minTime/1000);


        }
    }


    public static void secondTest(){
        Linked firstList,secondList;
        int[] sizesFirst = {5000,10000,20000,40000,80000,160000};
        int rounds = 1000;



        System.out.printf("%10s%15s\n","Size","Append");
        for (int size: sizesFirst) {
            for (int i = 0; i < 100; i++) {
                firstList = new Linked(5000);
                secondList = new Linked(size);
                firstList.append(secondList);
            }


            double minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                firstList = new Linked(5000);
                secondList = new Linked(size);
                double t0 = System.nanoTime();
                firstList.append(secondList);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }


            System.out.printf("%10d%15.1f\n",size ,minTime/1000);


        }
    }

    public static void thirdTest(){
        Linked firstList,secondList;
        int[] firstArray = fillArray(10),secondArray = fillArray(10);
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        int[] firstAndSecond = append(firstArray,secondArray);
        System.out.println(Arrays.toString(firstAndSecond));
        int[] sizesFirst = {5000,10000,20000,40000,80000,160000};
        int rounds = 10000;


        System.out.println("Append: dynamic a, fixed b");
        System.out.printf("%10s%15s%15s\n","Size","Linked", "Array");
        for (int size: sizesFirst) {
            for (int i = 0; i < 100; i++) {
                firstList = new Linked(5000);
                secondList = new Linked(size);
                firstList.append(secondList);
                firstArray = fillArray(size);
                secondArray = fillArray(5000);
                append(firstArray,secondArray);
            }


            double minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                firstList = new Linked(size);
                secondList = new Linked(5000);
                double t0 = System.nanoTime();
                firstList.append(secondList);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }


            System.out.printf("%10d%15.1f",size ,minTime/1000);

            minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                firstArray = fillArray(size);
                secondArray = fillArray(5000);
                double t0 = System.nanoTime();
                append(firstArray,secondArray);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }
            System.out.printf("%15.1f\n" ,minTime/1000);



        }
    }



    public static void fourthTest(){
        Linked firstList,secondList;
        int[] firstArray,secondArray;


        int[] sizesFirst = {5000,10000,20000,40000,80000,160000};
        int rounds = 10000;


        System.out.println("Append: fixed a, dynamic b");
        System.out.printf("%10s%15s%15s\n","Size","Linked", "Array");
        for (int size: sizesFirst) {

            firstArray = fillArray(5000);
            secondArray = fillArray(size);
            //100 rounds warmup
            for (int i = 0; i < 100; i++) {
                firstList = new Linked(5000);
                secondList = new Linked(size);
                firstList.append(secondList);

                append(firstArray,secondArray);
            }


            double minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                firstList = new Linked(5000);
                secondList = new Linked(size);
                double t0 = System.nanoTime();
                firstList.append(secondList);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }


            System.out.printf("%10d%15.1f",size ,minTime/1000);

            minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                double t0 = System.nanoTime();
                append(firstArray,secondArray);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }
            System.out.printf("%15.1f\n" ,minTime/1000);



        }
    }









    public static void allocationCost(){
        Linked firstList;
        int[] firstArray;


        int[] sizesFirst = {5000,10000,20000,40000,80000,160000};
        int rounds = 1000;


        System.out.println("Time to allocate:");
        System.out.printf("%10s%15s%15s\n","Size","Linked", "Array");
        for (int size: sizesFirst) {
            for (int i = 0; i < 100; i++) {
                firstList = new Linked(size);
                firstArray = fillArray(size);
            }


            double minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                double t0 = System.nanoTime();
                firstList = new Linked(size);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }


            System.out.printf("%10d%15.1f",size ,minTime/1000);

            minTime = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                double time = 0.000;
                double t0 = System.nanoTime();
                firstArray = fillArray(size);
                double t1 = System.nanoTime();
                time = t1 - t0 ;

                if(time < minTime)
                    minTime = time;
            }
            System.out.printf("%15.1f\n" ,minTime/1000);
        }
    }














    private static int[] fillArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = i*2;
        return array;
    }


    private static int[] append(int[] first, int[] second){
        int newSize =  first.length + second.length;
        int[] newArray = new int[newSize];
        int i = 0, j = 0;
        while ( i< first.length)
                newArray[i] = first[i++];
        while ( j < second.length){
            newArray[i+j] = second[j++];
        }


        return newArray;
    }
}
