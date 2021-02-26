package FEB_2017;
import java.io.*;
import java.util.*;
public class HelpCross {
    public static int C;
    public static int N;
    public static int[] t;
    public static Period[] p;
    static class Period implements Comparable<Period>{
        int a,b;
        public Period(int _a, int _b){
            a=_a;
            b=_b;
        }
        public int compareTo(Period c){
            return Integer.compare(a,c.a);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("helpcross.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        t = new int[C];
        p = new Period[N];
        for (int i=0;i<C;i++){
            st = new StringTokenizer(r.readLine());
            t[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            p[i] = new Period(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(t);
        Arrays.sort(p);
        for (int i=0;i<N;i++){
            for (int j=0;p[j].a<=t[i];j++){
                for (int z=0;z<=j;)
            }
        }
    }
}
