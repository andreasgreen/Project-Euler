import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem54 {
    private static long startTime;

    public static void main(String[] args) throws FileNotFoundException {
        startTimer();
        Scanner scanner = new Scanner(new File("/home/andreas/src/Project-Euler/src/poker.txt"));
        scanner.useDelimiter(" ");
        while(scanner.hasNextLine()) {
            String hand = scanner.nextLine();
            //String[] test = hand.split(" ");
            String hand1 = hand.substring(0,5*3-1);
            String hand2 = hand.substring(5 * 3);
            PokerHand player1 = new PokerHand(hand1);
            PokerHand player2 = new PokerHand(hand2);


            //String card = scanner.next(); //
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

class PokerHand implements Comparable{
    String hand;

    public PokerHand(String hand){
        this.hand = hand;
    }

    public String toString() {
        return hand;
    }

    @Override
    public int compareTo(Object o) {

        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
