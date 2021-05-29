import java.io.*;
import java.util.*;
public class HelpCross {
    public static int C;
    public static int N;
    public static int[] t;
    public static Period[] p;
    static class Period implements Comparable<Period>{
        int a,b;
        public Period(int _a, int _b){
            a=_a;
            b=_b;
        }
        public int compareTo(Period c){
            return Integer.compare(a,c.a);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("helpcross.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        t = new int[C];
        p = new Period[N];
        for (int i=0;i<C;i++){
            st = new StringTokenizer(r.readLine());
            t[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            p[i] = new Period(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        r.close();
        Arrays.sort(t);
        Arrays.sort(p);
        int count=0;
        boolean[] u = new boolean[N];
        for (int i=0;i<C;i++){
            ArrayList<Integer> works = new ArrayList<Integer>();
            for (int j=0;j<N;j++){
                if ((p[j].a<=t[i])&&(p[j].b>=t[i])&&(!u[j])){
                    works.add(j);
                }
            }
            if (works.size()>0){
                int min = Integer.MAX_VALUE;
                int ind = -1;
                for (int j=0;j<works.size();j++){
                    if (p[works.get(j)].b<min){
                        min = p[works.get(j)].b;
                        ind = j;
                    }
                }
                u[works.get(ind)]=true;
                count++;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        pw.println(count);
        pw.close();
    }
}
