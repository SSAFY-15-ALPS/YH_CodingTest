package etc;

import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][M];
			int result = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 입력 끝
			
			// 완전탐색
			for(int si=0; si<N; si++) {
				for(int sj=0; sj<M; sj++) {
					
					for(int ei=si; ei<N; ei++) {
						for(int ej=sj; ej<M; ej++) {
							// 직사각형 합
							int sum = 0;
							sumFor:
							for(int i=si; i<=ei; i++) {
								for(int j=sj; j<=ej; j++) {
									sum += map[i][j];
									
									if(sum > 10) 
										break sumFor;
								}
							}
							if(sum == 10) {
								result++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
}
