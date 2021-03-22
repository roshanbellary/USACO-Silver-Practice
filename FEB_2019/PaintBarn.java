import java.io.*;
import java.util.*;
class PaintBarn{
    public static int N;
    public static int K;
    public static int[][] g = new int[1001][1001];
    public static void paint(int x1, int y1, int x2, int y2){
        for (int i=x1;i<=x2;i++){
            for (int j=y1;j<=y2;j++){
                g[i][j]++;
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/GitHub/USACO-Silver-Practice/FEB_2019/paintbarn.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            PaintBarn.paint(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        r.close();
        int count=0;
        for (int i=0;i<=1000;i++){
            for (int j=0;j<=1000;j++){
                if (g[i][j]==K){
                    count++;
                }
            }
        }
        System.out.println(count);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        pw.println(count);
        pw.close();
    }
}