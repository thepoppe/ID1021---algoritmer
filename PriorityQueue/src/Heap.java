public class Heap {
    private Node root;


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
            else{
                addToChildren(prio);
            }

            }

            private void addToChildren(int prio){
                if (!addToNullBranch(this.priority)){
                    addToShortestBranch(left,right,this.priority);
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

            if(left.priority < right.priority){
                this.priority = left.priority;


                Node rightBranch = right;

            }



            return this;
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
        Node node = root;
        this.root = root.remove();
        return node.priority;
    }


    public static void main(String[] args) {
        Heap test = new Heap();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        System.out.println("Done");
    }

}
