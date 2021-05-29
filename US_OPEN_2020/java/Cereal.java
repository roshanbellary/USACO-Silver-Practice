//Temp Sol-very inefficient spent like 2 minutes on this for fun. Will make a more optimized sol
package US_OPEN_2020;
import java.io.*;
import java.util.*;
public class Cereal {
    public static int N;
    public static int M;
    public static int[] f;
    public static int[] s;
    public static int[] results;
    public static ArrayList<Integer> chosen = new ArrayList<Integer>();
    public static boolean find(int i){
        if (chosen.size()>0){
            for (int j=0;j<chosen.size();j++){
                if (chosen.get(j)==i){
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }
    public static void simulate(int i){
        chosen = new ArrayList<Integer>();
        int count=0;
        for (int j=i;j<N;j++){
            if (!Cereal.find(f[j])){
                chosen.add(f[j]);
                count++;
            }else if (!Cereal.find(s[j])){
                chosen.add(s[j]);
                count++;
            }
        }
        results[i]=count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("cereal.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        f = new int[N];
        s = new int[N];
        results = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            f[i]=Integer.parseInt(st.nextToken());
            s[i]=Integer.parseInt(st.nextToken());
        }
        r.close();
        for (int i=0;i<N;i++){
            Cereal.simulate(i);
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        for (int i=0;i<N;i++){
            System.out.println(results[i]);
            pw.println(results[i]);
        }
        pw.close();
    }
}
