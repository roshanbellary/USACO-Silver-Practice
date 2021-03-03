import java.io.*;
import java.util.*;
public class Year {
    public static int N;
    public static int K;
    public static ArrayList<Integer> t;
    public static int[] p;
    public static int[] diff;
    public static int time=0;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] store = r.readLine().split(" ");
        N = Integer.parseInt(store[0]);
        K = Integer.parseInt(store[1]);
        t = new ArrayList<Integer>();
        for (int i=0;i<N;i++){
            int stores = Integer.parseInt(r.readLine());
            boolean done = false;
            for (int j=0;j<t.size();j++){
                if (t.get(j)==(stores-(stores%12))){
                    done = true;
                }
            }
            if (!done){
                t.add(stores-(stores%12));
            }
        }
        Collections.sort(t);
        time+=t.size()*12;
        diff = new int[t.size()];
        for (int i=0;i<t.size()-1;i++){
            diff[i] =t.get(i+1)-t.get(i);
        }
        Arrays.sort(diff);
        for (int i=0;i<t.size()-K+1;i++){
            time+=diff[i];
        }
        System.out.println(time);
    }
}
