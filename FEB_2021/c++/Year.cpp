#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
vector<int> y;
int main(){
    int N, K;
    cin >> N >> K;
    for (int i=0;i<N;i++){
        int store;
        cin >> store;
        y.push_back((store/12)*12);
    }
    sort(y.begin(),y.end());
    int d[N];
    for (int i=0;i<N-1;i++){
        d[i]=(y[i+1]-y[i]); 
    }
    cout << endl;
    for (int i=0;i<N-1;i++){
        cout << d[i] << " ";
    }
    cout << endl;
    sort(d,d+N-1);
    int min = pow(10,9);
    for (int j=2;j<=K;j++){
        int year = 0;
        year += 12*(N-j+1);
        for (int i=0;i<N-j+1;i++){
            year+=d[i];
        }
        if (year<min){
            min=year;
        }
    }
    cout << min;
}