import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem48 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        BigInteger sum = new BigInteger("0");

        int pow = 1;
        BigInteger stop = new BigInteger("1001");

        for(BigInteger base = new BigInteger("1") ; !base.equals(stop); base = base.add(BigInteger.ONE)) {

            sum = sum.add(base.pow(pow));
            pow += 1;
        }
        System.out.println("SUM: " + sum);

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
