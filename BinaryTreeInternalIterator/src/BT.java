import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

public class BT implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

     class Node {
        Integer key;
        Integer value;
        Node left;
        Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }

        private Integer lookupInternal(Integer searchKey) {
            if (Objects.equals(searchKey, key))
                return value;
            else if (searchKey < key) {
                if (left != null)
                    return left.lookupInternal(searchKey);
            } else if (searchKey > key) {
                if (right != null)
                    return right.lookupInternal(searchKey);
            }
            return null;

        }
    }

    public class TreeIterator implements Iterator <Integer>{
        java.util.Stack<Node> stack;
        Node next;

        public TreeIterator() {
            this.stack = new Stack<>();

            if(root == null)
                next = null;
            else {
                Node nxt  = root;
                while (nxt.left!= null){
                    stack.push(nxt);
                    nxt = nxt.left;
                }
                this.next = nxt;

            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements to iterate");
            }

            Node current = next;

            // Find the leftmost node in the right subtree if it exists
            if (current.right != null) {
                Node temp = current.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }

            // Set 'next' to null initially
            Node parent = null;

            // Pop until finding an ancestor with a greater value
            while (!stack.isEmpty()) {
                parent = stack.pop();
                if (parent.value > current.value) {
                    break;
                }
            }

            // Set 'next' to the parent node (or null if parent is null)
            next = parent;

            return current.value;
        }

    }



    public Integer lookup(Integer searchKey){
        return root.lookupInternal(searchKey);
    }

    Node root;
    public BT(){
        root = null;
    }

    public void add( Integer key, Integer value) {
        this.root = addHelper(this.root,key,value);
    }
    private BT.Node addHelper(BT.Node node, Integer key, Integer value) {
        if (node == null)
            return new BT.Node(key, value);

        else if (key < node.key)
            node.left = addHelper(node.left, key, value);

        else if (key > node.key)
            node.right = addHelper(node.right, key, value);

        return node;
    }




}
