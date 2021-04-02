import java.io.*;
import java.util.*;
public class Convention {
    public static int N;
    public static int M;
    public static int C;
    public static long answer;
    public static int[] a;
    public static boolean check(long t){
        int start = a[0];
        int count=1;
        int bus=1;
        int cap=0;
        while (count<N+1){
            if ((a[count-1]<=start+t)&&(cap<C)){
                count++;
                cap++;
            }else{
                cap=1;
                bus++;
                start = a[count-1];
                count++;
            }
        }
        return (bus<=M);
    }
    public static void bin_search(){
        long low=1;
        long max=a[N-1];
        while (low<max){
            long mid = low +(max-low)/2;
            if (Convention.check(mid)){
                max = mid;
            }else{
                low=mid+1;
            }   
        }
        answer=low;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("convention.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        r.close();
        Arrays.sort(a);
        Convention.bin_search();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        pw.println(answer);
        pw.close();
    }
}
