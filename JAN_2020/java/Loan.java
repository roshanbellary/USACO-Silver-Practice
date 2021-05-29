import java.io.*;
import java.util.*;
public class Loan{
    public static long N;
    public static long M;
    public static long K;
    public static long X;
    public static boolean check(long A){
        long G=0;
        for (int i=0;i<K;i++){
            long Y=(N-G)/A;
            if (Y<M){
                return (K-1-i)*M>N-G;
            }
            G+=Y;
        }
        if (G>N) return true;
        else return false;
    }
    public static void bin_search(){
        long l=1;
        long r=(long)Math.pow(10,12);
        long mid =(r+l)/2;
        while (l<r){
            if (Loan.check(mid)){
                l=mid+1;
            }else{
                r=mid-1;
            }
            mid=(r+l)/2;
        }
        X=mid;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("loan.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        Loan.bin_search();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        pw.print(X);
        pw.close();
    }
}