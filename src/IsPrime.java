/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/17/12
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsPrime {
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
