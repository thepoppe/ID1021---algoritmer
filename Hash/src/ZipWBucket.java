import java.io.BufferedReader;
import java.io.FileReader;
public class ZipWBucket {
    private final int capacity;
    Bucket[] data;
    int max;
    public class Bucket{
        Node first;
        int size;
        
        public Bucket(Node node){
            first = node;
            size =1;
        }

        private void add(Node node){
            Node cur = first;
            size ++;
            while (cur.next!= null)
                cur = cur.next;
            cur.next = node;
        }
        Node findMatching(Integer key){
            Node node = first;
            while (node.next != null){
                if (node.code.equals(key))
                    return node;
                node = node.next;
            }
            return null;

        }


    }
    private class Node {
        Integer code;
        String name;
        Integer pop;
        private Node next;

        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
            this.next=null;
        }

        public String toString(){
            return  code+ " - " +name+ " - " + pop;
        }
    }



    public Node lookup(Integer key){
        if (data == null)
            throw new IllegalArgumentException("No data");

        Bucket bucket = data[keyToHash(key)];
        if(bucket!=null) {
            return bucket.findMatching(key);
        }

        return null;
    }



    public ZipWBucket(String file, int capacity) {
        this.capacity = capacity;
        data = new Bucket[capacity];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            max = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                if(data[keyToHash(code)]!= null)
                    data[keyToHash(code)].add(new Node(code, row[1], Integer.valueOf(row[2])));
                else {
                    data[keyToHash(code)] = new Bucket(new Node(code, row[1], Integer.valueOf(row[2])));
                    max++;
                }
            }
            max--;

        } catch (Exception e) {
            System.out.println("file" + file + " not found");
        }

    }

    private Integer keyToHash(Integer key){
        return  key %capacity;
    }

    public static void main(String[] args) {
        ZipWBucket test = new ZipWBucket("Hash/postnummer.csv", 13513);
        Node a = test.lookup(11115);
        Node b = test.lookup(98499);

        System.out.println(a);
        System.out.println(b);




    }















}
