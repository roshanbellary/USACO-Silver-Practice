import java.io.*;
import java.util.*;
public class Mountains {
    public static int N;
    public static Mountain[] range;
    public static class Mountain implements Comparable<Mountain>{
        int x, d;
        public Mountain(int _x, int _y){
            x=_x;
            d=_y;
        }
        public int compareTo(Mountain n){
            return Integer.compare(x, n.x);
        }
    }
    public static int calculate(int index, int pos){
        int height = 0;
        if (pos-range[index].x>=range[index].d){
            height=range[index].d-(pos-range[index].x-range[index].d);
        }else{
            height=pos-range[index].x;
        }
        return height;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("mountains.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        range = new Mountain[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            int store1 = Integer.parseInt(st.nextToken());
            int store2 = Integer.parseInt(st.nextToken());
            range[i]=new Mountain(store1-store2, 2*store2);
        }
        Arrays.sort(range);
        int start = range[0].x;
        int count=0;
        for (int i=0;i<N;i++){
            boolean hidden=false;
            for (int j=0;j<i;j++){
                if (Mountains.calculate(j,range[i].x+range[i].d)>=range[i].d){
                    hidden=true;
                }
            }
            if (!hidden){
                count++;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        pw.println(count);
        pw.close();
    }
}
