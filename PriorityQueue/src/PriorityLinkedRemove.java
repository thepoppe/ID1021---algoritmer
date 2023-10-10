import java.util.NoSuchElementException;

/**
 * implements remove in constant time
 */
public class PriorityLinkedRemove {

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
     * Adding a new priority element to the list in sorted order.
     * @param prio the prio of the added item.
     */
    public void add(int prio){
        if (first == null)
            first = new  Node(prio);
        else {
            Node node = first;
            Node newNode = new  Node(prio);
            while (newNode.prio > node.prio){
                if(node.next ==null)
                    break;
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
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
        first = first.next;

        return node.prio;
    }


    public static void main(String[] args) {
        PriorityLinkedAdd test = new PriorityLinkedAdd();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(6);
        test.add(5);
        test.add(7);
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(test.remove());
    }
}
