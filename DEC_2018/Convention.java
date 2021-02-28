import java.io.*;
import java.util.*;
class Convention{
    public static int N;
    public static int M;
    public static int C;
    public static int[] t;
    public static long result;
    public static boolean check(long wait){
        int need=1;
        int first_t=t[0];
        int first_i=0;
        for (int i=1;i<N;i++){
            if (((t[i]-first_t)>wait)||((i-first_i+1)>C)){
                need++;
                first_t=t[i];
                first_i=i;
            }
        }
        return (need<=C);
    }
    public static void bin_search(long mi, long ma){
        long min=mi;
        long max=ma;
        long answer=-1;
        long pos=0;
        for (long a=max;a>=1;a/=2){
            while(Convention.check(pos+a)){
                pos+=a;
            }
        }
        result=pos+1;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("convention.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        t = new int[N];
        for (int i=0;i<N;i++){
            t[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t);
        Convention.bin_search(0, (long)Math.pow(10,9));
        System.out.println(result);
    }
}