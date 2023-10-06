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
            if(tail.last!=null)
                this.last = tail.last;
        }
    }


    public void prepend(QuickList<T> front){
        if(front != null){
            if(front.last != null)
                this.last.next = this.first;
            if (this.last == null)
                this.last = front.last;
            if(front.first != null)
                this.first = front.first;

            front.first = null;
            front.last = null;
        }
    }



    private void cons(Node node){
        if ( this.first == null)
            first = last = node;
        else{
            last.next = node;
            last = last.next;
        }
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

        //partition
        while (current!= null){
            Node next = current.next;
            if(pivotItem.compareTo(current.item)> 0)
                smaller.cons(current);
            else larger.cons(current);
            current =  next;
        }

        //recursive sort
        smaller.sort();
        larger.sort();

        //merge
        //This = pivot, other references are removed from "this".
        this.append(larger);
        this.prepend(smaller);

    }

}
