import java.util.Iterator;


public class TreeIterator implements Iterator<Integer>{
    private BinaryTree.Node next;
    private final GenericStack<BinaryTree.Node> stack;

    public TreeIterator(BinaryTree.Node root){
        this.next = root;
        this.stack = new GenericStack<>();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || next != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) // the stack needs to be checked to traverse back up
            return null;
        while (next.left!=null){
            stack.push(next);
            next = next.left;
        }
        BinaryTree.Node node = stack.pop();
        next = node.right;
        return node.value;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}

