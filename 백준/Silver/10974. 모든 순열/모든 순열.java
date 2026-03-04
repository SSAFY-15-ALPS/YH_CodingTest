import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] arrResult;
	static boolean[] arrVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		arrResult = new int[N];
		arrVisited = new boolean[N];
		
		for(int i=0; i<N; i++)
			arr[i] = i+1;
		
		permutation(0);
	}
	
	// 수열 메서드
	static void permutation(int idx) {
		StringBuffer sb = new StringBuffer();
		if(idx == N) {
			for(int a : arrResult)
				sb.append(a).append(" ");
			System.out.println(sb);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(arrVisited[i]) continue;
			arrResult[idx] = arr[i];
			arrVisited[i] = true;
			permutation(idx + 1);
			arrVisited[i] = false;
		}
	}
}