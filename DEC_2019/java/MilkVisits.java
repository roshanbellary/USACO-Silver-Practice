//Partially finished. Timeouts after Case 5, so this sol is in dire need of time complexity improvement
import java.io.*;
import java.util.*;

public class MilkVisits {
    public static int N;
    public static boolean[] p;
    public static int M;
    public static ArrayList<Integer>[] e;
    public static ArrayList<Integer> path;
    public static boolean[] m;
    public static int[] start;
    public static int[] end;
    public static void dfs(int i, int j, boolean[] v, ArrayList<Integer> p){
        if (!v[j]){
            if (i==j){
                p.add(j);
                v[j]=true;
                path=p;
                return;
            }
            v[i]=true;
            p.add(i);
            for (int z=0;z<e[i].size();z++){
                if ((!v[e[i].get(z)])){
                    ArrayList<Integer> s = (ArrayList)p.clone();
                    MilkVisits.dfs(e[i].get(z), j, v,s);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("milkvisits.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new boolean[N];
        e = new ArrayList[N];
        m = new boolean[M];
        start = new int[M];
        end = new int[M];
        String s = r.readLine();
        for (int i=0;i<N;i++){//Setting values of farms is done correctly
            if (String.valueOf(s.charAt(i)).equals("H")){
                p[i]=true;
            }else{
                p[i]=false;
            }
            e[i]= new ArrayList<Integer>();
        }
        for (int i=0;i<N-1;i++){//Adding edges is done correctly
            st = new StringTokenizer(r.readLine());
            int s1 = Integer.parseInt(st.nextToken())-1;
            int s2 = Integer.parseInt(st.nextToken())-1;
            e[s1].add(s2);
            e[s2].add(s1);
        }
        for (int i=0;i<M;i++){// start and stopping is done correctly along with setting booleans
            st = new StringTokenizer(r.readLine());
            start[i] = Integer.parseInt(st.nextToken())-1;
            end[i] = Integer.parseInt(st.nextToken())-1;
            if (st.nextToken().equals("H")){
                m[i]=true;
            }else{
                m[i]=false;
            }
        }
        r.close();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        for (int i=0;i<M;i++){
            boolean[] vi = new boolean[N];
            ArrayList<Integer> store = new ArrayList<Integer>();
            MilkVisits.dfs(start[i],end[i],vi,store);
            boolean x=false;
            for (int j=0;j<path.size();j++){
                if (p[path.get(j)]==m[i]){
                    x=true;
                }
            }
            if (x){
                pw.print("1");
            }else{
                pw.print("0");
            }
        }
        pw.close();
    }
}
