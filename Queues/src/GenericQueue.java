public class GenericQueue <T> {

    private Node<T> head;
    private Node<T> tail;
    private class Node <E>{
        T object;
        Node<E> next;
        private Node(T object, Node<E> next) {
            this.object = object;
            this.next = next;
        }
    }
    public GenericQueue() {
        this.head = null;
        this.tail = null;
    }
    public void add(T item) {
        if (head == null)
            this.tail = this.head = new Node<>(item, null);
        else {
            tail.next = new Node<>(item, null);
            tail = tail.next;
        }
    }
    public T remove() {
        T item;
        if (head == tail){
            item =  head.object;
            tail = head = null;
        }
        else {
            item =  head.object;
            head = head.next;
        }
        return item;
    }

    public boolean isEmpty(){
            return head == null;
    }

}
