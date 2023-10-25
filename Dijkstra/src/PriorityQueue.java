import java.util.ArrayList;
import java.util.NoSuchElementException;


public class PriorityQueue {


    private final ArrayList<Path> array;
    private final int first;
    private int last;

    public PriorityQueue(){
        this.array = new ArrayList<>();
        first = 0;
        last = 0;
    }
    public int getLength(){
        return last;
    }


    public void add(Path path) {
            array.add(path);
            path.setIndex(last);
            if(array.size()>1) {
                bubble(last);
            }
            last++;


    }

    private int parentTo(int i){
        return ((i - 1) / 2);
    }
    private void bubble(int i) {
        if( i > first) {
            int parentIndex = parentTo(i);
            if (array.get(parentIndex).compareTo(array.get(i)) > 0) {
                swapPrio(parentIndex, i);
                bubble(parentIndex);
            }
        }

    }

    private void swapPrio(int p1, int p2) {
        if(array.size() >1){
        Path temp = array.get(p1);
        array.set(p1, array.get(p2));
        array.set(p2, temp);

        array.get(p1).setIndex(p1);
        array.get(p2).setIndex(p2);}
    }






    public boolean isEmpty() {
        return first == last;
    }
    public Path poll(){
        if (isEmpty())
            throw new NoSuchElementException("List is empty");

        Path path = array.get(first);
         swapPrio(first, --last);
         array.remove(last);
         sink(first);


        path.setIndex(null);

        return path;
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
        return c1 < last || c2 < last;
    }

    private int prioChild(int c1, int c2){

        if(c2>= last)
            return c1;
        else if (c1 >= last)
            return c2;
        else
            return hasHigherPrio(c1,c2)? c1 : c2;

    }
    private boolean hasHigherPrio(int c1, int c2){
        return array.get(c1).compareTo(array.get(c2)) < 0;
    }

    private int secondChildTo(int i) {
        return ((i*2)+2);
    }

    private int firstChildTo(int i) {
        return ((i*2)+1);
    }



    public Path contains(City connectedCity) {
        for (Path path : array) {
            if (path.getCity().equals(connectedCity))
                return path;
        }
        return null;
    }


    public void updatePath(Path path, Integer newDist, City newPrev) {
        int prio = path.getIndex();
        array.get(prio).updatePath(newDist,newPrev);
        bubble(prio);
    }

    public void clear() {
        array.clear();
        last = first;
    }
}
