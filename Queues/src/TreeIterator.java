import java.util.Iterator;



public class TreeIterator implements Iterator<Integer>{
    private BinaryTree.Node next;
    private final GenericQueue<BinaryTree.Node> queue;

    public TreeIterator(BinaryTree.Node root){
        this.next = root;
        this.queue = new GenericQueue<>();

    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer value = next.value;
        if(next.left != null)
            queue.add(next.left);
        if(next.right != null)
            queue.add(next.right);
        if(queue.isEmpty())
            next = null;
        else next = queue.remove();

        return value;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}