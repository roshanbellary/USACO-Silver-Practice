import java.io.*;
import java.util.*;
public class Mountains {
    public static int N;
    public static int[] x;
    public static int[] y;
    public static void sort(){
        for (int i=0;i<N;i++){
            for (int j=0;j<i;j++){
                if (x[j]>x[i]){
                    int temp1 = y[j];
                    int temp2 = x[j];
                    for (int z=j;z<i;z++){
                        int temp3 = y[z+1];
                        int temp4 = x[z+1];
                        y[z+1]=temp1;
                        x[z+1]=temp2;;
                        temp1 = temp3;
                        temp2 = temp4;
                    }
                    y[i]=temp1;
                    y[j]=temp2;
                    break;
                }
            }
        }
    }
    public static boolean compare(int i, int j){
        if (x[j]<(x[i]+y[i])){
            if (y[j]<=(y[i]-(x[j]-x[i]))){
                return true;
            }
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("mountains.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Mountains.sort();
        int count=0;
        for (int i=1;i<N-1;i+=2){
            boolean b1=false;
            boolean b2=false;
            if (Mountains.compare(i-1,i)){
                b1=true;
            }
            if (Mountains.compare(i,i+1)){
                b2=true;
            }
            if ()
        }
    }
}
