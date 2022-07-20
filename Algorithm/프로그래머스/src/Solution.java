class Solution {
    public String solution(String s, int n) {
        String answer = "";

        char[] charr = s.toCharArray();
        for(char ch : charr){
            for(int i=1; i <= n; i++){
                if(ch == 'z') ch = 'a';
                else if(ch == 'Z') ch = 'A';
                else if(ch == ' ') ch = ' ';
                else ch++;
            }
            answer += String.valueOf(ch);
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.solution("a B z",4));
    }
}