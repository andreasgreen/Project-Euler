import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 5/20/12
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem31 {
    public static void main(String[] args) {
        // 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
        /*
        initialize a list S to contain one element 0.
        for each i from 1 to N do
            let T be a list consisting of xi + y, for all y in S
            let U be the union of T and S
            sort U
            make S empty
            let y be the smallest element of U
            add y to S
            for each element z of U in increasing order do
                //trim the list by eliminating numbers close to one another
                //and throw out elements greater than s
                if y + cs/N < z ≤ s, set y = z and add z to S
            if S contains a number between (1 − c)s and s, output yes, otherwise no*/

        List<Integer> S = new ArrayList<Integer>();
        List<Integer> T = new ArrayList<Integer>();
        List<Integer> U = new ArrayList<Integer>();
        S.add(0);
        int N = 3;
        float s = 2;
        double c = 0.01;
        int count = 0;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 0 ; j < S.size() ; j++) {
                int y = S.get(j);
                T.add(y+1);T.add(y+2);T.add(y+3);//T.add(y+10);T.add(y+20);T.add(y+50);T.add(y+100);T.add(y+200);
            }
            Set set = new HashSet();
            set.addAll(T);
            set.addAll(S);
            U = new ArrayList(set);
            Collections.sort(U);
            S.clear();
            int y = U.get(0);
            S.add(y);
            System.out.println(U);
            // test c=1

            for(int z : U) {
                if(y+c*s/N < z && y+c*s/N <= s){
                    y = z;
                    S.add(z);
                }

            }
            for(int sum : S){
                System.out.println(sum);
                if(sum < s && sum > (1-c)*s){
                    //System.out.println("yes");
                    count++;
                } else {
                   // System.out.println("No");
                }
            }
        }
        System.out.print(count);

    }

}
                        /*
for each element z of U in increasing order do
        //trim the list by eliminating numbers close to one another
        //and throw out elements greater than s
        if y + cs/N < z ≤ s, set y = z and add z to S
        if S contains a number between (1 − c)s and s, output yes, otherwise no*/