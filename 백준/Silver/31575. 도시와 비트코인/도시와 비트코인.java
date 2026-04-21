import java.util.Scanner;

public class Main {
	static int[] dr = {0, 1};	//남쪽
	static int[] dc = {1, 0};	//동쪽
	
	static int M,N;
	static int[][] map;
	static boolean[][] visited;
	static boolean canGo = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력값
		N = sc.nextInt();	//가로크기
		M = sc.nextInt();	//세로크기
		map = new int[M+2][N+2];	//범위외 => 0
		visited = new boolean[M+2][N+2];
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(1,1);
		String result = canGo ? "Yes" : "No";
		System.out.println(result);
	}
	
	// DFS
	static void dfs(int r, int c) {
		if(r == M && c == N) {	//거래소도착
			canGo = true;
			return;
		}
		
		for(int i=0; i<2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(map[nr][nc] == 0 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
		return;
	}

}
