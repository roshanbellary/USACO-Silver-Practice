import java.io.*;
import java.util.*;

public class Perimeter {
    public static int N;
    public static boolean[][] b;
    public static boolean[][] v;
    public static int area = 0;
    public static int tempa = 0;
    public static int tempp = 0;
    public static int perimeter = 0;
    public static void perimcheck(int i, int j){
        if ((i==0)||(j==0)){
            if (i==0){
                if (j==0){
                    tempp+=4;
                }else{
                    if (v[i][j-1]){
                        tempp+=2;
                    }else{
                        tempp+=4;
                    }
                }
            }
            if (j==0){
                if (i!=0){
                    if (v[i-1][j]){
                        tempp+=2;
                    }else{
                        tempp+=4;
                    }
                }
            }
        }
        else{
            if (v[i-1][j]){
                if (!v[i][j-1]){
                    tempp+=2;
                }
            }
            if (v[i][j-1]){
                if (!v[i-1][j]){
                    tempp+=2;
                }
            }
        }
    }
    public static void floodfill(int i, int j){
        tempa++;
        v[i][j]=true;
        Perimeter.perimcheck(i, j);
        if (i>0){
            int temp1=i-1;
            if (b[temp1][j]&&(!v[temp1][j])){
                floodfill(temp1, j);
            }
        }
        if (j>0){
            int temp3=j-1;
            if (b[i][temp3]&&(!v[i][temp3])){
                floodfill(i, temp3);
            }
        }
        if (i<N-1){
            int temp2=i+1;
            if (b[temp2][j]&&(!v[temp2][j])){
                floodfill(temp2, j);
            }
        }
        if (j<N-1){
            int temp4=j+1;
            if (b[i][temp4]&&(!v[i][temp4])){
                floodfill(i, temp4);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/USACO_PRACTICE_SILVER/perimeter.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        b = new boolean[N][N];
        v = new boolean[N][N];
        for (int i=0;i<N;i++){
            String s = r.readLine();
            System.out.println(s);
            for (int j=0;j<N;j++){
                if (String.valueOf(s.charAt(j)).equals("#")){
                    b[i][j]=true;
                }else{
                    b[i][j]=false;
                }
            }
        }
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if ((b[i][j])&&(!v[i][j])){
                    floodfill(i,j);
                    if (tempa>area){
                        area=tempa;
                    }
                    if (tempp>perimeter){
                        perimeter=tempp;
                    }
                    tempa=0;
                    tempp=0;
                }
            }
        }
        System.out.println(area+" "+perimeter);
    }
}
