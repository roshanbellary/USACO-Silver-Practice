import java.io.*;
import java.util.*;
public class Comfortable{
    static boolean[][] pos = new boolean[1003][1003];
    public static int N;
    public static int[] results;
    public static int counts=0;
    public static void add(int x, int y){
        if (pos[x][y]) return;
        else pos[x][y]=true;
        counts++;
        if (x<1||x>1002||y<1||y>1002){
            return;
        }
        int index = Comfortable.check(x,y);
        if (index==-1){
            return;
        }
        counts++;
        if (index==1){
            Comfortable.add(x-1,y);
        }
        if (index==2){
            Comfortable.add(x+1,y);
        }
        if (index==3){
            Comfortable.add(x,y-1);
        }
        if (index == 4){
            Comfortable.add(x,y+1);
        }
    }
    public static int check(int x, int y){
        int count = 0;
        int index = -1;
        if (pos[x-1][y]) count++;
        else index=1;
        if (pos[x+1][y]) count++;
        else index=2;
        if (pos[x][y-1]) count++;
        else index=3;
        if (pos[x][y+1]) count++;
        else index=4;
        if (count==3) return index;
        else return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        results = new int[N];
        for (int i=0;i<N;i++){
            String[] store = r.readLine().split(" ");
            Comfortable.add(Integer.parseInt(store[0])+1,Integer.parseInt(store[1])+1);
            results[i]=counts;
        }
        for (int i=0;i<N;i++){
            System.out.println(results[i]);
        }
    }
}