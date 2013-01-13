/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem52 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        long stop = 1000000;
        for(long i = 0 ; i < stop ; i++) {
            long two = i*2;
            if(Permutations.isPermutation(i,two)) {
                long three = i*3;
                if(Permutations.isPermutation(two, three)) {
                    System.out.println(i + " " + two + " " + three);
                    long four = i*4;
                    if(Permutations.isPermutation(three, four)) {
                        long five = i*5;
                        if(Permutations.isPermutation(four, five)) {
                            long six = i*6;
                            if(Permutations.isPermutation(five, six)) {
                                System.out.println(i + " " + two + " " + three + " " + four + " " + five + " " + six);
                            }
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
