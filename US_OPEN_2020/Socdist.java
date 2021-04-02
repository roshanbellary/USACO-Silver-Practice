import java.io.*;
import java.util.*;
public class Socdist {
    public static int N;
    public static int M;
    public static Interval[] val;
    public static long distance;
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
        long low=1;
        long high=(long)Math.pow(10,18);
        while (low<high){
            long mid = low+(high-low)/2;
            if (Socdist.check(mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        distance=low;
    }
    public static boolean check(long d){
        int start = val[0].s;
        int current=0;
        int count=1;
        while ((current<M)&&(count<N)){
            if ((val[current].s<=start+d)&&(val[current].l>=start+d)){
                start+=d;
                count++;
            }
            else if (val[current].s>=start+d){
                start=val[current].s;
                count++;
            }
            else{
                current++;
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
        pw.close();
    }
}
