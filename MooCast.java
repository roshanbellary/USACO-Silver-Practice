import java.io.*;
import java.util.*;
public class MooCast {
    public static int N;
    public static int[] x;
    public static int[] y;
    public static int[] p;
    public static boolean[] v;
    public static boolean[] re;
    public static ArrayList<Integer>[] e;
    public static void dfs(int j){
        re[j]=true;
        v[j]=true;
        for (int i=0;i<e[j].size();i++){
            if (!v[e[j].get(i)]){
                dfs(e[j].get(i));
            }
        }
    }
    public static boolean check(){
        int count = 0;
        for (int i=0;i<N;i++){
            if (re[i]){
                count++;
            }
        }
        if (count==N){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("moocast.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        e = new ArrayList[N];
        x = new int[N];
        y = new int[N];
        p = new int[N];
        v = new boolean[N];
        re = new boolean[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
            p[i]=Integer.parseInt(st.nextToken());
            e[i]=new ArrayList<Integer>();
        }
        r.close();
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                int x2 = x[j]-x[i];
                int y2 = y[j]-y[i];
                int d = (int)Math.pow(x2,2)+(int)Math.pow(y2,2);
                if ((int)Math.pow(p[i],2)>=d){
                    e[i].add(j);
                }
                if ((int)Math.pow(p[j],2)>=d){
                    e[j].add(i);
                }
            }
        }
        int max = 0;
        int count=0;
        while(!MooCast.check()){
            count=0;
            for (int i=0;i<N;i++){
                if (!re[i]){
                    dfs(i);
                    break;
                }
            }
            for (int i=0;i<N;i++){
                if (v[i]){
                    count++;
                    v[i]=false;
                }
            }
            if (count>max){
                max = count;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        pw.println(max);
        System.out.println(max);
        pw.close();
    }
}
