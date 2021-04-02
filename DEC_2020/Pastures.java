import java.io.*;
import java.util.*;
public class Pastures {
    public static int N;
    public static int[][] g;
    public static int[][] dp;
    public static class Cow{
        int x;
        int y;
        public Cow(int x, int y){
            this.x=x;
            this.y=y;
        }
        public boolean compareTo(Cow c){
            return (x==c.x)&&(y==c.y);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        g = new int[N][N];
        dp = new int[N][N];
        Cow[] input = new Cow[N];
        for (int i=0;i<N;i++){
            String[] s = r.readLine().split(" ");
            input[i] = new Cow(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Cow[] c1 = input;
        Cow[] c2 = input;
        Arrays.sort(c1, (a,b)->Integer.compare(a.x,b.x));
        Arrays.sort(c2, (a,b)->Integer.compare(a.y,b.y));
        for (int i=0;i<N;i++){
            int store = -1;
            for (int j=0;j<N;j++){
                if (c1[i].compareTo(c2[j])){
                    store = j;
                    break;
                }
            }
            g[i][store]++;
            c1[i].x=i;
            c1[i].y=store;
        }
        for (int i=1;i<N;i++){
            dp[0][i]=dp[0][i-1]+g[0][i];
            dp[i][0]=dp[i-1][0]+g[i][0];
        }
        long answer = 0;
        for (int i=1;i<N;i++){
            for (int j=1;j<N;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+g[i][j];
            }
        }
        for (int i=0;i<N;i++){
            for (int j=i;j<N;j++){
                int y1 = Math.min(c1[i].y,c1[j].y);
                int y2 = Math.max(c1[i].y,c1[j].y);
                int x1 = c1[i].x;
                int x2 = c1[j].x;
                answer+=(1+dp[x1][y2]-dp[x1][y1])*(1+dp[N-1][y2]-dp[x2][y2]-dp[N-1][y1]+dp[x2][y1]);
            }
        }
        System.out.println(answer);
    }
}
