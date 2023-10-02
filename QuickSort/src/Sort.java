
public class Sort {




    private static void partition(LinkedList.Node pivot, LinkedList smaller, LinkedList larger) {
        LinkedList.Node current = pivot;
        while (pivot!=null) { //incorrect

            if(current.value < pivot.value)
                smaller.insert(current);
            if(current.value > pivot.value)
                larger.insert(current);
            current = current.next;
        }

    }





    public static void quickSort(int[] originalArray){
        if (originalArray.length == 0)
            return;
        quickSort(originalArray,0, originalArray.length -1);
    }

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

    private static int partitionG2G(int[] arr, int low, int high) {
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

    private static void swap(int[] arr, int i, int high) {
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
    }


}

