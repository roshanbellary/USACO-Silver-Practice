package DEC_2020;
import java.io.*;
import java.util.*;
public class Cowntagion {
    public static int N;
    public static int result=0;
    public static ArrayList<Integer>[] e;
    public static void bfs(int i, int prev){
        
    }
    public static void main(String[] args){
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        e = new ArrayList[N-1];
        for (int i=0;i<N;i++){
            e[i]= new ArrayList<Integer>();
        }
        for (int i=0;i<N-1;i++){
            String[] store = r.readLine().split(" ");
            int v1 = Integer.parseInt(store[0])-1;
            int v2 = Integer.parseInt(store[1])-1;
            e[v1].add(v2);
            e[v2].add(v1);
        }
        result+=(int)(Math.log(e[0].size())/Math.log(2))+e[0].size();
    }
}
