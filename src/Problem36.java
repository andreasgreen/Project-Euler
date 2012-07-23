/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/17/12
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem36 {

    public static void main(String[] args) {
        long sum = 0;
        for(long i = 1 ; i < 1000000 ; i++) {
            if(isPalindromic(i) && isPalindromic(getBase2(i))){
                System.out.println(i + " - " + getBase2(i));
                sum += i;
            }
        }
        System.out.println("Summan=" + sum);



    }

    public static String getBase2(long base10){
        return Long.toString(base10, 2);
    }

    public static boolean isPalindromic(long l) {
       String s = Long.toString(l);
       return isPalindromic(s);
    }

    public static boolean isPalindromic(String s) {
        boolean even = s.length()%2==0;
        if(even) {
            while(s.length() > 0) {
                if(s.charAt(0) == s.charAt(s.length()-1))  {
                    s = s.substring(1,s.length()-1);
                } else {
                    return false;
                }

            }
            return true;
        } else {
            while(s.length() > 1) {
                if(s.charAt(0) == s.charAt(s.length()-1))  {
                    s = s.substring(1,s.length()-1);
                } else {
                    return false;
                }

            }
        }
        return true;
    }

}
