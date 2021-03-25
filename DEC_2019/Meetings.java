package DEC_2019;
//very toxic simulation problem. Currently too sleep deprived and lazy to finish the simulate function right now. Not Finished Yet
import java.io.*;
import java.util.*;
public class Meetings {
    public static int N;
    public static int L;
    public static ArrayList<Cow> l = new ArrayList<>();
    public static class Cow implements Comparable<Cow>{
        int x;
        int v;
        int w;
        public Cow(int _x, int _w, int _v){
            x=_x;
            v=_v;
            w=_w;
        }
        public int compareTo(Cow n){
            return Integer.compare(x,n.x);
        }
    }
    public static class Interaction implements Comparable<Interaction>{
        Cow a;
        Cow b;
        double t;
        public Interaction(Cow _a, Cow _b, double time){
            a=_a;
            b=_b;
            t=time;
        }
    }
    public static void simulate(){
        int sum=0;
        PriorityQueue<
        while(sum<=total/2){
            for (int i=0;i<N-1;i++){
                if (l.get(i).x<0){
                    sum+=l.get(i).w;
                }
                if ((l.get(i).v>0)&&(l.get(i+1).v<0)){
                    
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("meetings.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        l = new Cow[N];
        int total=0;
        for (int i=0;i<N;i++){
            int w = Integer.parseInt(st.nextToken());
            total+=w;
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            l.add(new Cow(x,w,v));
        }
        Collections.sort(l);

        
    }
}
