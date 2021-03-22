import java.io.*;
import java.util.*;
public class MooyooMooyoo {
    public static int N;
    public static int K;
    public static int[][] g;
    public static boolean[][] c;
    public static void simulate(){
        for (int i=0;i<N;i++){
            for (int j=0;j<10;j++){
                if (g[i][j]>0){
                }
            }
        }
    }
    public static boolean gravity(){
        boolean a = false;
        for (int j=0;j<10;j++){
            for (int i=N-1;i>=0;i--){
                if (g[i][j]>0){
                    boolean e = false;
                    for (int z=i+1;z<N;z++){
                        if (g[z][j]>0){
                            g[z-1][j]=g[i][j];
                            g[i][j]=0;
                            a=true;
                            break;
                        }
                        if (z=N-1){
                            e=true;
                        }
                    }
                    if (e){
                        a=true;
                        g[N-1][j]=g[i][j];
                        g[i][j]=0;
                    }
                }
            }
        }
        return a;
    }
    public static void floodfill(int i, int j, int k, boolean[][] u, ){
        
    }
    public static boolean erase(){
        for (int i=0;i<N;i++){
            for (int j=0;j<10;j++){
                boolean[][] u = new boolean[N][10];
                if (g[i][j]&&!u[i][j]) 
            }
        }
    }
    public static void main(String[] args){
        BufferedReader r = new BufferedReader(new FileReader("mooyoomooyoo.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        g = new int[N][10];
        for (int i=0;i<N;i++){
            String s = r.readLine();
            for (int j=0;j<10;j++){
                g[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
    }
}
