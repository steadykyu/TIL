class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int Big = Math.max(n,m);
        int sml = Math.min(n,m);

        while(true){

            int remain = Big % sml;

            if(remain == 0) {
              answer[0] = sml;
              answer[1] = n*m/sml;
                break;
            }else{
                Big = sml;
                sml = remain;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        for(int i : sol.solution(72,30)){
            System.out.printf(i + " ");
        }

    }
}
/**
 * https://myjamong.tistory.com/138
 * 유글리드 호제법
 */
