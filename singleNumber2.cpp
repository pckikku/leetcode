#include<iostream>

using namespace std;

int singleNumber(int A[], int n){
	int ret = 0;
	for (int i = 0; i < n; i++){
		ret ^= A[i];
	}

	return 0;
}