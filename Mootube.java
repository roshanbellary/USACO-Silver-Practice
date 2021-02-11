import java.io.*;
import java.util.*;
public class Mootube {
    public static int N;
    public static int Q;
    public static int[][] am;
    public static int[] index;
    public static int[] thr;
    public static int[] results;
    public static void dfs(int[] v, int i, int min){
        for (int z=0;z<N;z++){
            if ((v[z]==0)&&(am[i][z]>0)){
                int temp = am[i][z];
                if (temp<min){
                    v[z]=temp;
                    dfs(v, z, temp);
                }
                else{
                    v[z]=min;
                    dfs(v, z, min);
                }
            }
        }
    }
    public static void traverse(int i, int k){
        for (int j=0;j<N;j++){
            int[] v = new int[N];
            if (am[i][j]>0){
                v[j]=am[i][j];
                dfs(v,j,am[i][j]);
            }
            int count = 0;
            for (int z=0;z<N;z++){
                if (v[z]>=k){
                    count++;
                }
            }
            results[j]=count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/USACO_PRACTICE_SILVER/mootube.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        am = new int[N][N];
        results = new int[N];
        for (int i=0;i<N-1;i++){
            st = new StringTokenizer(r.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            am[i1-1][i2-1]=k;
            am[i2-1][i1-1]=k;
        }
        index = new int[Q];
        thr = new int[Q];
        for (int i=0;i<Q;i++){
            st = new StringTokenizer(r.readLine());
            index[i]=Integer.parseInt(st.nextToken())-1;
            thr[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<Q;i++){
            Mootube.traverse(index[i],thr[i]);
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        for (int i=0;i<Q;i++){
            pw.println(results[i]);
            System.out.println(results[i]);
        }
    }
}
