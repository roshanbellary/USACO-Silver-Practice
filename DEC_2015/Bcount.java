import java.io.*;
import java.util.*;
public class Bcount{
    public static int[] h;
    public static int[] g;
    public static int[] j;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("bcount.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        h = new int[N];
        g = new int[N];
        j = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            int store = Integer.parseInt(st.nextToken());
            if (i==0){
                if (store==1){
                    h[i]=1;
                    g[i]=0;
                    j[i]=0;
                }
                if (store==2){
                    g[i]=1;
                    h[i]=0;
                    j[i]=0;
                }
                if (store==3){
                    j[i]=1;
                    h[i]=0;
                    g[i]=0;
                }
            }else{
                if (store==1){
                    h[i]=h[i-1]+1;
                    g[i]=g[i-1];
                    j[i]=j[i-1];
                }
                if (store==2){
                    g[i]=g[i-1]+1;
                    h[i]=h[i-1];
                    j[i]=j[i-1];
                }
                if (store==3){
                    j[i]=j[i-1]+1;
                    h[i]=h[i-1];
                    g[i]=g[i-1];
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        for (int i=0;i<Q;i++){
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if (a==0){
                pw.print(h[b]+" ");
                pw.print(g[b]+" ");
                pw.print(j[b]);
            }else{
                pw.print((h[b]-h[a-1])+" ");
                pw.print((g[b]-g[a-1])+" ");
                pw.print((j[b]-j[a-1]));
            }
            pw.println();
        }
        pw.close();
    }
}