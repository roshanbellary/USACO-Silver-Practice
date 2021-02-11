import java.io.*;
import java.util.*;
public class Berries{
    public static int N;
    public static int K;
    public static int[] c;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("berries.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c);
        for (int i=0;i<N;i++){
            
        }
    }
}