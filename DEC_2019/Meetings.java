package DEC_2019;
//very toxic simulation problem. Currently too sleep deprived and lazy to finish the simulate function right now. Not Finished Yet
import java.io.*;
import java.util.*;
public class Meetings {
    public static int T;
    public static int N;
    public static int L;
    public static Cow[] l;
    static class Cow implements Comparable<Cow>{
        int x,w,v;
        public Cow(int x, int w, int v){
            this.x=x;
            this.w=w;
            this.v=v;
        }
        public int compareTo(Cow y){
            return Integer.compare(x,y.x);
        }
    }
    public static void simulate(){
        boolean x=true;
        while(x){
            for (int i=0;i<N;i++){
                if ((l[i].v)>0)&&(l[i+1].v<0)){
                    
                }
            }
            break;
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
            l[i]=new Cow(x,w,v);
        }
        Arrays.sort(l);
        
    }
}
