import java.io.IOException;
import java.util.*;
import java.io.*;

public class Lemonade {
    public static int N;
    public static int[] w;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("lemonade.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        w = new int[N];
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        r.close();
        Arrays.sort(w);
        int index = N;
        for (int i=0;i<N;i++){
            if (w[i]>=N){
                index=i;
                break;
            }
        }
        int count = N-index;
        index--;
        for (int j=index;j>=0;j--){
            if (w[j]>=count){
                count++;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        pw.print(count);
        pw.close();
    }
}
