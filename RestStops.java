import java.io.*;
import java.util.*;
public class RestStops{
    public static int L;
    public static int N;
    public static int b;
    public static int f;
    public static int[] x;
    public static int[] c;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("reststops.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        x = new int[N];
        c = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            c[i]=Integer.parseInt(st.nextToken());
        }

    }
}