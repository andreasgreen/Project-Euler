import javax.management.StringValueExp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem59 {
    private static long startTime;
    private static List<Integer> encAscii = new ArrayList<Integer>();
    private static List<String> words = new ArrayList<String>();

    public static void getNextPassword() {
        String alhpa = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0 ; i < alhpa.length(); i++){
            for(int j = 0 ; j < alhpa.length(); j++){
                for(int k = 0 ; k < alhpa.length(); k++) {
                    String passwordCandidate = "" + alhpa.charAt(i) + alhpa.charAt(j) + alhpa.charAt(k);
                    tryPassword(passwordCandidate);
                }
            }
        }

    }

    public static void tryPassword(String pwd) {
        int a = (int)pwd.charAt(0);
        int b = (int)pwd.charAt(1);
        int c = (int)pwd.charAt(2);
        String clearText = "";
        long asciiSum = 0;
        for(int i = 0 ; i < encAscii.size() ; i++) {
            int encChar = encAscii.get(i);
            int decChar = 0;
            if(i % 3 == 0) {
                decChar =  encChar ^ a;
            } else if(i % 3 == 1) {
                decChar =  encChar ^ b;
            } else if(i % 3 == 2) {
                decChar =  encChar ^ c;
            }
            asciiSum += decChar;
            clearText += (char)decChar;

        }
        for(String word : words) {
            if(clearText.contains(word) && pwd.equals("god")) {
                System.out.println("[" +asciiSum +"]" + "[" +pwd +"]" + " " + clearText);
                break;
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        startTimer();
        Scanner scanner = new Scanner(new File("/home/andreas/src/Project-Euler/src/cipher1.txt"));
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            //String s = scanner.next();
            //System.out.println(Integer.parseInt(s));
            encAscii.add(scanner.nextInt());
        }

        scanner = new Scanner(new File("/home/andreas/src/Project-Euler/src/words.txt"));
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            //String s = scanner.next();
            //System.out.println(Integer.parseInt(s));
            String s = scanner.next();
            if(s.length() > 3)
                words.add(s);
        }
        getNextPassword();

        // god (The Gospel of John, chapter 1) 1 In the beginning the Word already existed. He was with God, and he was God. 2 He was in the beginning with God. 3 He created everything there is. Nothing exists that he didn't make. 4 Life itself was in him, and this life gives light to everyone. 5 The light shines through the darkness, and the darkness can never extinguish it. 6 God sent John the Baptist 7 to tell everyone about the light so that everyone might believe because of his testimony. 8 John himself was not the light; he was only a witness to the light. 9 The one who is the true light, who gives light to everyone, was going to come into the world. 10 But although the world was made through him, the world didn't recognize him when he came. 11 Even in his own land and among his own people, he was not accepted. 12 But to all who believed him and accepted him, he gave the right to become children of God. 13 They are reborn! This is not a physical birth resulting from human passion or plan, this rebirth comes from God.14 So the Word became human and lived here on earth among us. He was full of unfailing love and faithfulness. And we have seen his glory, the glory of the only Son of the Father.


        /*int a = 65;
        int b = 42;
        int c = a^b;
        System.out.println(c);
        System.out.println(c^b);*/




        stopTimer();


    }

    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void stopTimer() {
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + (endTime - startTime) + " ms");
        System.out.println("Runtime: " + (endTime - startTime)/1000 + " s");
    }
}
