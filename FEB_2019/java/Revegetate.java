import java.io.*;
import java.util.*;
public class Revegetate {
    public static int N;
    public static int M;
    public static ArrayList<Integer>[] a;
    public static void dfs(int i, boolean[] v){
        v[i]=true;
        for (int j=0;j<a[i].size();j++){
            if (!v[a[i].get(j)]){
                dfs(a[i].get(j), v);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("revegetate.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new ArrayList[N];
        for (int i=0;i<N;i++){
            a[i]= new ArrayList<Integer>();
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(r.readLine());
            st.nextToken();
            int store1 = Integer.parseInt(st.nextToken());
            int store2 = Integer.parseInt(st.nextToken());
            a[store1-1].add(store2-1);
            a[store2-1].add(store1-1);
        }
        boolean c = true;
        boolean[] v = new boolean[N];
        int count=0;
        while (c){
            c=false;
            for (int i=0;i<N;i++){
                if (!v[i]){
                    dfs(i, v);
                    break;
                }
            }
            count++;
            for (int i=0;i<N;i++){
                if (!v[i]){
                    c=true;
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        pw.print("1");
        for (int i=0;i<count;i++){
            pw.print("0");
        }
        pw.close();
    }
}
