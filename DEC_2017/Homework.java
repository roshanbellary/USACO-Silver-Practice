import java.io.*;
import java.util.*;
public class Homework {
    public static int N;
    public static int[] p;
    public static int[] v;
    public static int find_min(int i){
        int min=Integer.MAX_VALUE;
        for (int z=i;z<N;z++){
            if (v[z]<min){
                min=v[z];
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("homework.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        p = new int[N];
        v = new int[N];
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            v[i] = Integer.parseInt(st.nextToken());
        }
        r.close();
        int min=v[N-1];
        p[N-1]=0;
        for (int i=N-2;i>=0;i--){
            p[i]=p[i+1]+v[i]+min;
            if (v[i]<min){
                min=v[i];
            }
            p[i]-=min;
        }
        double max=0;
        ArrayList<Integer> solutions = new ArrayList<Integer>();
        for (int i=1;i<N-1;i++){
            if(p[i]>max*(N-i)){
                solutions.clear();
                max = p[i]/(N-i);
                solutions.add(i);
            }else if (p[i]==max*(N-i)){
                solutions.add(i);
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        Collections.sort(solutions);
        for (int i=0;i<solutions.size();i++){
            if(i==solutions.size()-1){
                pw.print(solutions.get(i));
            }else{
                pw.print(solutions.get(i)+" ");
            }
        }
        pw.close();
    }
}
