import java.io.*;
import java.util.*;
public class Closing {
    public static int N;
    public static int M;
    public static ArrayList<Integer>[] e;
    public static boolean[] v;
    public static int[] c;
    public static ArrayList<Integer> current = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("closing.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        e = new ArrayList[N];
        v = new boolean[N];
        c = new int[N];
        for (int i=0;i<N;i++){
            e[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(r.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            e[i1-1].add(i2-1);
            e[i2-1].add(i1-1);
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            c[i]=Integer.parseInt(st.nextToken())-1;
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        for (int i=0;i<N;i++){
            if (Closing.traverse()){
                pw.println("YES");
            }else{
                pw.println("NO");
            }
            current.add(c[i]);
        }
        pw.close();
    }
    public static boolean traverse(){
        for (int i=0;i<N;i++){
            if (!current.contains(i)){
                dfs(i);
                break;
            }
        }
        int count=0;
        for (int i=0;i<N;i++){
            if (v[i]){
                count++;
            }
        }
        for (int i=0;i<N;i++){
            v[i]=false;
        }
        if (count==N-current.size()){
            return true;
        }else{
            return false;
        }
    }
    public static void dfs(int i){
        v[i]=true;
        if (e[i].size()>0){
            for (int j=0;j<e[i].size();j++){
                if (!current.contains(e[i].get(j))&&(!v[e[i].get(j)])){
                    dfs(e[i].get(j));
                }
            }
        }
    }
}
