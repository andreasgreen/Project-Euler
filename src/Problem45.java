/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem45 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        long stopIdx = 1000000;
        int cnt = 0;
        out:
        for(long hex = 143 ; hex < stopIdx ; hex++) {
            long currentHex = getHex(hex);

            for(long penta = 165 ; penta < stopIdx ; penta++) {
                long currentPenta = getPenta(penta);
                if(currentPenta > currentHex) {
                    //System.out.println("Break on penta > hex " + currentPenta + " > " + currentHex);
                    break;
                }

                if(currentHex == currentPenta) {
                    // leta bara efter tri om dom två första är lika
                    System.out.println("P[" + penta + "] = " +currentPenta);
                    System.out.println("H[" + hex + "] = " +currentHex);

                    for(long tri = 285 ; tri < stopIdx ; tri++) {
                        long currentTri = getTriangle(tri);
                        if(currentTri > currentPenta) {
                            System.out.println("Break on tri > penta " + currentTri + " > " + currentPenta);
                            break;
                        }

                        if(currentPenta == currentTri) {
                            System.out.println("T[" + tri + "] = " +currentTri);
                            cnt++;
                            if(cnt == 2)
                                break out;

                        }
                    }
                }
            }
        }

        stopTimer();


    }

    private static long getHex(long n) {return n*(2*n-1);}
    private static long getPenta(long n) {return n*(3*n-1)/2;}
    private static long getTriangle(long n) {return n*(n+1)/2;}

    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void stopTimer() {
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + (endTime - startTime) + " ms");
        System.out.println("Runtime: " + (endTime - startTime)/1000 + " s");
    }
}
