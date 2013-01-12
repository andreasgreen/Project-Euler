import com.sun.org.apache.xpath.internal.operations.Or;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem46 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        long stopidx = 10000;

        out:
        for(long compositeCand = 3 ; compositeCand < stopidx ; compositeCand = compositeCand+2) {
            if(!Prime.isPrime(compositeCand) && compositeCand % 2 != 0) {
                //System.out.print(compositeCand + " = ");
                //long sum = 0;
                //long prime;
                //long square;
                boolean found = false;
                righthand:
                for(long j = compositeCand-2 ; j > 0 ; j = j-2) {
                    //System.out.println("prime cand " + j);
                    if(Prime.isPrime(j)) {
                        for(long k = 1 ; k <= (compositeCand-k)/2 ; k++) {
                            if(j + 2*Math.pow(k,2) == compositeCand) {
                                //System.out.print(j + " + 2*" + k + "^2");
                                //System.out.println();
                                found = true;
                                break righthand;
                            }
                        }
                    }

                }
                if(!found) {
                    System.out.println(compositeCand + " = ?");
                    break out;
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
