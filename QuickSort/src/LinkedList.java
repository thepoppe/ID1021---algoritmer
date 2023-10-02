public class LinkedList {

    private Node first;
    private Node last;

    public Node getLast() {
        return last;
    }

    public LinkedList createCopy() {
        LinkedList newlist = new LinkedList();

        Node node = first;
        while( node!=null){
            Integer value = node.value;
            newlist.add(value);
            node = node.next;
        }
        return newlist;
    }


    class Node {
        Node next;
        int value;

        Node(int value, Node nextNode) {
            this.value = value;
            this.next = nextNode;
        }
    }

    public void printAll(){
        if(first== null)
            return;
        Node node = first;
        while (node.next!=null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println(node.value);
    }

    public void quicksort(){
        if(first != last) {
            Node pivot = first;
            LinkedList smaller = new LinkedList();
            LinkedList larger = new LinkedList();
            partition(pivot,smaller,larger);
            smaller.quicksort();
            larger.quicksort();

            merge(pivot,smaller,larger);
        }
    }



    private void merge(Node pivot, LinkedList smaller, LinkedList greater) {
        first = pivot;
        last = pivot;
        pivot.next =null;

        if(smaller.first != null) {
            first = smaller.first;
            smaller.last.next = pivot;
        }
        if(greater.first!=null) {
            pivot.next = greater.first;
            last = greater.last;
        }
    }

    private void partition(Node pivot, LinkedList lesser, LinkedList greater){
        Integer pivotValue = pivot.value;
        Node iteratingNode = pivot;

        while (iteratingNode.next!=null){
            iteratingNode = iteratingNode.next;
            Integer currentValue = iteratingNode.value;
            if(currentValue <= pivotValue)
                lesser.insert(iteratingNode);
            else {
                greater.insert(iteratingNode);
            }
        }
        if(lesser.last != null)
            lesser.last.next =null;
        if(greater.last != null)
            greater.last.next =null;
    }





    public void insert(Node node){
        if ( this.first == null)
            first = last = node;
        else{
            last.next = node;
            last = last.next;
        }
    }
    public void  add(int value){
        if ( this.first == null)
            first = last = new Node(value,null);
        else{
            last.next = new Node(value,null);
            last = last.next;
        }
    }
    public void clear(){
        this.first = null;
        this.last = null;
    }
}

