import java.io.*;
import java.util.*;
public class Swap{
    public static int N;
    public static int K;
    public static ArrayList<Integer>[] e;
    public static int[] results;
    public static ArrayList<Integer> addOn;
    public static ArrayList<Integer> v = new ArrayList<Integer>();
    public static void dfs(int n, boolean[] visited){
        visited[n]=true;
        addOn.add(n);
        v.remove(Integer.valueOf(n));
        for (int i=0;i<e[n].size();i++){
            if (!visited[e[n].get(i)]){
                dfs(e[n].get(i),visited);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        e = new ArrayList[N];
        for (int i=0;i<N;i++){
            e[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<K;i++){
            s = r.readLine().split(" ");
            int n1 = Integer.parseInt(s[0])-1;
            int n2 = Integer.parseInt(s[1])-1;
            e[n1].add(n2);
        }
        for (int i=0;i<N;i++){
            v.add(i);
        }
        boolean[] visited = new boolean[N];
        results = new int[N];
        while (v.size()>0){
            addOn = new ArrayList<Integer>();
            Swap.dfs(v.get(0), visited);
            for (int i=0;i<addOn.size();i++){
                results[addOn.get(i)]=addOn.size();
            }
        }
        for (int i=0;i<N;i++){
            System.out.println(results[i]);
        }
    }
}