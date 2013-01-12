import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 1/12/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {

    public static boolean isPermutation(long a, long b) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        return isPermutation(s1, s2);

    }

    public static boolean isPermutation(String a, String b) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public static boolean isPermutationOld(long a, long b) {
        int[] first = new int[10];
        int[] second = new int[10];
        String s1 = String.valueOf(a);
        // System.out.println(s1);
        String s2 = String.valueOf(b);
        // System.out.println(s2);
        if(s1.length() != s2.length()) {
            // logger.info("not same length: " + a + " " + b);
            return false;
        }

        for(int i = 0 ; i < s1.length() ; i++) {
            char j = s1.charAt(i);
            switch (j) {
                case '0' : first[0]++;break;
                case '1' : first[1]++;break;
                case '2' : first[2]++;break;
                case '3' : first[3]++;break;
                case '4' : first[4]++;break;
                case '5' : first[5]++;break;
                case '6' : first[6]++;break;
                case '7' : first[7]++;break;
                case '8' : first[8]++;break;
                case '9' : first[9]++;break;
            }
        }

        for(int i = 0 ; i < s2.length() ; i++) {
            char j = s2.charAt(i);
            switch (j) {
                case '0' : second[0]++;break;
                case '1' : second[1]++;break;
                case '2' : second[2]++;break;
                case '3' : second[3]++;break;
                case '4' : second[4]++;break;
                case '5' : second[5]++;break;
                case '6' : second[6]++;break;
                case '7' : second[7]++;break;
                case '8' : second[8]++;break;
                case '9' : second[9]++;break;
            }
        }

        /*for(int i = 0 ; i < first.length; i++) {
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < second.length; i++) {
            System.out.print(second[i] + " ");
        } */

        return Arrays.equals(first, second);

    }

}
