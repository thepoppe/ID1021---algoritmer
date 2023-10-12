import java.io.BufferedReader;
import java.io.FileReader;
public class Zip {
    Node[] data;
    int max;
    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }

        public String toString(){
            return  code+ " - " +name+ " - " + pop;
        }
    }



    public Node lookupLinear(String zip){
        if (data == null)
            throw new IllegalArgumentException("No data");

        Node found = null;
        for ( int i = 0; i < max; i++){
            if(data[i].code.compareToIgnoreCase(zip) == 0){
                found = data[i];
                break;
            }
        }
        return found;
    }

    public Node lookupBinary(String zip) {
        if (data == null)
            throw new IllegalArgumentException("No data");

        int low = 0;
        int high = max-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(data[mid].code.compareToIgnoreCase(zip)==0)
                return data[mid];
            else if (data[mid].code.compareToIgnoreCase(zip) < 0)
                low = mid +1;
            else high = mid -1;
        }
        return null;
    }


    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println("file" + file + " not found");
        }

    }

    public static void main(String[] args) {
        Zip test = new Zip("Hash/file.txt");
        Node a = test.lookupLinear("111 15");
        Node b = test.lookupBinary("984 99");
        System.out.println(a);
        System.out.println(b);




    }
}
