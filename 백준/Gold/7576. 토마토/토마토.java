import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int M, N;
	static int[][] arrBox;
	static boolean[][] arrCheckTomato;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int days = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력값
		M = sc.nextInt();	//가로칸수
		N = sc.nextInt();	//세로칸수
		arrBox = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M ;j++) {
				arrBox[i][j] = sc.nextInt();
				// 익은 토마토 q에 추가
				if(arrBox[i][j] == 1) {
					q.add(new int[]{i, j});
				}
			}
		}
		System.out.println(bfs());
	}
	
	// bfs
	static int bfs() {
		// 익은 토마토 전부 poll 될 때 까지
		while(!q.isEmpty()) {
			int[] redTomato  = q.poll();	//익은 토마토 위치
			int redTomato_x = redTomato[0];
			int redTomato_y = redTomato[1];
			
			for(int i=0; i<4; i++) {
				int nx = redTomato_x + dx[i];
				int ny = redTomato_y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(arrBox[nx][ny] == 0) {
					q.add(new int[]{nx, ny});
					arrBox[nx][ny] = arrBox[redTomato_x][redTomato_y] + 1;
				}
			}
		}
		
		if(isAllRed())
			return days-1;
		
		return -1;
	}
	
	// 모든 토마토가 익었는지 확인 + 최대값(날짜)
	static boolean isAllRed() {
		boolean isAllRed = false;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arrBox[i][j] == 0) {
					return false;
				}
				days = Math.max(days, arrBox[i][j]);
			}
		}
		return true;
	}

}
