import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int studentCnt = sc.nextInt();
        int[][] arrStudent = new int [studentCnt][5];
        int maxCnt = -1;
        int imciNum = -1;
        
        for(int i=0; i<studentCnt; i++) {
        	for(int j=0; j<5; j++)
        		arrStudent[i][j] = sc.nextInt();
        }
        
        // 타겟 학생 순회
        for(int r=0; r<studentCnt; r++) {
        	int cnt = 0;
            // 비교 학생 순회
        	for(int i=0; i<studentCnt; i++) {
        		if(i == r) continue;
                // 학년별 비교
        		for(int c=0; c<5; c++) {
        			int targetStudent = arrStudent[r][c];
        			int compareStudent = arrStudent[i][c];
        			
        			if(targetStudent == compareStudent) {
        				cnt++;
        				break;
        			}
        		}
        	}
        	if(cnt > maxCnt) {        		
        		maxCnt = cnt;
        		imciNum = r;
        	}
        }
        System.out.println(imciNum + 1);
    }
}