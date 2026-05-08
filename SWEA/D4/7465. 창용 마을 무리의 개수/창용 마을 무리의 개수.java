import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception 	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	//사람 수
			int M = sc.nextInt();	//관계 수
			
			graph = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			int groupCnt = 0;
			
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					dfs(i);
					groupCnt++;
				}
			}
			System.out.println("#" + tc + " " + groupCnt);
		}
	}
	
	static void dfs(int person) {
		visited[person] = true;
		
		for(int next : graph[person]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}