package DEC_2019;
//very toxic simulation problem. Currently too sleep deprived and lazy to finish the simulate function right now. Not Finished Yet
import java.io.*;
import java.util.*;
public class Meetings {
    public static int T;
    public static int N;
    public static int L;
    public static Cow[] l;
    public static ArrayList<Interaction> meet = new ArrayList<Interaction>();
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
    static class Interaction implements Comparable<Interaction>{
        double t;
        int i,j;
        public Interaction(double _t, int _i, int _j){
            t=_t;
            i=_i;
            j=_j;
        }
        public int compareTo(Interaction y){
            return Double.compare(t,y.t);
        }
    }
    public static void simulate(){
        int time=0;
        boolean x=true;
        for (int i=0;i<N-1;i++){
            if ((l[i].v>0)&&(l[i+1].v<0)){
                double diff = (double)(l[i+1].x-l[i].x)/2;
                meet.add(new Interaction(diff, i, i+1));
            } 
        }
        while(x){
            int min=Integer.MAX_VALUE;
            int temp=-1;
            for (int j=0;j<meet.size();j++){
                if (meet.get(j).t<min){
                    min=meet.get(j).t;
                    temp=j;
                }
            }
            int store = meet.get(temp).i;
            time+=meet.get(temp).diff;
            l[meet.get(temp).i]=-1;
            l[meet.get(temp).j]=1;
            if (meet.get(temp).j<N-1){
                if (l[meet.get(temp).j+1].v<0){
                    double diff = (double)(l[meet.get(temp).j+1].x-l[meet.get(temp).j].x)/2;
                    meet.add(new Interaction(diff,meet.get(temp).j,meet.get(temp).j+1));
                }
            }
            if (meet.get(temp).i>0){
                if (l[meet.get(temp).i-1].v>0){
                    double diff = (double)(l[meet.get(temp).i].x-l[meet.get(temp).i-1].x)/2;
                    meet.add(new Interaction(diff,meet.get(temp).i-1,meet.get(temp).i));
                }
            }
            meet.remove(temp);
            for (int i=0;i<N;i++){
                if ((i==store)||(i==store+1)){

                }else{
                    l[i]
                }
            }
            x=false;
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
