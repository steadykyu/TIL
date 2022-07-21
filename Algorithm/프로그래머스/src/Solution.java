import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tolprice =0;
        for(int i=1; i<=count;i++){
            tolprice += price * i;
        }
        answer = Math.abs(tolprice - money);
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.solution(3,20,4));

    }
}