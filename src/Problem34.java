/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/18/12
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem34 {

    public static void main(String[] args) {
        long sum = 0;
        for(long l = 3 ; l < 100000000 ; l++) {
            if(l==factSum(l)){
                sum += l;
                System.out.println(l);
            }
        }
        System.out.println("Sum = " + sum);



    }

    private static long factSum(long nr) {
        String s = Long.toString(nr);
        char[] tokens = s.toCharArray();
        long factsum = 0;
        for(char c : tokens) {
            //long subsum = 1;
            long fact = 1;
            for(long subnr = Long.parseLong(Character.toString(c)) ; subnr > 1 ; subnr--) {
                fact =  fact * subnr;
            }
            //System.out.println(c + "! = " + fact);
            factsum += fact;
        }
        return factsum;
    }


}
