import java.io.*;
import java.util.*;
public class Sort {
    public static int[] o;
    public static int[] s;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("sort.in"));
        N = Integer.parseInt(r.readLine());
        o = new int[N];
        s = new int[N];
        for (int i=0;i<N;i++){
            int store = Integer.parseInt(r.readLine());
            o[i]=store;
            s[i]=store;
        }
        r.close();
        Arrays.sort(s);
        int max = 1;
        for (int i=0;i<N;i++){
            int store = Arrays.binarySearch(s, o[i]);
            if (Math.abs(store-i)+1>max){
                max = Math.abs(store-i)+1;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        pw.println(max);
        pw.close();
    }
}
