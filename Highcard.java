import java.io.*;
import java.util.*;
public class Highcard {
    public static int N;
    public static int[] e;
    public static int[] k;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("highcard.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        e = new int[N];
        k = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            e[i]=Integer.parseInt(st.nextToken());
        }
        r.close();
        Arrays.sort(e);
        int temp = 0;
        for (int i=2*N;i>0;i--){
            boolean x = true;
            for (int j=N-1;j>=0;j--){
                if (i==e[j]){
                    x=false;
                    break;
                }else if (e[j]<i){
                    break;
                }
            }
            if (x){
                temp=i;
                break;
            }
        }
        int maxn = 0;
        for (int i=1;i<temp;i++){
            for (int j=0;j<N;j++){
                if (e[j]>temp){
                    maxn=j;
                    break;
                }
            }
        }
        int result=0;
        if (maxn>0){
            if ((temp-e[0])
        }else{

        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        pw.println(temp-N);
        pw.close();

    }
}
