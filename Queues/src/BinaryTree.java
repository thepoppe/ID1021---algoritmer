
import java.util.Iterator;
import java.util.Objects;

public class BinaryTree implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }

    public class Node {
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
            if (searchKey == key)
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

    public Integer lookupInternal(Integer searchKey){
        return root.lookupInternal(searchKey);
    }

    Node root;
    public BinaryTree(){
        root = null;
    }

    public void add( Integer key, Integer value) {
        this.root = addHelper(this.root,key,value);
    }
    private Node addHelper(Node node, Integer key, Integer value){

        if(node == null)
            return new Node(key,value);

        else if (key < node.key)
            node.left = addHelper(node.left, key, value);

        else if (key > node.key)
            node.right = addHelper(node.right, key, value);

        return node;
    }


    public Integer lookup( Integer key ){
        Node foundNode = lookupHelper(this.root, key);
        return (foundNode == null) ? null : foundNode.value;
    }
    private Node lookupHelper(Node node, Integer key){
        if ( node == null)
            return null;
        else if ( key.equals(node.key))
            return node;
        else if (key < node.key)
            node = lookupHelper(node.left,key);
        else
            node = lookupHelper(node.right,key);

        return node;
    }
    private Node lookupHelperImproved(Node node, Integer key){
        if (node == null)
            return null;

        if (Objects.equals(key, node.key))
            return node;
        else if (key < node.key)
            return lookupHelperImproved(node.left,key);
        else
            return lookupHelperImproved(node.right,key);
    }


}
