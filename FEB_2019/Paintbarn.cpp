#include <iostream>
using namespace std;
int dp[1001][1001];
int N, K;
int main(){
    freopen("paintbarn.in","r",stdin);
    freopen("paintbarn.out","w",stdout);
    cin >> N >> K;
    for (int i=0;i<N;i++){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        dp[x1][y1]++;
        dp[x1][y2]--;
        dp[x2][y1]--;
        dp[x2][y2]++;
    }
    int area = 1;
    for (int i=0;i<1001;i++){
        for (int j=0;j<1001;j++){
            if ((i==0)&&(j==0)) continue;
            else if (i==0) dp[0][j]+=dp[0][j-1];
            else if (j==0) dp[i][0]+=dp[i-1][0];
            else{
                dp[i][j]+=(dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]);
            }
            if (dp[i][j]==K) {area++;}
        }
    }
    cout << area;
}