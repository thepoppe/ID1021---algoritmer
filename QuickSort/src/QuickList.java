public class QuickList <T extends Comparable<T>>{
    Node first;
    Node last;

    public QuickList() {
        this.first = null;
        this.last = null;
    }
    public QuickList( int[] list){
        // not working
    }

    public void printAll() {
        Node node = first;
        while ( node!=null ){
            if(node.next!=null)
                System.out.print(node.item +"->");
            else System.out.println(node.item);
            node = node.next;
        }
    }

    public void clear() {
        first = null;
        last =null;
    }

    private class Node {
        T item;
        Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public void  add(T item){
        if ( this.first == null)
            first = last = new Node(item,null);
        else{
            last.next = new Node(item,null);
            last = last.next;
        }
    }


    public void append(QuickList<T> tail){
        if (tail != null){

            if (this.last != null)
                this.last.next = tail.first;
            else this.first = tail.first;

            //assigns last to the last in tail
            if(tail.last!=null)
                this.last = tail.last;

            //to ensure the temp list has no connections
            tail.first=null;
            tail.last=null;
        }
    }


    public void prepend(QuickList<T> front){
        //if the list front contains nodes
        if(front != null && front.last!=null){

            //if this aka the pivot happens to be null
            if (this.last == null){
                this.first = front.first;
                this.last = front.last;
            }
            else{
                front.last.next = this.first;
                first = front.first;
            }

            //to ensure the temp list has no connections
            front.first = null;
            front.last = null;
        }
    }



    private void cons(Node node){
        //insert the node at the last place
        if ( this.first == null)
            first = last = node;

        else{
            last.next = node;
            last = last.next;
        }

        //ensure that its next pointer is not pointing to something else
        node.next = null;
    }

    public void sort(){
        if(this.first == this.last)
            return;

        //creates temp lists
        QuickList<T> smaller =  new QuickList<>();
        QuickList<T> larger =  new QuickList<>();

        //assigns the pivot
        Node pivot  = this.first;
        T pivotItem = pivot.item;
        Node current =  pivot.next;

        //disconnects this from current
        this.last = this.first;
        this.last.next = null;



        //partition
        while (current!= null){
            //important to move to the next since cons remove the next pointer
            Node next = current.next;

            //sort into lists
            if(pivotItem.compareTo(current.item)> 0)
                smaller.cons(current);
            else larger.cons(current);
            current =  next;
        }

        //Separates the pivot aka this from the chain
        this.first = this.last = pivot;
        pivot.next = null;


        //recursive sort
        smaller.sort();
        larger.sort();

        //merge,   this = pivot, other references are removed from "this".
        this.append(larger);
        this.prepend(smaller);

    }

}
