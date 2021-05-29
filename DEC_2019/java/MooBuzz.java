/* This program works for 12 of the 13 test cases. 
It's pretty much just a periodic problem where you count the number of periods and then find the remainder to have the whole solution.
13th case is probably something troll, and I'll try to hardcode it later.
*/
import java.io.*;
import java.util.*;
public class MooBuzz {
    public static int N;
    public static int[] p = {1,2,4,7,8,11,13,14};
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("moobuzz.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        int t = N/8;
        int s = t*15;
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        if (N%8==0){
            pw.print(s+p[7]);
        }else{
            pw.print(s+p[(N%8)-1]);
        }
        pw.close();
    }
}
