import java.util.NoSuchElementException;

/**
 * implements add in constant time
 */
public class PriorityLinkedAdd {

    private Node first;

    public void clear() {
        first = null;
    }

    private class Node{
        private int prio;
        private Node next;

        Node(int prio){
            this.prio = prio;
            next = null;
        }
    }

    /**
     * Adding a new priority element to the list with constant time.
     * Add it to the first place is done in constant time
     * @param prio the prio of the added item.
     */
    public void add(int prio){
        if (first == null)
            first = new Node(prio);
        else {
            Node node = new Node(prio);
            node.next = first;
            first = node;
        }
    }


    /**
     * removing an item after adding with linear time means
     * a linear search is needed for the lowest prio.
     * @return lowest prio
     */
    public int remove(){
        if (first == null)
            throw new NoSuchElementException("queue is empty");

        Node node = first;
        Node minPrio = first;
        Node nodeBeforeMin = null;

        while (node.next != null){
            Node prev = node;
            node = node.next;

            if (minPrio.prio > node.prio) {
                nodeBeforeMin = prev;
                minPrio = node;
            }
        }

        if (nodeBeforeMin == null)
            first = first.next;
        else nodeBeforeMin.next = nodeBeforeMin.next.next;

        return minPrio.prio;

    }


    public static void main(String[] args) {
        PriorityLinkedAdd test = new PriorityLinkedAdd();
        test.add(4);
        test.add(2);
        test.add(3);
        test.add(7);
        test.add(6);
        test.add(5);
        test.add(1);
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
    }
}
