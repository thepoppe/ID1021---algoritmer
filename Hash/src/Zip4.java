import java.io.BufferedReader;
import java.io.FileReader;
public class Zip4 {
    Node[] data;
    int max;

    int capacity;
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



    public Node lookup(Integer key){
        if (data == null)
            throw new IllegalArgumentException("No data");
        return data[keyToHash(key)];
    }

    private Integer keyToHash(Integer key){
        return  key %capacity;
    }




    public Zip4(String file) {
        this.capacity = 10000;
        data = new Node[capacity];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[keyToHash(code)] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println("file" + file + " not found");
        }

    }



    public static void main(String[] args) {
        Zip4 test = new Zip4("Hash/postnummer.csv");
        Node a = test.lookup(11115);
        Node b = test.lookup(98499);
        System.out.println(a);
        System.out.println(b);




    }
}
