#include <bits/stdc++.h>
using namespace std;
class Point{
    public:
        int x,y;
};
vector<Point> g;
bool sortx(Point &a, Point &b){
    return a.x<b.x;
}
int N;
int main(){
    freopen("moop.in","r",stdin);
    freopen("moop.out","w",stdout);
    cin >> N;
    for (int i=0;i<N;i++){
        Point store;
        int x,y;
        cin >> x >> y;
        store.x=x; store.y=y;
        g.push_back(store);
    }
    sort(g.begin(),g.end(),sortx);
    vector<int> ys;
    for (int i=N-1;i>=0;i--){
        if (ys.size()==0) ys.push_back(g[i].y);
        else{
            int a = 0;
            int b = ys.size();
            while (a!=b){
                int mid = (a+b)/2;
                if (ys[mid]>)
            }
        }
    }
    cout << ys.size();
}