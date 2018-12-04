package hw_13;

import java.io.IOException;

public class MatrixChainMultiplication {
	int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

	}

	public void MatrixChainOrder(int p[],int m[][],int s[][]){
		int n = p.length -1;
		for(int i = 0; i < n; i++){
			m[i][i] = 0;
		}
		for(int l = 1; l < n; l++){
			for(int i = 0; i < n-l+1; i++){
				int j = i + l -1;
				m[i][j] = MAX;
				for(int k = i; i < k-1; k++){
					int q = m[i][k] + m[k+1][k] + p[i-1]*p[k]*p[j];
					if(q<m[i][j]){
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
}

