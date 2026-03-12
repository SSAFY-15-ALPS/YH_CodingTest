import java.util.Arrays;
import java.util.Scanner;
 
// 햄스터
class Solution {
     
    static int N, X, M;
    static int[] arrCase, answer;
    static int[][] arrRecord;
    static int maxSum;
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
         
        // 테스트 케이스
        for(int tc = 1; tc <= T; tc++) {
             
            maxSum = -1;        //햄스터 최솟값
             
            N = sc.nextInt();   //우리 갯수
            X = sc.nextInt();   //한 우리에 들어갈 수 있는 최대 수
            M = sc.nextInt();   //기록 갯수
             
            arrCase = new int[N];       //우리 배열
            arrRecord = new int[M][3];  //기록 배열
            answer = new int[N];        //결과 배열
             
            for(int i=0; i<M; i++) {
                arrRecord[i][0] = sc.nextInt()-1;   //기록 시작 우리 (l) (배열은 0부터니까 1을 빼자)
                arrRecord[i][1] = sc.nextInt()-1;   //기록 마지막 우리 (r)
                arrRecord[i][2] = sc.nextInt();     //기록 구간 햄스터 총 수 (s)
            }
            // => 입력 끝
             
            dfs(0);
             
            // 결과 출력
            System.out.print("#" + tc + " ");
            if(maxSum == -1) {
                System.out.print(-1);
            }else {
                for(int i=0; i<N; i++) {
                    System.out.print(answer[i] + " ");
                }
            }
            System.out.println();
        }
         
    }
     
    static void dfs(int num) {
        if(num == N) {                   //num이 우리갯수와 일치한다면, (모든 우리에 햄스터 수를 배치했다면)
            for(int i=0; i<M; i++) {  //모든 기록 조건을 만족하는지 확인해보자
                int sumCheck = 0;       //기록과 비교할 합을 담을 변수
                int l = arrRecord[i][0];
                int r = arrRecord[i][1];
                int s = arrRecord[i][2];
                 
                for(int j=l; j<=r; j++) //구간 합 계산
                    sumCheck += arrCase[j];
                     
                if(sumCheck != s) return; //기록과 다르면 이 경우는 버림
            }
             
            // 여기까지 왔다는 것은 -> 배치한 햄스터가 모든 기록 조건을 만족한다는 것
            int sum = 0;
             
            // 모든 기록을 만족하면 햄스터 총합 계산
            for(int i=0; i<N; i++)
                sum += arrCase[i];
             
            // 최대 햄스터 수 갱신
            if(sum > maxSum) {
                maxSum = sum;
                answer = Arrays.copyOf(arrCase, N);
            }
            return;
        }
         
        // 각 우리에 들어갈 햄스터 수를 0~X까지 시도
        for(int i=0; i<=X; i++) {    //한 우리에 들어갈 수 있는 최대 수까지
            arrCase[num] = i;       //모든 경우의 수를 확인하자!
            dfs(num+1);
        }
         
    }
     
}