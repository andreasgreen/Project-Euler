import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem53 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();

        long cnt = 0;


        for(BigInteger n = BigInteger.ONE ; n.compareTo(new BigInteger("100")) < 1; n = n.add(BigInteger.ONE)) {
            for(BigInteger r = BigInteger.ONE ; r.compareTo(n) < 1 ; r = r.add(BigInteger.ONE)) {
                BigInteger nFac = fac(n);
                BigInteger rFac = fac(r);
                BigInteger nrFac = fac(n.subtract(r));

                BigInteger combi = nFac.divide((rFac.multiply(nrFac)));

               /* if(n.equals(new BigInteger("23"))) {
                    System.out.println(n + " C " + r + " = " + combi);
                    System.out.println(combi.compareTo(new BigInteger("1000000")));
                }*/
                // System.out.println(nFac + " " + rFac + " " + nrFac);
                if(combi.compareTo(new BigInteger("1000000")) == 1) {
                    System.out.println(n + " C " + r + " = " + combi);
                    cnt++;
                }



            }
        }
        System.out.println("Total cnt " + cnt);
      /*  BigInteger a = new BigInteger("3");
        System.out.println("a " + a);
        BigInteger b = BigInteger.ZERO;
        System.out.println("b " + b);

        System.out.println(a.compareTo(b));

        System.out.println("3!=" + fac(new BigInteger("3")));*/
        stopTimer();
    }

    private static BigInteger fac(BigInteger n) {
        BigInteger f = BigInteger.ONE;
        for(; n.compareTo(BigInteger.ZERO) > 0 ; n = n.subtract(BigInteger.ONE)) {
            f = f.multiply(n);
        }
        return f;
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
