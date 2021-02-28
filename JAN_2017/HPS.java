import java.io.*;
import java.util.*;
public class HPS{
    public static int N;
    public static int[] h;
    public static int[] p;
    public static int[] s;
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("hps.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        h = new int[N];
        p = new int[N];
        s = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            String store = st.nextToken();
            if (store.equals("H")){
                if (i>0){
                    h[i]=h[i-1]+1;
                    s[i]=s[i-1];
                    p[i]=p[i-1];
                }else{
                    h[0]=1;
                    s[0]=0;
                    p[0]=0;
                }
            }else if (store.equals("P")){
                if (i>0){
                    p[i]=p[i-1]+1;
                    s[i]=s[i-1];
                    h[i]=h[i-1];
                }else{
                    h[0]=0;
                    p[0]=1;
                    s[0]=0;
                }
            }else{
                if (i>0){
                    s[i]=s[i-1]+1;
                    h[i]=h[i-1];
                    p[i]=p[i-1];
                }else{
                    h[0]=0;
                    p[0]=0;
                    s[0]=1;
                }
            }
        }
        r.close();
        int max=0;
        for (int i=0;i<N;i++){
            int maxm = Math.max(Math.max(p[i]+h[N-1]-h[i],p[i]+s[N-1]-s[i]),Math.max(Math.max(h[i]+s[N-1]-s[i], h[i]+p[N-1]-p[i]), Math.max(s[i]+h[N-1]-h[i], s[i]+p[N-1]-p[i])));
            if (maxm>max){
                max=maxm;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        pw.println(max);
        pw.close();
    }
}