import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: andreas
 * Date: 6/2/12
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem39 {
    private static long startTime;
    public static void main(String[] args) {

        startTimer();
        int perimeter = 1000;
        Map<Integer, List<Triangle>> hits = new HashMap<Integer, List<Triangle>>();

        for(int p = 4 ; p <= perimeter ; p++) {
            hits.put(p,new ArrayList<Triangle>());
            for(int a = 1 ; a <= p-2; a++) {
                for(int b = 1 ; b <= p-1-a ; b++) {
                    for(int c = 1 ; c<=p-a-b ; c++) {
                        if(isCorrectLength(a,b,c,p) && isRight(a,b,c)){

                            Triangle t = new Triangle(a,b,c,p);
                            List<Triangle> l = hits.get(p);
                            if(!l.contains(t)) {
                                l.add(t);
                                hits.put(p,l);
                            }

                        }
                    }
                }
            }
        }

        int highest = -1;
        for(Map.Entry<Integer, List<Triangle>> entry : hits.entrySet()) {
            List<Triangle> list = entry.getValue();

            if(list.size() > highest) {
                System.out.println("New highest:");
                for(Triangle t : list) {
                    t.print();
                }

                highest = list.size();
            }
        }
        stopTimer();
    }

    private static boolean isRight(int a, int b, int c){
        return (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2));
    }

    private static boolean isCorrectLength(int a, int b, int c, int p) {
        return (a+b+c==p);
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

class Triangle {
    private int a;
    private int b;
    private int c;
    private int p;
    Triangle(int a, int b, int c, int p){
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = p;
    }

    private boolean isRight(){
        return (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2));
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object triangle) {
        /*if (this == triangle)
            return true;
        if (triangle == null)
            return false;
        if (getClass() != triangle.getClass())
            return false;*/
        final Triangle other = (Triangle) triangle;
        if(this.a == other.getB() && this.b == other.getA()) {
            return true;
        } else if(this.b == other.getB() && this.a == other.getA()) {
            return true;
        }
        return false;
    }

    public void print(){
        System.out.println(p+": {" + a + ", " + b + ", " + c + "}");
    }


}
