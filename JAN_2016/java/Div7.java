import java.io.*;
import java.util.*;
class Div7{
    public static int N;
    public static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("div7.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        p = new int[N];
        st = new StringTokenizer(r.readLine());
        p[0]=(Integer.parseInt(st.nextToken())%7);
        for (int i=1;i<N;i++){
            st = new StringTokenizer(r.readLine());
            p[i]=p[i-1]+(Integer.parseInt(st.nextToken())%7);
        }
        r.close();
        int max = 0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if ((p[j]-p[i])%7==0){
                    if ((j-i)>max){
                        max=(j-i);
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        pw.println(max);
        pw.close();
    }
}