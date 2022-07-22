import java.util.ArrayList;
import java.util.List;


class Solution {

    public int[] solution(int[] answers) {
        int len = answers.length;
        int[] p1 = new int[answers.length];
        int[] p2 = new int[answers.length];
        int[] p3 = new int[answers.length];

        int k=0; int[] p2arr = {1,3,4,5};
        int[] p3arr = {3,3,1,1,2,2,4,4,5,5};int k3 = 0;

        // 값 대입
        for(int i = 0; i < len; i++){
            //p1
            p1[i] = i % 5 + 1;
            // p2
            if((i+1) % 2==0) {
                p2[i] = p2arr[k];
                k++;
                k = k % 4; // 0~3
            }else p2[i] = 2;
            //p3
            p3[i] = p3arr[k3];
            k3++;
            k3 %= 10; // 0~9
        }
//        for(int x : p3){
//            System.out.printf(x+" ");
//        }

        // 정답개수 세기
        int[] cntarr = {0,0,0,0};
        for (int i = 0; i < len; i++) {
            if (answers[i] == p1[i]) cntarr[1]++;
            if (answers[i] == p2[i]) cntarr[2]++;
            if (answers[i] == p3[i]) cntarr[3]++;
        }

        int max = Math.max(Math.max(cntarr[1],cntarr[2]),cntarr[3]);
        // 결과 출력
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int x=1; x<cntarr.length ; x++){
            if( cntarr[x] == max) al.add(x);
        }
        int[] answer = al.stream().mapToInt(x -> x.intValue()).toArray();
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        for(int x : sol.solution(arr)){
            System.out.println(x);
        }

    }
}