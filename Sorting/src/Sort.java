public class Sort {

    public static void selection(int[] array){
        for (int i = 0; i < array.length -1; i++){
            int currentSmallest = array[i];
            int indexForSmallestItem = i;
            for (int j = i+1; j < array.length ; j++) {
                if(array[j] < currentSmallest){
                    indexForSmallestItem = j;
                }
            }
            if(indexForSmallestItem != i) {
                swap(array,i, indexForSmallestItem);
            }
        }
    }

    public static void selectionHighToLow(int[] array){
        for (int i = 0; i < array.length -1; i++){
            int currentSmallest = array[i];
            int indexForLargestItem = i;
            for (int j = i+1; j < array.length ; j++) {
                if(array[j] > currentSmallest){
                    indexForLargestItem = j;
                }
            }
            if(indexForLargestItem != i) {
                swap(array,i, indexForLargestItem);
            }
        }
    }




    public static void insertion(int[] array){
        for (int i = 1 ; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j]; j--) {
                swap(array,j,j-1);
            }
        }
    }
    private static void swap(int[] array, int firstPos,int secondPos){
        int firstValue = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = firstValue;
    }

    public static void mergeSort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        mergeSort(org, aux, 0, org.length -1);
    }

    private static void mergeSort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi)/2;
// sort the items from lo to mid
            mergeSort(org,aux,lo,mid);

// sort the items from mid+1 to hi
            mergeSort(org,aux,mid+1,hi);


// merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
// copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
// let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
// for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {
// if i is greater than mid then
// move the j'th item to the org array, update j
            if (i > mid)
                org[k] = aux[j++];
// else if j is greate than hi then
// move the i'th item to the org array, update i
            else if (j > hi)
                org [k] = aux[i++];
// else if the i'th item is smaller than the j¨ath item,
// move the i'th item to the org array, update i
            else if (aux[i] < aux[j])
                org[k] = aux[i++];
// else
// move the j'th item to the org array, update j
            else org[k] = aux[j++];
        }
    }







    public static void quickSort(int[] originalArray){
        if (originalArray.length == 0)
            return;
        quickSort(originalArray,0, originalArray.length -1);
    }


    /*
        if (mid!=min)
            quickSort(org,firstIndex,pivotPosition-1);
        if (mid!=max)
            quickSort(org,pivotPosition+1,lastIndex);
     */

    private static void quickSort(int[] org,  int firstIndex, int lastIndex) {
        if( firstIndex < lastIndex){
            int pivotPosition = partition(org,firstIndex,lastIndex);

            quickSort(org,firstIndex,pivotPosition-1);
            quickSort(org,pivotPosition+1,lastIndex);

        }

    }


    private static int partition(int[] org,  int firstIndex, int lastIndex) {

        int pivot = org[firstIndex];
        int i = firstIndex+1, j = lastIndex + 1;
        while (i < j) {
            if (org[i] > pivot)
                swap(org, i, --j);
            else i++;
        }
        swap(org,firstIndex,i-1);

        return i-1;

    }
    private static int partitionLecture(int[] org,  int firstIndex, int lastIndex) {

        int pivot = org[firstIndex];
        int i = firstIndex, j = lastIndex;
        while(i!=j){
            while (org[j] > pivot && j>i) {
                j--;
            }
            while (org[i] <= pivot && i<j){
                i++;
            }
            swap(org,firstIndex,j);
        }

        return j;

    }

    private static int partition2(int[] org,  int firstIndex, int lastIndex) {
        int pivot = firstIndex;
        int  i = firstIndex,j =firstIndex-1;
        while (j < pivot){
            if(org[j] < org[pivot])
                swap(org, ++i, j);
            else j++;
        }

        return i;

    }

    private static int partitionG2G(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

}
