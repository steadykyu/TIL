
import java.util.HashMap;
import java.util.Stack;

class Point{
    int row; int col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
    // 두 point 의 거리를 구하는 method
    public int distance(Point p){
        if (p != null){
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
        else System.out.println("null이 들어왔습니다."); return -12345;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        char[][] dial = new char[4][3];
        HashMap<Character,Point> hm = new HashMap<>();
        String dial_str = "123456789*0#";

        // 각 번호에 해당하는 i,j를 저장하는 Point(i,j)
        // 이를 value로 가지는 HashMap<다이얼, 좌표>
        int k =0;
        for(int i=0; i < dial.length; i++){
            for(int j=0; j< dial[1].length; j++){
                dial[i][j] = dial_str.toCharArray()[k++];
                hm.put(dial[i][j],new Point(i,j));
            }
        }
//        // HashMap 확인
//        for (char ch : dial_str.toCharArray()){
//            System.out.println(ch + " / "+ hm.get(ch).row + " / " + hm.get(ch).col);
//        }
        // 첫 위치
        Point left = hm.get('*');
        Point right = hm.get('#');

        char charNum ='0';
        // numbers에서 하나씩 값이 들어온다.
        for(int num : numbers){
            charNum = Character.forDigit(num,10);
            if(charNum == '1' || charNum =='4' || charNum =='7'){
                answer += "L";
                left = hm.get(charNum);
                System.out.println(left.row);
            }
            else if(charNum == '3' || charNum =='6' || charNum =='9'){
                answer += "R";
                right = hm.get(charNum);
            }
            else if(num == '2' || num == '5' || num =='8' || num =='0'){
//                // 왼손이 더 가까울 때
//                if(left.distance(hm.get(num)) < right.distance(hm.get(num))) {
//                    answer+="L";
//                    left = hm.get(num);
//                }
//                else if(left.distance(hm.get(num)) > right.distance(hm.get(num))){
//                    answer += "R";
//                    right = hm.get(num);
//                } //같을때는 어느 손잡인지에 따라 다르다.
//                else {
//                    if (hand.equals("left")) {
//                        answer += "L";
//                        left = hm.get(num);
//                    } else {
//                        answer += "R";
//                        right = hm.get(num);
//                    }
//                }
            }else return "입력문제";
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] numbers = {1};
        //1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
        String str = "right";
        System.out.println(sol.solution(numbers, str));
    }
}

/*
             else{
                  // 왼손이 더 가까울 때
                  if(left.distance(hm.get(num)) <= right.distance(hm.get(num))) {
                      answer+="L";
                      left = hm.get(num);
                  }
                  else if(left.distance(hm.get(num)) > right.distance(hm.get(num))){
                      answer += "R";
                      right = hm.get(num);
                  } //같을때는 어느 손잡인지에 따라 다르다.
                  else{
                      if(hand.equals("left")) {
                          answer+="L";
                          left = hm.get(num);
                      }
                      else{
                          answer += "R";
                          right = hm.get(num);
                      }
                  }
*/