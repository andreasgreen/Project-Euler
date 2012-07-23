import com.sun.servicetag.SystemEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Problem43 {
    private static long startTime;

    public static void main(String[] args){
        startTimer();
        int[] divs = {2,3,5,7,11,13,17};
        List<List<String>> all = new ArrayList<List<String>>();


        for(int i = 999 ; i > 0 ; i--) {
            if(i % 17 == 0) {
                List<String> one = new ArrayList<String>();
                if(Integer.toString(i).length()==2)
                    one.add("0"+i);
                else
                    one.add(""+i);

                all.add(one);
            }
        }



        for(int i = 5 ; i >= 0 ; i--) {
            List<List<String>> newOnes = new ArrayList<List<String>>();
            for(List<String> list : all) {
                String last = list.get(list.size()-1);
                String rootData = last.substring(0,2);
                //System.out.println(last + " " + rootData);

                boolean foundChild = false;

                for(int j=0;j<10;j++) {

                    String tmp = Integer.toString(j)+rootData;
                    if(Integer.parseInt(tmp)%divs[i] == 0) {
                        if(foundChild) {
                            //System.out.println("Found multiple childs for " + list.toString() + tmp);
                            List<String> copy = new ArrayList<String>(list);

                            String rem = copy.remove(copy.size()-1);
                            //System.out.println("removed " + rem);
                            copy.add(tmp);
                            newOnes.add(copy);
                        } else {
                            list.add(tmp);
                            foundChild = true;
                        }
                    }
                }
            }
           // System.out.println("New ones" + newOnes);

            Boolean changed = all.addAll(newOnes);
            //System.out.println("changed " + changed);

        }

        long sum = 0L;


        for(List<String> list : all) {

            if(list.size() < 7){
                continue;
            }
            String full = "";
            for(int i = 0 ; i < list.size() ; i++) {
                if(i==0)
                   full = list.get(i);
                else
                    full = list.get(i).substring(0,1) + full;
            }

           // if(isPandigital(Long.parseLong(full)))

                for(int i = 0 ; i < 10 ; i++) {
                    String tmp = i + full;
                    if(isPandigital(Long.parseLong(tmp))){
                        System.out.println(list.toString() + tmp);
                        sum += Long.parseLong(tmp);
                    }
                }

        }

        System.out.println("sum: " + sum);


        stopTimer();


    }




    private static boolean isPandigital(long i) {
        String s = Long.toString(i);
        int n = s.length();
        int[] matches = new int[10];
        for(int j = 0 ; j < n ; j++) {

            char letter = s.charAt(j);
            switch (letter) {
                case '0' : matches[0] = matches[0]+1; break;
                case '1' : matches[1] = matches[1]+1; break;
                case '2' : matches[2] = matches[2]+1; break;
                case '3' : matches[3] = matches[3]+1; break;
                case '4' : matches[4] = matches[4]+1; break;
                case '5' : matches[5] = matches[5]+1; break;
                case '6' : matches[6] = matches[6]+1; break;
                case '7' : matches[7] = matches[7]+1; break;
                case '8' : matches[8] = matches[8]+1; break;
                case '9' : matches[9] = matches[9]+1; break;
            }
        }
        for(int j = 0 ; j < n ; j++) {
            if(matches[j] != 1) return false;
        }
        return true;

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
