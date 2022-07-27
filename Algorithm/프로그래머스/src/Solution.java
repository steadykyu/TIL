
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        String str = "one4seveneight";
        System.out.println(sol.solution(str));
    }
}
