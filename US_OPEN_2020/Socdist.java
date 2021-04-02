import java.io.*;
import java.util.*;
public class Socdist {
    public static int N;
    public static int M;
    public static Interval[] val;
    public static int distance;
    public static class Interval implements Comparable<Interval>{
        int s;
        int l;
        public Interval(int _s, int _l){
            s=_s;
            l=_l;
        }
        public int compareTo(Interval n){
            return Integer.compare(s,n.s);
        }
    }
    public static void bin_search(){
        int low=1;
        int high=Integer.MAX_VALUE;
        while (low<high){
            int mid = low+(high-low)/2;
            if (Socdist.check(mid)){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        distance = high;
    }
    public static boolean check(int d){
        int start = val[0].s;
        boolean cont = true;
        int count=0;
        while (count<N){
            boolean none = true;
            for (int i=0;i<M;i++){
                if ((val[i].s<=start+d)&&(val[i].l>=start+d)){
                    start+=d;
                    count++;
                    none = false;
                    break;
                }
                if (val[i].s>=start+d){
                    start=val[i].s;
                    count++;
                    none = false;
                    break;
                }
            }
            if (none){
                break;
            }
        }
        return (count==N);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("socdist.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        val = new Interval[M];
        for (int i=0;i<M;i++){
            st = new StringTokenizer(r.readLine());
            int store1 = Integer.parseInt(st.nextToken());
            int store2 = Integer.parseInt(st.nextToken());
            val[i] = new Interval(store1, store2); 
        }
        r.close();
        Arrays.sort(val);
        Socdist.bin_search();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        pw.println(distance);
        System.out.println(distance);
        pw.close();
    }
}
