import java.util.Arrays;
import java.util.Scanner;

// 1759. 암호 만들기
public class Main {
	
	static int L, C;
	static char[] list;
	static char[] code;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력값
		L = sc.nextInt();	//암호길이
		C = sc.nextInt();
		
		code = new char[L];
		list = new char[C];
		
		for(int i=0; i<C; i++)
			list[i] = sc.next().charAt(0);
		
		// 코드 뽑기
		Arrays.sort(list);
		setCode(0, 0);
	}
	
	// dfs
	static void setCode(int depth, int idx) {
		// 종료조건
		if(depth == L) {
			if(isValid()) {
				for(char c : code)
					System.out.print(c);
				System.out.println();
			}
			return;
		}
		// 선택
		for(int i=idx; i<C; i++) {
			code[depth] = list[i];
			setCode(depth+1, i+1);
		}
	}
	
	// 암호 유효성 검사
	static boolean isValid() {
		int za = 0;
		int mo = 0;
		
		for(char x : code) {
			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
				mo++;
			else
				za++;
		}
		
		if(za >= 2 && mo >= 1)
			return true;
		
		return false;
	}
	

}
