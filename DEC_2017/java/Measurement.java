import java.io.*;
import java.util.*;
public class Measurement {
    public static int N;
    public static int G;
    public static ArrayList<Integer> ind=new ArrayList<Integer>();
    public static ArrayList<Integer> m= new ArrayList<Integer>();
    public static Change[] me;
    static class Change implements Comparable<Change>{
        public static int t;
        public static int id;
        public static int c;
        public Change(int _t, int _id, int _c){
            t=_t;
            id=_id;
            c=_c;
        }
        public int compareTo(Change n){
            return Integer.compare(t, n.t);
        }
    }
    public static boolean checkLists(ArrayList<Integer> a, ArrayList<Integer> b){
        for (int i=0;i<a.size();i++){
            boolean x=false;
            for (int j=0;j<a.size();j++){
                if (a.get(i)==b.get(j)){
                    x=true;
                }
            }
            if (!x){
                return false;
            }
        }
        return true;
    }
    public static int find(int i){
        for (int j=0;j<ind.size();j++){
            if (ind.get(j)==i){
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        me = new Change[N];
        ind.add(-1);
        m.add(G);
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            me[i] = new Change(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        r.close();
        Arrays.sort(me);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int changes = 0;
        for (int i=0;i<N;i++){
            int store = Measurement.find(me[i].id);
            if (store==-1){
                ind.add(me[i].id);
                m.add(me[i].c+G);
            }else{
                m.set(store, m.get(store)+me[i].c);
            }
            System.out.println(ind);
            int max=0;
            ArrayList<Integer> sol = new ArrayList<Integer>();
            for (int j=0;j<m.size();j++){
                if (m.get(j)>max){
                    max=m.get(j);
                    sol.clear();
                    sol.add(ind.get(j));
                }else if (m.get(j)==max){
                    sol.add(ind.get(j));
                }
            }
            if (temp.size()!=sol.size()){
                changes++;
            }else{
                if (!Measurement.checkLists(sol, temp)){
                    changes++;
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        System.out.print(changes);
        pw.close();
    } 
}
