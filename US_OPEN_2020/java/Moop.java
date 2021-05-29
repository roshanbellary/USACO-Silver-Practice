//not finished
import java.io.*;
import java.util.*;
public class Moop{
    public static class Particle{
        public static int a,b;
        public Particle(int _a,int _b){
            a=_a;
            b=_b;
        }
        public static int compareTo(Particle newp){
            return Integer.compare(a,newp.a);
        }
    }
    static ArrayList<Integer>[] edge;
    public static int N;
    public static Particle[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("moop.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        edge = new ArrayList[N];
        for (int i=0;i<N;i++){
            p[i]=new Particle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            edge[i]=new ArrayList<Integer>();
        }
        Arrays.sort(p);
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (p[j].b>=p[j].a){
                    edge[i].add(j);
                    edge[j].add(i);
                }
            }
        }
        
    }
}