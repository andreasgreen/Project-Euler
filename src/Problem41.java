/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem41 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        //for(long l = 987654321L ; l>1L ; l--) {
        for(long l = 7654321L ; l>1L ; l--) {
            //if(l%100000 == 0) System.out.println(l);
            if(isPandigital(l) && isPrime(l)) {
                System.out.println("Match:" + l);
                break;
            }
        }
        stopTimer();


    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    private static boolean isPandigital(long i) {
        String s = Long.toString(i);
        int n = s.length();
        int[] matches = new int[9];
        for(int j = 0 ; j < n ; j++) {

            char letter = s.charAt(j);
            //System.out.println("char " + letter);
            switch (letter) {
                case '1' : matches[0] = matches[0]+1; break;
                case '2' : matches[1] = matches[1]+1; break;
                case '3' : matches[2] = matches[2]+1; break;
                case '4' : matches[3] = matches[3]+1; break;
                case '5' : matches[4] = matches[4]+1; break;
                case '6' : matches[5] = matches[5]+1; break;
                case '7' : matches[6] = matches[6]+1; break;
                case '8' : matches[7] = matches[7]+1; break;
                case '9' : matches[8] = matches[8]+1; break;
            }
        }
        for(int j = 0 ; j < n ; j++) {
            //System.out.println(j + ";" + matches[j]);
            if(matches[j] != 1) return false;
        }
        return true;

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
