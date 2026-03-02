import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int max = 0;
	static int[] arrCard;
	static int[] arrSelCard = new int[3];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arrCard = new int[N];
                
        for(int i=0; i<N; i++) {
        	arrCard[i] = sc.nextInt();
        }
        
        combination(0, 0);
        System.out.println(max);

    }
    
    // 조합: 재귀함수 메서드
    static void combination(int n, int num) {
    	int sum = 0;
    	if(num == 3) {
    		for(int i=0; i<3; i++)
    			sum += arrSelCard[i];
    		
    		if(sum <= M && sum > max)
    			max = sum;
    		
    		return;
    	}
    	if(n == N) {
    		return;
    	}
    	
    	arrSelCard[num] = arrCard[n];
    	
    	combination(n+1, num+1);
    	combination(n+1, num);
    }
}