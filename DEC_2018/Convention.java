import java.io.*;
import java.util.*;
class Convention{
    public static int N;
    public static int M;
    public static int C;
    public static int[] t;
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("convention.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            t[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t);
        int leeway = M*C-N;
        for (int i=0;i<N;i++){

        }
    }
}