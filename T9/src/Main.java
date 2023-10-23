import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        T9 t9 = new T9("T9/Kelly.txt");
        ArrayList<String> kelly= readKelly("T9/Kelly.txt");
        String[] kellyInNum = convertToCode(kelly);
        System.out.println(kelly.get(7500));
        System.out.println(kellyInNum[7500]);
        System.out.println(t9.decode("6877243725"));
    }

    private static void testAll(){
        T9 t9 = new T9("T9/Kelly.txt");
        ArrayList<String> kelly= readKelly("T9/Kelly.txt");
        String[] kellyInNum = convertToCode(kelly);

        int matches = 0, nonMatching = 0, i= 0;
        for(String seq: kellyInNum){
            ArrayList<String> found = t9.decode(seq);
            if(found.contains(kelly.get(i++)))
                matches++;
            else nonMatching++;

        }

        System.out.println("Total words: "+kelly.size());
        System.out.println("matches: "+matches);
        System.out.println("misses: "+nonMatching);
        System.out.println("size of kelly == matches : "+(kelly.size()==matches));

    }

    private static ArrayList<String> readKelly(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            ArrayList<String> list = new ArrayList<>();
            String line;
            while((line = br.readLine())!=null){
                list.add((line));
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] convertToCode(ArrayList<String> list){
        String[] codes = new String[list.size()];
        for(int i=0; i< codes.length; i++)
            codes[i] = convertToNumPad(list.get(i));
        return codes;
    }

    private static String convertToNumPad(String word) {
        String wordInNum ="";
        for(int i = 0; i<word.length();i++){
            int code = T9.codeFrom(word.charAt(i));

            if(code <=2)
                wordInNum+="1";
            else if (code<=5)
                wordInNum+="2";
            else if (code<=8)
                wordInNum+="3";
            else if (code<=11)
                wordInNum+="4";
            else if (code<=14)
                wordInNum+="5";
            else if (code<=17)
                wordInNum+="6";
            else if (code<=20)
                wordInNum+="7";
            else if (code<=23)
                wordInNum+="8";
            else if (code<=26)
                wordInNum+="9";
        }
        return wordInNum;
    }



}



