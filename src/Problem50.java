import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem50 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        List<Long> primes = new ArrayList<Long>();
        int nrPrimes = 100000;
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
        System.out.println(primes.get(primes.size()-1));

        long upperlimit = 1000000; //1 000 000
        int longestStreekTotal = 0;

        for(long target = 3 ; target <= upperlimit ; target++) {
            if(Prime.isPrime(target)) {
                // print longest sum

                int startIdx = 0;
                findLoop:
                while (true) {
                    long sum = 0;
                    List<Long> terms = new ArrayList<Long>();
                    int longestStreek = 0;

                    for(int j = startIdx ; j < primes.size() ; j++) {
                        long prime = primes.get(j);

                        sum += prime;
                        terms.add(prime);
                        longestStreek++;
                        //System.out.println("SUM " + sum);
                        if(target == sum) {
                            if(longestStreek > longestStreekTotal) {
                                longestStreekTotal = longestStreek;
                                System.out.println(target + " = " + terms + " [" +longestStreek+ "]");
                            }

                            break findLoop;
                        } else if(sum > target) {
                            startIdx++;
                            //System.out.println("restarting from " + startIdx);

                            break;
                        }
                    }
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
