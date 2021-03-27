import java.io.*;
import java.util.*;
public class Socdist {
    public static int N;
    public static int M;
    public static Interval[] val;
    public static class Interval implements Comparable<Interval>{
        int s;
        int l;
        public Interval(int _s, int _l){
            s=_s;
            l=_l;
        }
        public int compareTo(Interval n){
            return Integer.compare(s,n.s);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("socdist.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i=0;i<M;i++){
            st = new StringTokenizer(r.readLine());
            int store1 = Integer.parseInt(st.nextToken());
            int store2 = Integer.parseInt(st.nextToken());
            val[i] = new Interval(store1, store2-store1); 
        }
    }
}
