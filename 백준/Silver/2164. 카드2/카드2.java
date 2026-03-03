import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 카드저장 Queue
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=num; i++)
			q.offer(i);
		
		// 첫번째 요소 버리고, 두번째 요소 뒤로
		while(q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		// 결과출력
		System.out.println(q.poll());
	}
}