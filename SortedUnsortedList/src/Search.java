public class Search {
    public static boolean linearSearch(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }


    public static boolean binarySearch(int[] array, int key){
        int first = 0, last = array.length-1;
        while (first <= last ){
            int middle = (first + last)/2;
            if (array[middle] == key)
                return true;
            else if(array[middle]< key)
                first = middle +1;
            else
                last = middle -1;
        }
        return false;
    }

}
