import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Bench {


    public static void main(String[] args) {
        improvedTestSize();
    }


    private static void improvedTestSize(){
        CollisionTest keyCreator = new CollisionTest("Hash/postnummer.csv");
        Integer[] keys = keyCreator.getKeys();
        Random rnd = new Random();
        int sample = 500;
        int[] chosenKeys = new int[sample];
        for (int j = 0; j < chosenKeys.length; j++) {
            chosenKeys[j]  = rnd.nextInt(keys.length - 1);
        }
        int[] sizes = {13513,33333,61111};

        try {
            for (int i = 0; i < 3; i++){
            PrintWriter printer = new PrintWriter(new FileWriter("data"+i+".dat"));
                ZipImproved hash = new ZipImproved("Hash/postnummer.csv", sizes[i]);
                int[][] depth = new int[2][sample];
                for (int j = 0; j < sample; j++) {
                    depth[0][j] = keys[chosenKeys[j]];
                    depth[1][j] = hash.lookup(keys[chosenKeys[j]]);
                }
                Arrays.sort(depth[0]);
                for( int j = 0; j < sample; j++){
                    printer.println(depth[0][j] +" "+ depth[1][j]);}
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void improvedTestTime(){
        CollisionTest keyCreator = new CollisionTest("Hash/postnummer.csv");
        Integer[] keys = keyCreator.getKeys();
        Random rnd = new Random();
        int[] chosenKeys = new int[1000];
        for (int i : chosenKeys)
            i = rnd.nextInt(keys.length -1);

        int[] sizes = {13513,33333,61111};
        int rounds = 1000;

        for( int size : sizes){
            ZipImproved hash = new ZipImproved("Hash/postnummer.csv",size);
            double t0,t1,time, minT = Double.MAX_VALUE;
            System.out.printf("%10d",size);
            for (int index : chosenKeys){
                hash.lookup(keys[index]);
            }
            for (int i = 0; i < rounds; i++){
                t0 = System.nanoTime();
                for (int index : chosenKeys){
                    hash.lookup(keys[index]);
                }
                t1 = System.nanoTime();
                time = (t1-t0);
                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.2f\n",minT);
        }

    }

    private static void moduloTest1(){
        int[] modulo = {10000,20000,13513,13600, 14000};
        int rounds = 100000;

        for (int mod : modulo){
            ZipWBucket fourth = new ZipWBucket("Hash/postnummer.csv",mod);
            int code1 = 11115;
            int code2 = 98499;
            double t0,t1,time, minT = Double.MAX_VALUE;
            System.out.printf("%10d",mod);
            System.gc();
            for (int j = 0; j<10000;j++){
                fourth.lookup(code1);
                fourth.lookup(code2);
            }
            for (int i = 0; i < rounds; i++){
                t0 = System.nanoTime();
                for (int j = 0; j<10;j++){
                    fourth.lookup(code1);
                    fourth.lookup(code2);
                }

                t1 = System.nanoTime();
                time = (t1-t0)/10;
                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.2f\n",minT);
        }
    }

    private static void moduloTest(){
        int[] modulo = {10000,20000,13513,13600, 14000};
        int rounds = 1000;
        int[] list = randomZip(10000);
        for (int mod : modulo){
            ZipWBucket fourth = new ZipWBucket("Hash/postnummer.csv",mod);
            double t0,t1,time, minT = Double.MAX_VALUE;
            System.out.printf("%10d",mod);
            for (int zip : list){
                fourth.lookup(zip);
            }
            for (int i = 0; i < rounds; i++){
                t0 = System.nanoTime();
                for (int zip : list){
                    fourth.lookup(zip);
                }
                t1 = System.nanoTime();
                time = (t1-t0);
                if (time < minT)
                    minT = time;
            }
            System.out.printf("%20.2f\n",minT);
        }
    }
    private static int[] randomZip(int size){
        int[] list = new int[size];
        Random rnd = new Random();
        for (int i=0; i< size; i++)
            list[i] = rnd.nextInt(11115,98499);
        return list;
    }


    private static void first(){
        int rounds = 10000;
        String postCode1 = "111 15";
        String postCode2 = "984 99";
        int code1 = 11115;
        int code2 = 98499;
        Zip first = new Zip("Hash/postnummer.csv");
        Zip2 second = new Zip2("Hash/postnummer.csv");

        double t0,t1,time, minT = Double.MAX_VALUE;

        for (int i = 0; i < rounds; i++){
            t0 = System.nanoTime();
            first.lookupLinear(postCode1);
            first.lookupLinear(postCode2);
            t1 = System.nanoTime();
            time = t1-t0*1.00;
            if (time < minT)
                minT = time;
        }
        System.out.printf("First: %.2f\t",minT);

        minT = Double.MAX_VALUE;
        for (int i = 0; i < rounds; i++){
            t0 = System.nanoTime();
            first.lookupBinary(postCode1);
            first.lookupBinary(postCode2);
            t1 = System.nanoTime();
            time = t1-t0*1.00;
            if (time < minT)
                minT = time;
        }

        System.out.printf("%.2f\n",minT);
        for (int i = 0; i < rounds; i++){
            t0 = System.nanoTime();
            second.lookupLinear(code1);
            second.lookupLinear(code2);
            t1 = System.nanoTime();
            time = t1-t0*1.00;
            if (time < minT)
                minT = time;
        }
        System.out.printf("Second: %.2f\t",minT);

        minT = Double.MAX_VALUE;
        for (int i = 0; i < rounds; i++){
            t0 = System.nanoTime();
            second.lookupBinary(code1);
            second.lookupBinary(code2);
            t1 = System.nanoTime();
            time = (t1-t0)*1.00;
            if (time < minT)
                minT = time;
        }
        System.out.printf("%.2f\n",minT);

        System.out.print("Verification O(1) if code == index: ");
        Zip3 third= new Zip3("Hash/postnummer.csv");
        minT = Double.MAX_VALUE;
        for (int i = 0; i < rounds; i++){
            t0 = System.nanoTime();
            third.lookup(code1);
            third.lookup(code2);
            third.lookup(code2);
            third.lookup(code2);
            t1 = System.nanoTime();
            time = (t1-t0)/1.00;
            if (time < minT)
                minT = time;
        }


    }
}
