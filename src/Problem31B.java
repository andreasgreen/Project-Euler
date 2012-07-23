import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/22/12
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem31B {

    public static int idCounter = 0;

    public static void main(String[] args) {
        //int idCounter = 1;
        int n = 10;
        List<Integer> matchingSums = new ArrayList<Integer>();
        List<Sum> sumCollection = new ArrayList<Sum>();
        //Map<Integer, Sum> sumCollection = new HashMap<Integer, Sum>();
        List<Integer> members = new ArrayList<Integer>();
        members.add(1);members.add(2);
        members.add(5);members.add(10);
        members.add(20);// 10, 2x5, 5x2, 10x1, 5 + 2x2 + 1, 5 + 5x1, 2x4 + 2x1   = 7 stycken sätt


        for(Integer i : members){
            int count = 1;
            for(int j = i ; j <= n; j=j+i){
                Sum s = new Sum(count,i,j,idCounter++);
                // s.print();
                //System.out.println("adding on " + s.getId() + "-" + s);
                //sumCollection.put(s.getId(),s);
                sumCollection.add(s);

                count++;
            }
        }

        Collections.sort(sumCollection);
       // System.out.println(sumCollection.size());

        int nrOfWays = 0;

        for(int i = sumCollection.size()-1 ; i > 0 ; i--){
            //System.out.println(i);
            Sum s = sumCollection.get(i);
            //s.print();
            if(s.getSum() > n) {
                System.out.println(s.toString() + " is to large, skipping" );   //Should not happen
                continue;
            } else if(s.getSum() == n) {
                System.out.println("match : " + s.toString());
                nrOfWays++;
            } else {
                // try to combine with lower

            }
        }

        System.out.println("nrOfWays " + nrOfWays);


        printSumCollection(sumCollection);


    }
    static void printSumCollection(List<Sum> sums){
        for(Sum s: sums){
            System.out.println(s.getId() + " - " + s.toString());
        }
    }

    static void printSumCollection(Map<Integer, Sum> sums) {
        Iterator iterator = sums.keySet().iterator();

        while (iterator.hasNext()) {
            int key = (Integer)(iterator.next());
            //System.out.println("key:" + key);
            Sum s = (Sum)sums.get(key);

            System.out.println(key + " " + s.toString());
        }
    }


}

class Sum implements Comparable<Sum>{
    private int id;
    private int sum;
    private int count;
    private int base;

    Sum(int count, int base, int sum, int idCounter){
        this.count = count;
        this.base = base;
        this.sum = sum;
        id = idCounter;

    }

    public void print() {
        //return count + "x" + base + " = " + sum;
        System.out.println(count + "x" + base + " = " + sum);
    }

    public String toString() {
        return count + "x" + base + " = " + sum;
    }

    public int getId(){
        return id;
    }

    public int getSum(){
        return sum;
    }

    public int compareTo(Sum theOther) {
        if(this.sum < theOther.getSum()){
            return -1;
        }else if(this.sum == theOther.getSum()){
            return 0;
        } else{
            return 1;
        }
    }
}

