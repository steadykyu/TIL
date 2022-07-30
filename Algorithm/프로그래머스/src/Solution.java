
import java.util.HashMap;

class Solution {
        public String solution(String new_id) {
            String answer = "";
            String temp = new_id.toLowerCase(); // 1 단계

            temp = temp.replaceAll("[^-_.a-z0-9]","");      // 2단계
            System.out.println(temp);
            temp = temp.replaceAll("[.]{2,}",".");  // 3단계
            temp = temp.replaceAll("^[.]|[.]$",""); // 4단계
            System.out.println(temp.length());
            // 5단계
            if(temp.equals(""))
                temp+="a";
            if(temp.length() >=16){
                temp = temp.substring(0,15);
                temp=temp.replaceAll("^[.]|[.]$","");
            }
            if(temp.length()<=2)
                while(temp.length()<3)
                    temp+=temp.charAt(temp.length()-1);

            answer=temp;
            return answer;
        }

    public static void main(String[] args) {

        Solution sol = new Solution();
        String str = "=.=";
        System.out.println(sol.solution(str));
    }
}
