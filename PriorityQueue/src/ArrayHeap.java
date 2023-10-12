import java.util.NoSuchElementException;

public class ArrayHeap {


    private Integer[] array;
    private int first;
    private int last;

    public ArrayHeap(int size){
        this.array = new Integer[size];
        first = 0;
        last = 0;
    }
    public int getLength(){
        return last;
    }


    public void add(int prio){
        if (first == last){
            array[first] = prio;
            last++;

        }
        else if(last == array.length){
            System.out.printf("Full");

        }
        else {
            array[last] = prio;
            bubble(last);
            last++;
        }



    }
    private int parentTo(int i){
        return ((i - 1) / 2);
    }
    private void bubble(int i) {
        if( i > first) {
            int parentIndex = parentTo(i);
            if (array[parentIndex] > array[i]) {
                swapPrio(parentIndex, i);
                bubble(parentIndex);
            }
        }
    }



    private void swapPrio(int p1, int p2){
            int temp = array[p1];
            array[p1] = array[p2];
            array[p2] = temp;
    }


    public int remove(){
        if (isEmpty())
            throw new NoSuchElementException("List is empty");

        int value = array[first];
        swapPrio(first, --last);
        array[last] = null;
        sink(first);
        return value;
    }
    private void sink(int i) {
        int firstChild = firstChildTo(i);
        int secondChild = secondChildTo(i);

        if(childrenInRange(firstChild, secondChild) ) {
            int child = prioChild(firstChild,secondChild);
            if(hasHigherPrio( child, i )){
                swapPrio(child ,i);
                sink(child);
            }
        }
    }
    private boolean childrenInRange(int c1,int c2) {
        return c1 < last && c2 < last;
    }

    private int prioChild(int c1, int c2){
        if(array[c1] ==null)
            return c2;
        else if (array[c2] == null)
            return c1;
        else
            return (array[c1] < array[c2] ? c1 : c2);

    }
    private boolean hasHigherPrio(int c1, int c2){
        return array[c1] < array[c2];
    }

    private int secondChildTo(int i) {
        return ((i*2)+2);
    }

    private int firstChildTo(int i) {
        return ((i*2)+1);
    }


    public static void main(String[] args) {
        testEdgeCases();


    }

    private static void testRemove(){
        ArrayHeap heap = new ArrayHeap(100);
        heap.add(1);
        heap.add(4);
        heap.add(2);
        heap.add(6);
        heap.add(5);
        heap.add(3);
        heap.add(3);
        int size = heap.getLength();
        for(int i = 0; i < size;i++)
            System.out.println(heap.remove());
    }



    public static void testEdgeCases() {
        ArrayHeap pq = new ArrayHeap(100);

        System.out.println("Test: Insertion and Removal");
        pq.add(5);
        pq.add(10);
        pq.add(2);
        System.out.println("Expected: 2, Actual: " + pq.remove());
        System.out.println("Expected: 5, Actual: " + pq.remove());
        System.out.println("Expected: 10, Actual: " + pq.remove());
        System.out.println("Is Empty? " + pq.isEmpty());
        System.out.println("Size: " + pq.getLength());

        System.out.println("\nTest: Peek and Size");
        pq.add(8);
        pq.add(3);
        System.out.println("Expected: 3, Actual Peek: " + pq.peek());
        System.out.println("Size: " + pq.getLength());
        pq.remove();
        System.out.println("Expected: 8, Actual Peek: " + pq.peek());
        System.out.println("Size: " + pq.getLength());
        pq.remove();


        System.out.println("\nTest: Empty Queue");
        System.out.println("Is Empty? " + pq.isEmpty());
        System.out.println("Size: " + pq.getLength());
        System.out.println("Removing from empty queue:");
        try {
            pq.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Expected: List is empty");
            System.out.println("Actual: " + e.getMessage());
        }

        System.out.println("\nTest: Clear Queue");
        pq.add(7);
        pq.add(1);
        pq.clear();
        System.out.println("Is Empty? " + pq.isEmpty());
        System.out.println("Size: " + pq.getLength());
    }

    public void clear() {
        for ( int i = 0; i <  last; i++)
            array[i] = null;
        last = 0;
    }

    private boolean isEmpty() {
        return first == last;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return array[0];
    }
}
