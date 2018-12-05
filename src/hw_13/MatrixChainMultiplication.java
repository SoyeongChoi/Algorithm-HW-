package hw_13;

import java.io.IOException;
import java.util.*;

public class MatrixChainMultiplication {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("입력행렬의 크기를 쓰세요.(0 이상)");
		int x = input.nextInt();
		if(x<=0){
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
		int p[] = new int[x];
		for(int i = 0; i < x; i++){
			System.out.print("A("+(i+1)+") = ");
			int temp = input.nextInt();
			p[i] = temp;
		}
		System.out.println();
		
		int m[][] = new int[x][x];
		int s[][] = new int[x][x];
		for(int i = 0; i < s.length; i++){
			Arrays.fill(s[i], -1);
			Arrays.fill(m[i], -1);
		}
		MatrixChainOrder(p,m,s);
	}

	public static void MatrixChainOrder(int p[],int m[][],int s[][]){
		int n = p.length;
		for(int i = 1; i < n; i++){
			m[i][i] = 0;
		}
		for(int l = 2; l < n; l++){
			for(int i = 1; i < n-l+1; i++){
				int j = i + l -1;
				m[i][j] = MAX;
				for(int k = i; k <= j-1; k++){
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(q<m[i][j]){
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		for(int i=1;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    			System.out.print(m[i][j]+"\t");
           System.out.println();
    	}
		 printOptimalParens(s,1,s.length-1);

	}
	
	public static void printOptimalParens(int[][]s, int i, int j){
		if(i == j){
			System.out.print("A"+i);
		}else{
			System.out.print("(");
			printOptimalParens(s,i,s[i][j]);
			printOptimalParens(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}
}

