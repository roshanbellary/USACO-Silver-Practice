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
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        points = new Rectangle[N];
        for (int i=0;i<N;i++){
            String[] s = r.readLine().split(" ");
            points[i]=new Rectangle(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(points);
        long sum=0;
        sum+=N+1;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                int count=0;
                for (int z=j-1;z>i;z--){
                    int d1 = points[j].y-points[i].y;
                    int d2 = points[z].y-points[i].y;
                    if ((d1>0)&&(d2>0)){
                        if (d1>d2){
                            count++;
                        }
                    }
                    if ((d1<0)&&(d2<0)){
                        if (d1<d2){
                            count++;
                        }
                    }
                }
                sum+=(long)Math.pow(2,j-i-count-1);
            }
        }
        System.out.println(sum);
    }
}