import java.io.BufferedReader;
import java.io.FileReader;

public class CollisionTest {

    private Integer[] keys;

    public Integer[] getKeys() {
        return keys;
    }

    public CollisionTest(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            keys = new Integer[9675];
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                keys[i++] = code;
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i< keys.length ; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10d", cols[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        secondTest();
    }
    public static void secondTest(){
        CollisionTest collisionTest = new CollisionTest("Hash/postnummer.csv");
        System.out.println(collisionTest.keys[0]);
        System.out.println(collisionTest.keys[9675-1]);
        int[] modValues = {13513,13513*2,21314,21000,22000,22557,33333};
        for (int mod : modValues) {
            collisionTest.collisions(mod);
        }

    }

    public static void firstTest(){
        CollisionTest collisionTest = new CollisionTest("Hash/postnummer.csv");
        System.out.println(collisionTest.keys[0]);
        System.out.println(collisionTest.keys[9675-1]);
        int[] modValues = {10000, 20000, 12345,13513,13600,14000};
        for (int mod : modValues) {
            collisionTest.collisions(mod);
        }

    }
}
