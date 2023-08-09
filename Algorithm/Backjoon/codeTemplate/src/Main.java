import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int arr[] = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int money, max;
        // 같은 눈이 3개인 경우 :
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            money = 10000 + arr[0] * 1000;
        }// 같은 눈이 두개인 경우
        else if (arr[0] == arr[1] || arr[1] == arr[2]) {
            // 조건식속 두 경우 모두 arr[1]이 같은 눈이 된다!!
            money = 1000 + arr[1] * 100;
        }else if(arr[0] == arr[2]){ // 같은 눈이 두개인 예외 부분
            money = 1000 + arr[0] * 100;
        }else { // 같은 눈이 3개도 , 2개끼리도 없는 경우 -> 서로 다른 눈
            // 최대값 구하기
            max = Arrays.stream(arr).max().orElse(-1);
            money = max * 100;
        }
        System.out.println(money);
    }
}