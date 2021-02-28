import java.io.*;
import java.util.*;
public class Blist{
    public static int N;
    public static Cows[] c;
    public static class Cows implements Comparable<Cows>{
        int s;
        int f;
        int b;
        public Cows(int _s,int _f,int _b){
            s=_s;
            f=_f;
            b=_b;
        }
        public int compareTo(Cows n){
            return Integer.compare(s,n.s);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("blist.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        c = new Cows[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            c[i]=new Cows(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        r.close();
        Arrays.sort(c);
        int buckets=0;
        int time=-1;
        int current=0;
        for (int i=0;i<N;i++){
            time=c[i].s;
            int sum=0;
            for (int j=i-1;j>=0;j--){
                if (c[j].f>time){
                    sum+=c[j].b;
                }
            }
            current=buckets-sum;
            if (c[i].b>current){
                buckets+=(c[i].b-current);
                current=0;
            }else{
                current-=c[i].b;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        pw.println(buckets);
        pw.close();
    }
}