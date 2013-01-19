import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem54 {
    private static long startTime;


    public static void main(String[] args) throws FileNotFoundException {
        startTimer();
        Scanner scanner = new Scanner(new File("/home/andreas/src/Project-Euler/src/poker.txt"));
        scanner.useDelimiter(" ");
        int playerOneCnt = 0;
        int playerTwoCnt = 0;
        int drawCnt = 0;
        while(scanner.hasNextLine()) {
            String hand = scanner.nextLine();
            //String[] test = hand.split(" ");


            String hand1 = hand.substring(0,5*3-1);
           // String hand1 = "2D 3C 9D KS KC";
            String hand2 = hand.substring(5 * 3);
           // String hand1 = "AC AS TS 6D 3S";
           // String hand2 = "8H 9D TH QH AD";
            PokerHand player1 = new PokerHand(hand1);
            PokerHand player2 = new PokerHand(hand2);
           // System.out.println(player1);
           // System.out.println(player1 + " " + player1.getRank() + " " + player1.getMagicValue());
           // System.out.println(player2 + " " + player2.getRank() + " " + player2.getMagicValue());

            if(player1.compareTo(player2) > 0) {
                playerTwoCnt++;
            } else if(player1.compareTo(player2) < 0) {
                //System.out.println("Player 1 wins");
                playerOneCnt++;
            } else {
                //System.out.println("Draw");
                drawCnt++;
            }

            //break;
            //String card = scanner.next(); //
        }
        System.out.println(playerOneCnt + " " + playerTwoCnt + " " + drawCnt);
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
    private String hand;
    List<Card> cards = new ArrayList<Card>();
    int rank;
    Card highCard = new Card("2C");
    //private boolean straight;
   // Card magicCard = null;
    int magicValue = 0;

    public PokerHand(String hand) {
        this.hand = hand;
        String[] c = hand.split(" ");

        for(int i = 0 ; i < c.length ; i++ ) {
            Card newCard = new Card(c[i]);
            if(newCard.compareTo(highCard) > 0) {
                highCard = newCard;
            }
            cards.add(newCard);
        }

        rank = calculateRank();
    }

    private int calculateRank() {
        // rank 9 royal flush
        if (isRoyalFlush()) {
            System.out.println(this);
            return 9;
        } else if (isStraightFlush()) { //done
            return 8;
        } else if (pairFounder(4)) {    //done
            //System.out.println(this);
            return 7;
        } else if (isFullHouse()) { // done
            //System.out.println(this);
            return 6;
        } else if (isFlush()) {   //done
            return 5;
        } else if (isStraight()) {  //done
            //System.out.println(this);
            return 4;
        } else if (pairFounder(3)) {   //done
            //System.out.println(this);
            return 3;
        } else if (isTwoPair()) {   //done
            //System.out.println(this);
            return 2;
        } else if (pairFounder(2)) {   //done
            //System.out.println(this);
            return 1;
        } else {
            return 0;
        }


    }

    private boolean isPair() {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isTwoPair() {
        Collections.sort(cards);
       // int foundPairs = 0;
        if(cards.get(0).getValue() == cards.get(1).getValue() && cards.get(2).getValue() == cards.get(3).getValue() ) {
            return true;
        } else if(cards.get(0).getValue() == cards.get(1).getValue() && cards.get(3).getValue() == cards.get(4).getValue() ) {
            return true;
        } else if(cards.get(1).getValue() == cards.get(2).getValue() && cards.get(3).getValue() == cards.get(4).getValue() ) {
            return true;
        } else {
            return false;
        }

        //return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isThreeOfAKind() {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isStraight() {
        Collections.sort(cards);

        int prev = -1;
        for(Card c : cards) {
            if(prev == -1) {
                prev = c.getValue();
            } else {
                if(c.getValue() != prev+1) {
                    return false;
                }
                prev = c.getValue();
            }
        }
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isFullHouse() {
        Collections.sort(cards);
        if(cards.get(0).getValue() == cards.get(1).getValue() && cards.get(2).getValue() == cards.get(3).getValue() && cards.get(2).getValue() == cards.get(4).getValue()) {
            return true;
        } else if(cards.get(0).getValue() == cards.get(1).getValue() && cards.get(1).getValue() == cards.get(2).getValue() && cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else {
            return false;
        }

    }

    private boolean pairFounder(int target) {
        Collections.sort(cards);
        //System.out.println("in pair founder" + cards);
        //int target = 4;
        int cnt = 1;
        int prev = -1;
        //boolean startOver = false;
        int max = 0;

        //for(Card c : cards) {
        for(int i = 0 ; i < cards.size() ; i++ ) {
            Card c = cards.get(i);
            if(prev == -1) {

            } else {
                if(prev == c.getValue()) {
                    cnt++;
                } else {
                    if(cnt > max) {
                        max = cnt;
                        magicValue =  cards.get(i-1).getValue();
                        //System.out.println("resetting " + max + " " + cards + " " + c);
                    }

                    cnt = 1;
                }
            }
            prev = c.getValue();
        }
        if(cnt > max) {
            max = cnt;
            magicValue =  cards.get(cards.size()-1).getValue();
            //System.out.println("resetting " + max + " " + cards + " " + c);
        }
        //System.out.println("Starting with " + cards + " cnt " + cnt);
        return (max >= target);

    }

    private boolean isStraightFlush() {

        return isFlush() & isStraight();

    }

    private boolean isRoyalFlush() {
        return (isFlush() && isStraight() && highCard.getValue()==14);

    }

    private boolean isFlush() {
        List<Card.Suits> s = new ArrayList<Card.Suits>();
        Card.Suits prevSuit = cards.get(0).getSuit();
        for(Card c : cards) {
            if(c.getSuit() != prevSuit) {
                return false;
            }
            prevSuit = c.getSuit();
        }
        return true;

    }

    public String toString() {
        //return hand;
        String s = "";
        for(Card c : cards) {
            s += c.toString() + " | ";
        }
        s += "High Card " + highCard.toString();
        return s;
    }

    public int getRank() {
        return rank;
    }

    public Card getHighCard(){
        return highCard;
    }

    public int getMagicValue() {
        return magicValue;
    }


    @Override
    public int compareTo(Object o) {
        PokerHand tmp = (PokerHand)o;
        if(this.rank < tmp.getRank()) {
            return -1;
        } else if(this.rank > tmp.getRank()) {
            return 1;
        } else if(this.rank == tmp.getRank() && this.rank == 0) {
            // no hand, compare high card
            if(this.highCard.getValue() < tmp.getHighCard().getValue()) {
                return -1;
            } else if(this.highCard.getValue() > tmp.getHighCard().getValue()) {
                return 1;
            } else {
                System.out.println("=======");
                System.out.println("Same hand and nothing ?");
                System.out.println(this + " " + rank);
                System.out.println(tmp + " " + tmp.getRank());
                System.out.println("=======");
                return 0;

            }
        } else if(this.rank == tmp.getRank() && (tmp.getRank() == 1 || tmp.getRank() == 3 || tmp.getRank() == 4)) {
            if(this.magicValue < tmp.getMagicValue()) {
                return -1;
            } else if(this.magicValue > tmp.getMagicValue()) {
                 return 1;
            } else {


                if(this.getHighCard().getValue() > tmp.getHighCard().getValue()) {
                    return 1;
                } else if(this.getHighCard().getValue() < tmp.getHighCard().getValue()) {
                    return -1;
                } else {
                    System.out.println("=======");
                    System.out.println("jobbigt, needs next higest card.");
                    System.out.println(this + " " + magicValue);
                    System.out.println(tmp + " " + tmp.getMagicValue());
                    System.out.println("=======");
                    return 0;
                }


            }
        } else if(this.rank == tmp.getRank()) {
            System.out.println("=======");
            System.out.println("same rank, dont know what to do");
            System.out.println(this + " " + rank);
            System.out.println(tmp + " " + tmp.getRank());
            System.out.println("=======");
            return 0;
        }
        return 0;
          //To change body of implemented methods use File | Settings | File Templates.
    }



}

class Card implements Comparable {
    public enum Suits {HEARTS, SPADES, CLUBS, DIAMONDS};

    private Suits suit;
    private int value;

    public Card(String s) {
        String val = ""+s.charAt(0);
        String suitTmp = ""+s.charAt(1);
        //System.out.println(s);
        if(val.equals("T")) {
            value = 10;
        } else if(val.equals("J")) {
            value = 11;
        } else if(val.equals("Q")) {
            value = 12;
        } else if(val.equals("K")) {
            value = 13;
        } else if(val.equals("A")) {
            value = 14;
        } else {
            value = Integer.parseInt(val);
        }

        if(suitTmp.equals("C")) {
            suit = Suits.CLUBS;
        } else if(suitTmp.equals("S")) {
            suit = Suits.SPADES;
        } else if(suitTmp.equals("H")) {
            suit = Suits.HEARTS;
        } else if(suitTmp.equals("D")) {
            suit = Suits.DIAMONDS;
        }
    }

    public Suits getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return value + " of " + suit;
    }


    @Override
    public int compareTo(Object o) {
        Card tmp = (Card)o;
        if(this.value < tmp.getValue()) {
            return -1;
        } else if(this.value > tmp.getValue()) {
            return 1;
        } else {
            // same value.
            return 0;

        }
    }
}


