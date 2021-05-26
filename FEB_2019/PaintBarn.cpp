#include <iostream>
#include <cstdio>
using namespace std;
int barn[1001][1001];
int K,N;
int main() {
	freopen("paintbarn.in","r",stdin);
	freopen("paintbarn.out","w",stdout);
	cin >> N >> K;
	for (int i=0;i<N;i++){
		int x1,y1,x2,y2;
		cin >> x1 >> y1 >> x2 >> y2;
		barn[x1][y1]++;
		barn[x1][y2]--;
		barn[x2][y1]--;
		barn[x2][y2]++;
	}
	for (int i=1;i<1001;i++){
		barn[i][0]+=barn[i-1][0];
		barn[0][i]+=barn[0][i-1];
	}
	int count=0;
	for (int i=1;i<1001;i++){
		for (int j=1;j<1001;j++){
			barn[i][j]+=(barn[i-1][j]+barn[i][j-1]-barn[i-1][j-1]);
			if (barn[i][j]==K){
				count++;
			}
		}
	}
	cout << count;

}
