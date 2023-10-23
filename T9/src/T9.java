import java.io.*;
import java.util.ArrayList;


/**
 * Class T9 for the B grade assignment in the course id1021.
 * Some code copied from the assignment
 */
public class T9 {
    private Node root;


    /**
     * The internal node structure
     */
    private class Node {
        private Node[] next;
        private boolean valid;

        /**
         * Constructor for the node
         */
        private Node() {
            next = new Node[27];
            valid = false;
        }

        /**
         * The internal recursive add method to add words to the trie.
         * @param word the word to add
         */
        private void add(int[] word) {
            if(word == null)
                throw new IllegalArgumentException("not a word");

            if(word.length > 0){
                int currentCode = word[0];
                if (next[currentCode] == null) {
                    next[currentCode] = new Node();
                }
                next[currentCode].add(removeFirst(word));
            }
            else{
                this.valid = true;
            }
        }

        private void collect(int[] numbers, String str, ArrayList<String> list) {
            if(numbers.length > 0){
                for (int i = 0; i < 3; i++){
                    int index = 3*numbers[0]+i;
                    String nextString = str;
                    if(next[index] != null){
                        nextString += characterFrom(index);
                        int[] number = removeFirst(numbers);
                        next[index].collect(number, nextString, list);
                    }
                }

            }

            if(valid && numbers.length == 0)
                list.add(str);
        }
    }


    /**
     * Helper method that removes the first index of a list.
     * @param array the given list
     * @return the smaller list
     */
    private int[] removeFirst(int[] array){
        if(array == null||array.length ==0)
            throw new IllegalArgumentException("cant remove from empty list");

        int[] smaller = new int[array.length - 1];
        System.arraycopy(array, 1, smaller, 0, smaller.length);

        return smaller;
    }

    /**
     * Constructor
     */
    public T9(){
        root = new Node();
    }


    /**
     * Constructor to add the words of the given file to the trie
     * @param file the words to add
     */
    public T9(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            root = new Node();
            while ((line = br.readLine()) != null) {
                addWord(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException("File: "+file+" not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Public add method to add words to the trie
     * @param word the word to add
     */
    public void addWord(String word){
        if (root == null)
            throw new IllegalArgumentException();

        root.add(encode(word));
    }

    /**
     * Converts a string to an array of index codes for the trie
     * @param word the word to translate
     * @return an array with index codes for the word
     */
    private int[] encode(String word){
        int[]  chars = new int[word.length()];
        for (int i = 0; i< word.length(); i++){
            chars[i] = codeFrom(word.charAt(i));
        }

        return chars;
    }


    public ArrayList<String> decode(String keySequence){
        ArrayList<String> allMatchingWords = new ArrayList<>();
        int[] numbers = convertCharToInt(keySequence);
        root.collect(numbers, "", allMatchingWords);
        return allMatchingWords;
    }

    private int[] convertCharToInt(String numbers){
        int[] list = new int[numbers.length()];
        for(int i = 0; i < list.length; i++)
            list[i] = indexFrom(numbers.charAt(i));
        return list;
    }

    public static int codeFrom(char character) {
        switch (character) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'r':
                return 16;
            case 's':
                return 17;
            case 't':
                return 18;
            case 'u':
                return 19;
            case 'v':
                return 20;
            case 'x':
                return 21;
            case 'y':
                return 22;
            case 'z':
                return 23;
            case 'å':
                return 24;
            case 'ä':
                return 25;
            case 'ö':
                return 26;
            default:
                return -1;
        }
    }

    private static char characterFrom(int code) {
        switch (code) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'r';
            case 17:
                return 's';
            case 18:
                return 't';
            case 19:
                return 'u';
            case 20:
                return 'v';
            case 21:
                return 'x';
            case 22:
                return 'y';
            case 23:
                return 'z';
            case 24:
                return 'å';
            case 25:
                return 'ä';
            case 26:
                return 'ö';
            default:
                return '?';
        }
    }

    private static int indexFrom(char key) {
        switch (key) {

            case '1':
                return 0;
            case '2':
                return 1;
            case '3':
                return 2;
            case '4':
                return 3;
            case '5':
                return 4;
            case '6':
                return 5;
            case '7':
                return 6;
            case '8':
                return 7;
            case '9':
                return 8;
            default:
                return -1;
        }
    }

    private static char keyFrom(int index){
        switch (index) {
            case 0:
                return '1';
            case 1:
                return '2';
            case 2:
                return '3';
            case 3:
                return '4';
            case 4:
                return '5';
            case 5:
                return '6';
            case 6:
                return '7';
            case 7:
                return '8';
            case 8:
                return '9';
            default:
                return '?';
        }
    }


    public static void main(String[] args) {
        T9 t9 = new T9();
        t9.addWord("and");
        t9.addWord("amd");
        t9.addWord("bod");
        t9.addWord("cod");
        t9.decode("152");
    }
    }
