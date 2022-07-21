import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

class Solution {
    public int solution(int n) {
        String a = "";

        while(n > 0){
            a = a + (n % 3);
            n /= 3;
        }
        return Integer.parseInt(a,3);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.solution(45));


    }
}