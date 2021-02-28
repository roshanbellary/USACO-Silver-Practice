import java.io.*;
import java.util.*;
class Pasture{
    public static int N;
    public static Rectangle[] points;
    public static class Rectangle implements Comparable<Rectangle>{
        int x;
        int y;
        public Rectangle(int _x, int _y){
            x=_x;
            y=_y;
        }
        public int compareTo(Rectangle rect){
            return Integer.compare(x,rect.x);
        }
    }
    public class Points implements Comparable<Points>{
        int x;
        int y;
        public Points(int _x, int _y){
            x=_x;
            y=_y;
        }
        public int compareTo(Points p){
            return Integer.compare(y, p.y);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        points = new Rectangle[N];
        for (int i=0;i<N;i++){
            String[] s = r.readLine().split(" ");
            points[i]=new Rectangle(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(points);
        ArrayList<Points> set = new ArrayList<Points>();
        for (int i=0;i<N;i++){
            set.clear();
            for (int j=i+1;j<N;j++){
                set.add(new Points(points[j].x,points[j].y));
            }
            Collections.sort(set);
            for (int z=0;z<N-i;z++){
                
            }
        }
    }
}