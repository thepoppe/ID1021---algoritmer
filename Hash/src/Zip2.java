import java.io.BufferedReader;
import java.io.FileReader;
public class Zip2 {
    Node[] data;
    int max;
    public class Node {
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



    public Node lookupLinear(Integer zip){
        if (data == null)
            throw new IllegalArgumentException("No data");

        Node found = null;
        for ( int i = 0; i < max; i++){
            if(data[i].code.equals(zip)){
                found = data[i];
                break;
            }
        }
        return found;
    }

    public Node lookupBinary(Integer zip) {
        if (data == null)
            throw new IllegalArgumentException("No data");

        int low = 0;
        int high = max;
        while (low <= high){
            int mid = (low + high) / 2;
            if(data[mid].code.equals(zip))
                return data[mid];
            else if (data[mid].code.compareTo(zip) < 0)
                low = mid +1;
            else high = mid -1;
        }
        return null;
    }


    public Zip2(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println("file" + file + " not found");
        }

    }

    public static void main(String[] args) {
        Zip2 test = new Zip2("Hash/postnummer.csv");
        Node a = test.lookupLinear(11115);
        Node b = test.lookupBinary(98499);
        System.out.println(a);
        System.out.println(b);




    }
}
