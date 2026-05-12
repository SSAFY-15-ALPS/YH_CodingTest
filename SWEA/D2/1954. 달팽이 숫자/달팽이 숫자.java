import java.util.Scanner;

//달팽이 숫자 20260511
public class Solution {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int r = 0;	 //행
			int c = 0;	 //열
			int dir = 0; //방향인덱스
			
			for(int idx=1; idx<=N*N; idx++) { //idx: 해당 칸에 들어갈 숫자
				map[r][c] = idx;
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				// 방향 바꾸기
				if(nr>=N || nc>=N || nr<0 || nc<0 || map[nr][nc] != 0) 
					dir = (dir+1) % 4;
				
				r = r + dr[dir];
				c = c + dc[dir];
			}
			
			System.out.println("#" + tc);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) 
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
		}
		
	}//main
}
