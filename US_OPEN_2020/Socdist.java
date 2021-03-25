import java.io.*;
import java.util.*;
public class Socdist {
    public static int N;
    public static int M;
    public static class Interval implements Comparable<Interval>{
        int s;
        int f;
        public Interval(int _s, int _f){
            s=_s;
            f=_f;
        }
        public int compareTo(Interval n){
            return Integer.compare(s,n.s);
        }
    }
    public static void check(int D){
        
    }
    public static void bin_search(){

    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("socdist.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    }
}
