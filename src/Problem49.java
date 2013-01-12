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
                if(!Permutations.isPermutation(i,j) || !Prime.isPrime(j)) {
                    continue;
                }
                //System.out.println("j: " + j);
                long diffOne = j-i;
                for(long k = j+1 ; k <= stop ; k++) {
                    if(!Permutations.isPermutation(j,k) || !Prime.isPrime(k) || (k-j != diffOne)) {
                        continue;
                    }
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

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
