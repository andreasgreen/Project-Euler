/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/17/12
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem37 {

    public static void main(String[] args){
        long sum = 0;
        int cnt = 1;
        //for (long l = 8 ; l < 1000000; l++ ) {
        long l = 7;
          while(cnt < 12) {
            l++;
            if(isPrime(l)) {
                String s = Long.toString(l);
                boolean candidate = true;
                while(s.length()>1 && candidate) {
                    s = truncateLeft(s);
                    if(!isPrime(s)){
                        candidate = false;
                    }
                }
                s = Long.toString(l);
                while(s.length()>1 && candidate) {
                    s = truncateRight(s);
                    if(!isPrime(s)){
                        candidate = false;


                    }
                }
                if(candidate) {
                    cnt++;
                    sum += l;
                    System.out.println("Found: " + l);
                }


            }



        }
        System.out.println("sum: " + sum);

    }



    private static String truncateRight(long l) {
        String s = Long.toString(l);
        return truncateRight(s);
    }

    private static String truncateLeft(long l) {
        String s = Long.toString(l);
        return truncateLeft(s);
    }

    private static String truncateRight(String s) {

        if(s.length()>0)
            return s.substring(0,s.length()-1);
        else
            return "0";
    }

    private static String truncateLeft(String s) {

        if(s.length()>0)
            return s.substring(1);
        else
            return "0";
    }


    private static boolean isPrime(String s) {

        return isPrime(Long.parseLong(s));
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
}
