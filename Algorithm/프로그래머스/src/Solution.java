
import java.util.HashMap;

class Solution {
    public int solution(int n) {

        int answer =0;

        // 제곱근까지의 약수 i
        for(int i=1; i<= Math.sqrt(n); i++){
            if(n % i ==0){
               answer += i + n/i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int num = 12;
        System.out.println(sol.solution(num));
    }
}
