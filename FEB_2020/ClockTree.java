import java.io.*;
import java.util.*;
public class ClockTree{
    public static int N;
    public static int[] t;
    public static ArrayList<Integer>[] e;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("clocktree.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        t = new int[N];
        e = new ArrayList[N];
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            t[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N-1;i++){
            st = new StringTokenizer(r.readLine());
            int store1 = Integer.parseInt(st.nextToken())-1;
            int store2 = Integer.parseInt(st.nextToken())-1;
            e[store1].add(store2);
            e[store2].add(store1);
        }
    }
}