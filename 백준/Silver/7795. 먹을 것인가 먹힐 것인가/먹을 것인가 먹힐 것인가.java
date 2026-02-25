import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for(int tc=0; tc<T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int[] arrA = new int[A];
            int[] arrB = new int[B];
            
            for(int i=0; i<A; i++)
            	arrA[i] = sc.nextInt();
            
            for(int i=0; i<B; i++)
            	arrB[i] = sc.nextInt();
            
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            
            int leftA = arrA.length-1;
            int leftB = arrB.length-1;
            int cnt = 0;
            
            while(leftA >= 0 && leftB >= 0) {
            	if(arrA[leftA] > arrB[leftB]) {
            		cnt += leftB+1;
            		leftA--;
            	} else {
            		leftB--;
            	}
            }
            System.out.println(cnt);
        }
    }
}