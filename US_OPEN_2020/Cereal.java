package US_OPEN_2020;
import java.io.*;
import java.util.*;
public class Cereal {
    public static int N;
    public static int M;
    public static int[] f;
    public static int[] s;
    public static void find(int i){
        
    }
    public static void simulate(int i){
        ArrayList<Integer> chosen = new ArrayList<Integer>();
        for (int j=i;i<N;i++){
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("cereal.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        f = new int[N];
        s = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            f[i]=Integer.parseInt(st.nextToken());
            s[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++){
            Cereal.simulate(i);
        }
    }
}
