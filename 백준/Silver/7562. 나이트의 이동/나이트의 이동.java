import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 7562. 나이트의 이동
public class Main {
	
	static class Pos{
		int r, c;
		
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		
		int[] dr = {1,1,-1,-1,2,2,-2,-2};
		int[] dc = {2,-2,2,-2,1,-1,1,-1};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int I = sc.nextInt();	//체스판 한변의 길이
			int cr = sc.nextInt();	//현재위치(행)
			int cc = sc.nextInt();	//현재위치(열)
			int tr = sc.nextInt();	//목표위치(행)
			int tc = sc.nextInt();	//목표위치(열)
			
			int[][] map = new int[I][I];	//체스판
			boolean[][] visited = new boolean[I][I];	//방문체크
			
			Queue<Pos> q = new ArrayDeque<Pos>();
			q.add(new Pos(cr, cc));
			visited[cr][cc] = true;
			
			// bfs
			while(!q.isEmpty()) {

				Pos p = q.poll();
				int r = p.r;	//현재위치
				int c = p.c;	//현재위치
				
				// 목표점 도착
				if(r == tr && c == tc) {
					break;
				}
				
				for(int d=0; d<8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nc>=0 && nr<I && nc<I) {
						if(!visited[nr][nc]) {
							q.add(new Pos(nr, nc));
							map[nr][nc] = map[r][c] + 1;
							visited[nr][nc] = true;
						}
					}
				}
			}
			
			//출력
			System.out.println(map[tr][tc]);
		}
	}

}
