public class FirstQueue {

    private Node head;
    private Node tail;
    private class Node {
        Integer item;
        Node next;
        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
    public FirstQueue() {
        this.head = null;
        this.tail = null;
    }
    public void add(Integer item) {
        if (head == null)
            this.tail = this.head = new Node(item, null);
        else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
    }
    public Integer remove() {
        Integer value;
        if (head == tail){
            value = head.item;
            tail = head = null;
        }
        else {
            value = head.item;
            head = head.next;
        }
        return value;
    }

}
