import java.io.BufferedReader;
import java.io.FileReader;
public class ZipImproved {
    private final int capacity;
    Node[] data;
    int max;

    private class Node {
        Integer code;
        String name;
        Integer pop;



        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }

        public String toString(){
            return  code+ " - " +name+ " - " + pop;
        }
    }



    public int lookup(Integer key){
        if (data == null)
            throw new IllegalArgumentException("No data");
        int counter = 1;
        int index = keyToHash(key);
        while (data[index] !=null){
            if(data[index].code.equals(key))
                break;
            index++;
            counter++;
        }

        return counter;
    }



    public ZipImproved(String file, int capacity) {
        this.capacity = capacity;
        data = new Node[capacity];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            max = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                int hashIndex = keyToHash(code);
                add(new Node(code, row[1], Integer.valueOf(row[2])), hashIndex);
                }
            }
        catch (Exception e) {
            System.out.println("file" + file + " not found");
        }
    }

    private void add(Node node, int hashIndex) {
        int index = hashIndex;
        while (data[index] !=null)
            index++;
        data[index] = node;

    }

    private Integer keyToHash(Integer key){
        return  key %capacity;
    }

    public static void main(String[] args) {
        ZipImproved test = new ZipImproved("Hash/postnummer.csv", 13513);
        int a = test.lookup(11115);
        int b = test.lookup(98499);

        System.out.println(a);
        System.out.println(b);




    }















}
