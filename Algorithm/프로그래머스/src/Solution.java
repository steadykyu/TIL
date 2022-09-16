
import java.util.*;

import java.util.HashMap;

class Solution {
    public boolean isDiv(int n, int y){
        boolean isDiv = true;
        if(y % n != 0) isDiv = false;
        return isDiv;
    }

    public int[] solution(int y, int b) {
        int[] answer = new int[2];
        int tmp_b = 0;
        for(int i=1; i * i <= y ; i ++){
            if(isDiv(i,y)){
                if(b == (i+2) * (y/i +2) - y) {
                    answer[0] = y/i+2; answer[1] = i+2;
                };
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int y = 4; int b = 12;
        for(int x : sol.solution(y, b)){
            System.out.println(x);
        }

    }

}
