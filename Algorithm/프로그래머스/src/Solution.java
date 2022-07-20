import java.util.Arrays;

class Solution {
    public String solution(String s) {

        return "";
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        String str = "boo:and:foooo";
        String[] strarr = str.split("o",-2);

        for(String s : strarr){
            System.out.println(s);
        }
        System.out.println("종료");
    }
}