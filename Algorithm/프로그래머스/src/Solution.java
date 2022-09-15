
import java.util.*;

import java.util.HashMap;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] remain_arr = new int[n+1];
        remain_arr[1] = 1; remain_arr[2] = 1; // 1번쨰, 2번쨰값은 1
        int divNum = 1234567;
        //1 1 2 3 58 13
        for(int i = 3; i <= n ; i++){
            remain_arr[i] = (remain_arr[i-2] % divNum + remain_arr[i-1] % divNum) % divNum;
        }
        answer = remain_arr[n];
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(100000));

    }

}
