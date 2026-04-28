// 4963. 섬의 개수

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			//종료조건
			if(w==0 && h==0) break;	
			
			int[][] map = new int[h][w];
			
			int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};
			int cnt = 0; // 섬 개수
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++)
					map[i][j] = sc.nextInt();
			}
			
			// 1: 땅, 0: 바다
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					Queue<int[]> q = new ArrayDeque<int[]>();
					
					if(map[i][j] == 1) {
						q.add(new int[] {i, j});
						map[i][j] = 0;
						cnt++;
					}
					
					while(!q.isEmpty()) {
						int[] p = q.poll();
						int r = p[0];
						int c = p[1];
						
						for(int d=0; d<8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr<0 || nc<0 || nr>=h || nc>=w)
								continue;
							if(map[nr][nc] == 0)
								continue;
							
							map[nr][nc] = 0;
							q.add(new int[]{nr, nc}); //q.add()
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
