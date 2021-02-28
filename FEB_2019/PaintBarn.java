import java.io.*;
import java.util.*;
class PaintBarn{
    public static int N;
    public static int K;
    public static Rectangle[] paint;
    public class Rectangle{
        int x1;
        int x2;
        int y1;
        int y2;
        public Rectangle(int x1, int y1, int x2, int y2){
            this.x1=x1;
            this.x2=x2;
            this.y1=y1;
            this.y2=y2;
        }
    }
    public static void main(String[] args){
        BufferedReader r = new BufferedReader(new FileReader("paintbarn.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paint = new Rectangle[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            paint[i]=new Rectangle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
}