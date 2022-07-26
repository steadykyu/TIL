import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int p = 0 ; p < commands.length; p++){
            // 1. i, j , k 읽어오기 ex) 2, 5, 3
            int i = commands[p][0];
            int j = commands[p][1];
            int k = commands[p][2];

            // 2. 배열 자르고 정렬하기 1 4
            int[] array2 = new int[j-i+1];
            for(int x = 0; x < array2.length; x++){
                array2[x] = array[x+i-1];
            }

            Arrays.sort(array2);

            // 3. k 번쨰 숫자 가져오고 answer에 넣어주기
            answer[p] = array2[k-1];
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] arr2 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        for(int t : sol.solution(arr,arr2)){
            System.out.printf(t +",");
        }

    }
}