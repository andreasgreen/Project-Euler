import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem49 {
    private static long startTime;
    private static Logger logger = Logger.getLogger("Problem 49");

    public static void main(String[] args){
        startTimer();
        //long stop = 9999;

       // System.out.println(""+isPermutation(1009L, 1013L));

        long stop = 9999;
        for(long i = 1000 ; i <= stop-2 ; i++) {
            if(!Prime.isPrime(i)) {
                continue;
            }
            //System.out.println("i: " + i);

            for(long j = i+1 ; j<= stop-1 ; j++) {
                if(!isPermutation(i,j) || !Prime.isPrime(j)) {
                    continue;
                }
                //System.out.println("j: " + j);
                long diffOne = j-i;
                for(long k = j+1 ; k <= stop ; k++) {
                    if(!isPermutation(j,k) || !Prime.isPrime(k) || (k-j != diffOne)) {
                        continue;
                    }
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

        stopTimer();
    }

    private static boolean isPermutation(long a, long b) {
        int[] first = new int[10];
        int[] second = new int[10];
        String s1 = String.valueOf(a);
       // System.out.println(s1);
        String s2 = String.valueOf(b);
       // System.out.println(s2);
        if(s1.length() != s2.length()) {
           // logger.info("not same length: " + a + " " + b);
            return false;
        }

        for(int i = 0 ; i < s1.length() ; i++) {
            char j = s1.charAt(i);
            switch (j) {
                case '0' : first[0]++;break;
                case '1' : first[1]++;break;
                case '2' : first[2]++;break;
                case '3' : first[3]++;break;
                case '4' : first[4]++;break;
                case '5' : first[5]++;break;
                case '6' : first[6]++;break;
                case '7' : first[7]++;break;
                case '8' : first[8]++;break;
                case '9' : first[9]++;break;
            }
        }

        for(int i = 0 ; i < s2.length() ; i++) {
            char j = s2.charAt(i);
            switch (j) {
                case '0' : second[0]++;break;
                case '1' : second[1]++;break;
                case '2' : second[2]++;break;
                case '3' : second[3]++;break;
                case '4' : second[4]++;break;
                case '5' : second[5]++;break;
                case '6' : second[6]++;break;
                case '7' : second[7]++;break;
                case '8' : second[8]++;break;
                case '9' : second[9]++;break;
            }
        }

        /*for(int i = 0 ; i < first.length; i++) {
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < second.length; i++) {
            System.out.print(second[i] + " ");
        } */

        return Arrays.equals(first, second);

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
