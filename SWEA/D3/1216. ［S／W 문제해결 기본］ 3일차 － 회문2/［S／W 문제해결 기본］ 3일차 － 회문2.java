import java.util.Scanner;

// 회문2 20260513
public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			
            int testNum = sc.nextInt(); sc.nextLine();
            char[][] map = new char[100][100];
            
            for(int i=0; i<100; i++) {
            	String str = sc.next();
            	for(int j=0; j<100; j++) 
            		map[i][j] = str.charAt(j);
            }
            
            int result = 1;
            
            // 회문 검사
            outer:
            for(int len=100; len >=1; len--) {
            	// 가로검사
            	for(int i=0; i<100; i++) {
            		for(int j=0; j<=100-len; j++) {
            			boolean isPal = true;
            			// 회문 검사
            			for(int k=0; k<len/2; k++) {
            				if(map[i][j+k] != map[i][j+len-1-k]) {
            					isPal = false;
            					break;
            				}
            			}
            			if(isPal) {
            				result = len;
            				break outer;
            			}
            		}
            	}
            	
            	// 세로검사
            	for(int j=0; j<100; j++) {
            		for(int i=0; i<=100-len; i++) {
            			boolean isPal = true;
            			// 회문 검사
            			for(int k=0; k<len/2; k++) {
            				if(map[i+k][j] != map[i+len-1-k][j]) {
            					isPal = false;
            					break;
            				}
            			}
            			if(isPal) {
            				if(result < len)
            					result = len;
            				break outer;
            			}
            		}
            	}
            	
            }
            
            System.out.printf("#%d %d\n", testNum, result);
		}
		
	}//main
}
