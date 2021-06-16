#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Interval{
    public:
        int x;
        int i;
};
int N, K;
vector<Interval > pi;
bool sorts(Interval &a, Interval &b){
    return (a.x<b.x);
}
int main(){
    freopen("paint.in","r",stdin);
    freopen("paint.out","w",stdout);
    cin >> N >> K;
    int pos = 0;
    for (int i=0;i<N;i++){
        Interval store;
        Interval store2;
        int m;
        char C;
        cin >> m >> C;
        if (C=='R') {store.x=pos; store.i=1; pi.push_back(store); store2.x=pos+m;store2.i=-1;pi.push_back(store2);pos+=m;}
        else {store.x=pos; store.i=-1; pi.push_back(store); store2.x=pos-m;store2.i=1;pi.push_back(store2);pos-=m;}
    }

    sort(pi.begin(),pi.end(),sorts);
    int layers = 0;
    int area = 0;
    for (int i=0;i<pi.size();i++){
        if (layers>=K){
            if (i==0) continue;
            else {
                area+=pi[i].x-pi[i-1].x;
            }
        }
        layers+=pi[i].i;
    }
    cout << area;
}