
import java.util.*;

import java.util.HashMap;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        // index를 의미
        int l = 0, r = people.length-1;

        while(l < r){
            if(people[l] + people[r] > limit) {r--; answer++;} // 혼자 배를 탄 경우
            else {l++;r--;answer++;} //함께 배를 탄 경우

            if(l == r) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {70, 50, 80, 50};
        System.out.println(sol.solution(arr, 100));
    }

}
