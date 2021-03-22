import java.io.*;
import java.util.*;
public class Homework {
    public static int N;
    public static int[] p;
    public static int[] v;
    public static int[] m;
    public static double[] re;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("homework.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        p = new int[N];
        m = new int[N];
        v = new int[N];
        re = new double[N];
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<N;i++){
            v[i] = Integer.parseInt(st.nextToken());
            if (i==0) p[i]=v[i];
            else p[i]=p[i-1]+v[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i=N-1;i>=0;i--){
            if (v[i]<min){
                m[i]=v[i];
                min=v[i];
            }else{
                m[i]=min;
            }
        }
        double max=0;
        int index=-1;
        for (int i=1;i<N-1;i++){
            if((double)(p[N-1]-p[i]-m[i])/(N-i)>max){
                max=(double)(p[N-1]-p[i]-m[i])/(N-i);
                index=i;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        pw.println(index+1);
        pw.close();
    }
}
