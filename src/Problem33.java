/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/19/12
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem33 {
    public static void main(String[] args) {
        float numerator = 0;
        float denominator = 1;
        float finalNumerator = 1;
        float finalDenominator = 1;
        for(denominator = 1 ; denominator < 100  ; denominator++ ) {
            for(numerator = 1; numerator < 100 ; numerator ++) {
                if(numerator >= denominator)
                    continue;
                float realQ = numerator/denominator;
                char common = getCommonNumber(numerator,denominator);
                if(common == 'a')
                    continue;

                //System.out.println( numerator + "/" + denominator + "=" +realQ);

                //System.out.println(numerator + " - " + common);
                float shortNumerator = removeNumber(numerator, common);
                float shortDenominator = removeNumber(denominator, common);

                float fakeQ = shortNumerator/shortDenominator;

               // System.out.println( shortNumerator + "/" + shortDenominator + "=" +fakeQ);

                if(realQ == fakeQ) {
                    System.out.println("Found: " + numerator + "/" + denominator);
                    finalNumerator *= numerator;
                    finalDenominator *= denominator;
                }
            }
        }
        System.out.println("final: " + finalNumerator + "/" + finalDenominator);   //
    }

    private static char getCommonNumber(float n, float d) {
        String s1 = Integer.toString((int)n);
        String s2 = Integer.toString((int)d);
        //System.out.println(s1 + " - " + s2);
        char[] c = s1.toCharArray();
        for(char ch : c) {
            if(s2.contains(""+ch) && Integer.parseInt(""+ch) != 0){
                return ch;
            }
        }
        return 'a';
    }

    private static float removeNumber(float f, char c) {
        //System.out.println("Removing " + c + " from " + f);
        String s = Integer.toString((int)f);
        try {
            return Float.parseFloat(s.replaceFirst(""+c, ""));
        } catch (NumberFormatException e) {
            return 0;
        }

    }

}
