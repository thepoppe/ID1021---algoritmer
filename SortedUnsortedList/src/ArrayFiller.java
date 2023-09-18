import java.util.Random;

public class ArrayFiller {


    public static int[] unsortedList(int size) {
        Random random = new Random();
        int[] createdList = new int[size];
        for (int i = 0; i < size; i++)
            createdList[i] = random.nextInt(size * 4);
        return createdList;
    }

    public static int[] sortedList(int size) {
        Random random = new Random();
        int[] createdList = new int[size];
        int nextValue = 0;
        for (int i = 0; i < size; i++) {
            nextValue += random.nextInt(10);
            createdList[i] = nextValue + 1;
        }
        System.out.println(nextValue);
        return createdList;
    }

    public static int[] keyFiller(int numberOfKeys, int arraySize){
        Random random = new Random();

        int[] arrayWithKeys = new int[numberOfKeys];
        for (int i = 0; i < numberOfKeys ; i++) {
            arrayWithKeys[i] = random.nextInt(arraySize*5);
        }
        return arrayWithKeys;
    }


}
