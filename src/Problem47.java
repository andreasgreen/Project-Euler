import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem47 {
    private static long startTime;
    static List<Long> primes;
    static int targetNr = 4;
    static int nrConsecutive = 0;
    static long prevSum = 0;


    public static void main(String[] args){
        startTimer();
        primes = new ArrayList<Long>();
        int nrPrimes = 1000;
        long primeCand = 3;

        primes.add(2L);

        while(primes.size() < nrPrimes) {
            if(Prime.isPrime(primeCand)) {
                //System.out.print(" " + primeCand);
                primes.add(primeCand);
            }
            primeCand = primeCand + 2;
        }

        System.out.println("Primes done..");


        long stop = 1000000;
        //int sequencecnt = 0;

        for(long sum = 646 ; sum < stop ; sum++) {
            boolean found = printPrimeFactors(sum);
            if(found) {
                break;
            }
        }
        stopTimer();

    }

    private static boolean printPrimeFactors(long sum) {
        long rest = sum;
        List<Long> factors = new ArrayList<Long>();

        // number of prime factors, random nr might need to be bigger
        out:
        for(int i = 0 ; i < 20 ; i++) {
            for(int j = 0 ; j < primes.size() ; j++) {
                long prime = primes.get(j);

                if(prime > rest) {
                    // start over with new prime
                    break;
                }

                if(rest%prime == 0) {
                    rest = rest / prime;
                    factors.add(prime);
                }

                if(rest == 1) {
                    Set hs = new HashSet();
                    hs.addAll(factors);

                    if(hs.size() == targetNr) {
                        String s = sum + " = ";
                        for(Long l : factors) {
                            s += l + " * ";
                        }

                        if(prevSum+1 == sum) {
                            nrConsecutive++;

                        } else {
                            nrConsecutive = 0;
                        }
                        prevSum = sum;

                        if(nrConsecutive == targetNr-1) {
                            return true;
                        }
                        System.out.println(s.substring(0,s.length()-2));
                    }
                    break out;
                }
            }
        }
        return false;
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
