import java.io.*;
import java.util.*;
public class Perimeter{
    public static int N;
    public static boolean[][] g;
    public static boolean[][] u;
    public static int area;
    public static void floodfill(int i, int j){
        if ((i>=N)||(j>=N)){
            return;
        }
        if (g[i][j]){
            if (!u[i][j]){
                u[i][j]=true;
                area++;
                floodfill(i+1,j);
                floodfill(i,j+1);
            }else{
                return;
            }
            
        }else{
            return;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("perimeter.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        g = new boolean[N][N];
        u = new boolean[N][N];
        for (int i=0;i<N;i++){
            String s = r.readLine();
            for (int j=0;j<N;j++){
                if (s.substring(j,j+1).equals("#")){
                    g[i][j]=true;
                }else{
                    g[i][j]=false;
                }
            }
        }
    }
}