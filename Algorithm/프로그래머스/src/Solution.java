import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int[] arr = new int[n];

        // 0~n-1 까지의 배열
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i * i <= n; i++) { // 나누는 값 i
            if (arr[i] == 0) continue;         // 0으로 초기화 된값은 배수값이므로 스킵
            for (int j = i + i; j <= n - 1; j += i) { // i를 제외한 i의 배수들은 모두 0으로 초기화
                arr[j] = 0;
            }
        }

        // 소수 세기
        int answer=0;
        for(int a : arr){
            if(a != 0 && a != 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.solution(10));
    }
}