import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem55 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        //System.out.println("test " + reverse(12244));
        //boolean isLychrel = true; // all numbers that not form palindrome are Lychrel
        long iterations = 50;
        int cnt = 0;
        for(long i = 1 ; i <= 10000 ; i++) {
            boolean isLychrel = true;
            BigInteger sum = BigInteger.ZERO;
            for(long j = 0 ; j < iterations ; j++) {
                if(j == 0) {
                    sum = new BigInteger(""+i).add(new BigInteger(""+reverse(Long.toString(i))));
                } else {
                    sum = sum.add(new BigInteger(reverse(sum.toString())));
                }

                if(Permutations.isPalindromic(sum.toString())) {
                    //System.out.println("Breaking..." + sum + " " + i + " " + j);
                    isLychrel = false;
                    break;
                }
            }
            if(isLychrel) {
                System.out.println("Lychrel nr : " + i);
                cnt++;
            }


        }
        System.out.println("Total Lychrel nrs " + cnt);
        stopTimer();
    }

    private static String reverse(String s) {
        String tmp = "";
        for(int i = s.length()-1 ; i >= 0 ; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }

    /*private static long reverse(long n) {
        String s = Long.toString(n);
        String tmp = "";
        for(int i = s.length()-1 ; i >= 0 ; i--) {
            tmp += s.charAt(i);
        }
        try{
            return Long.parseLong(tmp);
        } catch (NumberFormatException e) {
            System.out.println(e.toString() + " " + n);
            return 0;
        }

    } */



    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void stopTimer() {
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + (endTime - startTime) + " ms");
        System.out.println("Runtime: " + (endTime - startTime)/1000 + " s");
    }
}
