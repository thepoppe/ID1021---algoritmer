import java.util.LinkedList;
import java.util.Queue;

public class Heap {
    private Node root;

    public void clear() {
        root = null;
    }


    private class Node

    {
        int priority;

        int size;
        Node left;
        Node right;
        Node(int prio){
            this.priority = prio;
            size  = 1;
            left = null;
            right = null;
        }
        private void add(int prio){
            size++;
            if (prio < this.priority){
                addToChildren(this.priority);
                this.priority = prio;
            }
            else
                addToChildren(prio);
        }

            private void addToChildren(int prio){
                if (!addToNullBranch(prio)){
                    addToShortestBranch(left,right,prio);
                }

            }
        private void addToShortestBranch(Node left, Node right, int prio) {
            if (right.size < left.size)
                right.add(prio);
            else
                left.add(prio);

        }

        private boolean addToNullBranch(int prio){
            if (this.left !=null && this.right != null)
                return false;
            if(this.left == null)
                this.left = new Node(prio);
            else{
                this.right = new Node(prio);
            }
            return true;
        }





        private Node remove(){

            if(this.hasBranch()){
                size--;
                if(hasHigherPrio(left,right) ){
                    this.priority = left.priority;
                    left = left.remove();
                    }
                else{
                    this.priority = right.priority;
                    right = right.remove();
                }
                return this;
            }

            else return null;

        }

        private boolean hasBranch() {
            return size > 1;
        }

        private boolean hasHigherPrio(Node n1, Node n2){
            if(n1 == null)
                return false;
            else if (n2 == null)
                return true;
            else
                return n1.priority < n2.priority;
        }

        public int pushHelper(int inc) {
            this.priority +=inc;
            return this.sink(0);
        }

        private int sink(int startDepth) {

            if (this.hasBranch()) {
                if (hasHigherPrio(left, this) || hasHigherPrio(right,this)) {
                    if (hasHigherPrio(left, right)) {
                        startDepth++;
                        swapPrio(left, this);
                        startDepth = left.sink(startDepth);
                    } else {
                        startDepth++;
                        swapPrio(right, this);
                        startDepth = right.sink(startDepth);
                    }
                }
            }

            return startDepth;
        }

        private void swapPrio(Node n1, Node n2) {
            int temp = n1.priority;
            n1.priority = n2.priority;
            n2.priority = temp;
        }


    }
    public void enqueue(int prio){
        if(root == null)
            this.root = new Node(prio);
        else
           root.add(prio);
    }


    public int dequeue(){
        if(root == null)
            throw new IllegalArgumentException("heap is empty");
        int priority = root.priority;
        this.root = root.remove();
        return priority;
    }

    public int push(int inc){
        if(root.size == 1){
            root.priority += inc;
            return 0;
        }
        else {
            return root.pushHelper(inc);
        }
    }


    public void printHeap() {
        if (root == null) {
            System.out.println("Heap is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                System.out.print(node.priority + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.println(); // Move to the next level
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        // Test 1: Enqueue elements with various priorities
        heap.enqueue(10);
        heap.enqueue(5);
        heap.enqueue(15);
        heap.enqueue(3);
        heap.enqueue(12);

        System.out.println("Heap after enqueue:");
        heap.printHeap();

        // Test 2: Pushing
        heap.push(7);
        heap.push(20);

        System.out.println("Heap after pushing:");
        heap.printHeap();

        // Test 3: Dequeue
        int highestPriority = heap.dequeue();
        System.out.println("Dequeued: " + highestPriority);
        System.out.println("Heap after dequeue:");
        heap.printHeap();

        // Test 4: Clear the heap
        heap.clear();
        System.out.println("Heap after clear:");
        heap.printHeap();

        // Test 5: Enqueue when the heap is empty
        heap.enqueue(8);
        System.out.println("Heap after enqueue to an empty heap:");
        heap.printHeap();

        // Test 6: Enqueue with duplicate priorities
        heap.enqueue(8);
        heap.enqueue(8);
        System.out.println("Heap after enqueue with duplicate priorities:");
        heap.printHeap();

        // Test 7: Pushing when the root has the highest priority
        heap.push(5);
        System.out.println("Heap after pushing when the root has the highest priority:");
        heap.printHeap();

        // Test 8: Pushing when the root has the lowest priority
        heap.push(25);
        System.out.println("Heap after pushing when the root has the lowest priority:");
        heap.printHeap();
    }


}
