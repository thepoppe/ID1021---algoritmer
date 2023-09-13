public class Search {
    public static boolean linearSearch(int[] array, int key) {
        for (int i : array) {
            if (i == key) {
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
    public static int fasterSearch(int[] list1, int[]list2 ){
        int i =0,j=0,duplicates = 0;
        while ( i < list1.length && j < list2.length){
            if (list1[i]> list2[j])
                j++;
            else if (list1[i] == list2[j]) {
                duplicates++;
                i++;
                j++;
            }
            else j++;
        }
        return duplicates;
    }



}
