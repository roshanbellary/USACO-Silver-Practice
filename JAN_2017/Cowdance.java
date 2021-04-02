import java.io.*;
import java.util.*;
public class Cowdance {
    public static int N;
    public static int T;
    public static int[] d;
    public static int answer;
    public static boolean check(int num){
        int times = N/num;
        int remainder = N%num;
        int time=0;
        for (int j=num-1;j<num*(times-1);j+=num){
            time+=d[j];
        }
        time+=d[num*(times-1)+remainder-1];
        time+=d[N-1];
        if (time>T){
            return false;
        }
        return true;
    }
    public static void bin_search(){
        int low = 1;
        int high = N;
        int mid=0;
        while (low<high){
            mid = (low+high)/2;
            if (Cowdance.check(mid)){
                high = mid;
            }else{
                low = mid+1;
            } 
        }
        answer=mid;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("cowdance.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        d = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            d[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(d);
        Cowdance.bin_search();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        pw.println(answer);
        pw.close();
    }
}
