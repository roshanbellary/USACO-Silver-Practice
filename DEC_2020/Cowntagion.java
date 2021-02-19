// Works for 12/15 of the test cases. Test cases 4, 7, 10 are all said to be wrong
import java.io.*;
import java.util.*;
public class Cowntagion {
    public static int N;
    public static int result=0;
    public static ArrayList<Integer>[] e;
    public static void dfs(int i, int prev){
        if ((e[i].size()>1)&&(i!=0)){
            int count=0;
            while((int)Math.pow(2, count)<e[i].size()){count++;}
            result+=(count);
        }
        for (int j=0;j<e[i].size();j++){
            if (e[i].get(j)!=prev){
                dfs(e[i].get(j),i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        e = new ArrayList[N];
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
        r.close();
        if (e[0].size()>0){
            int count=0;
            while((int)Math.pow(2, count)<e[0].size()){count++;}
            result+=(count);
        }
        Cowntagion.dfs(0,0);
        result+=N-1;
        System.out.println(result);
    }
}
