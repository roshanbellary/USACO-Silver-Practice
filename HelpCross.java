import java.io.*;
import java.util.*;
public class HelpCross {
    public static int C;
    public static int N;
    public static int[] t;
    public static int[] s;
    public static int[] e;
    public static int[] a;
    public static boolean[][] in;
    public static void main(String[] args){
        BufferedReader r = new BufferedReader(new FileReader("helpcross.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        t = new int[C];
        s = new int[N];
        e = new int[N];
        a = new int[C];
        in = new boolean[C][N];
        for (int i=0;i<C;i++){
            st = new StringTokenizer(r.readLine());
            t[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            s[i]=Integer.parseInt(st.nextToken());
            e[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<C;i++){
            int count=0;
            for (int j=0;j<N;j++){
                if ((t[i]>=s[j])&&(t[i]<=e[j])){
                    in[i][j]=true;
                    count++;
                }
            }
            a[i]=count;
        }
        for (int i=0;i<N;i++){
            ArrayList<Integer> p = new ArrayList<Integer>();
            for (int j=0;j<C;j++){
                if (in[j][i]){
                    p.add(j);
                }
            }
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j=0;j<p.size();j++){
                if (a[j]<min){
                    min=a[j];
                    index=j;
                }
            }
        }
    }
}
