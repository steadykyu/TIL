package ch01;
import java.util.Scanner;

public class Euclid {
    // 유클리드 호제법을 이용한 최대공약수 찾기
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a,b;

        a = scn.nextInt();
        b = scn.nextInt();
        scn.close();

        while(a != b){
            if(a > b){
                a = a-b;
            }else {
                b = b-a;
            }
        }

        System.out.printf("%d\n", a);
    }
}
