import java.io.*;
import java.util.*;
public class Convention2{
    public static int N;
    public static Cow[] c;
    public static int[] w;
    public static class Cow implements Comparable<Cow>{
        int s;
        int d;
        int p;
        public Cow(int _s,int _d, int _p){
            s=_s;
            d=_d;
            p=_p;
        }
        public int compareTo(Cow y){
            return Integer.compare(s,y.s);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        w = new int[N];
        c = new Cow[N];
        for (int i=0;i<N;i++){
            String[] store = r.readLine().split(" ");
            c[i] = new Cow(Integer.parseInt(store[0]), Integer.parseInt(store[1]), i);
        }
        Arrays.sort(c);
        int ctime = c[0].s;
        PriorityQueue<Cow> p = new PriorityQueue<Cow>();
        p.add(c[0]);
        for (Cow c:p){
            w[c.p]=c.s-ctime;
            ctime=c.s+c.d;
            for (int i=)
        }

    }
}