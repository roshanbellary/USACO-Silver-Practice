import java.io.*;
import java.util.*;
public class Pastures {
    public static int N;
    public static class Cow1 implements Comparable<Cow1>{
        int x;
        int y;
        public Cow1(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Cow1 n){
            return Integer.compare(x, n.x);
        }
    }
    public static class Cow2 implements Comparable<Cow2>{
        int x;
        int y;
        public Cow2(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Cow2 n){
            return Integer.compare(y, n.y);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        Cow[] a = new Cow[N];
        for (int i=0;i<N;i++){
            String s = r.readLine();
            int[] store = s.split(" ");
            a[i] = new Cow(store[0], store[1]);
        }
        Arrays.
    }
}
