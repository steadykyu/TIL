package ch03_BinarySearch_timeComplex;

import java.util.Scanner;

public class BinarySearchTrace {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        int[] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
        int[] a = {39, 50};
        int x, pos, left, right, middle;
        x = scn.nextInt();
        pos = -1;
        left = 0;
        right = a.length-1;
        System.out.printf("반복 실행 전: x = %d\n", x);
        System.out.printf("반복 실행 전: pos = %d, left = %d, middle = ?, right = %d\n", pos, left, right);

        // 조건만 지정하면 되므로, 루프 카운터가 필요하지 않다.
        while(pos == -1 && left <= right){
            middle = (left + right) / 2;
            if(a[middle] == x){
                pos = middle;
            }else if(a[middle] > x){
                right = middle-1;
            }else{
                left = middle+1;
            }

            System.out.printf("반복 실행 중: pos = %d, left = %d, middle = %d, right = %d\n", pos, left,  middle, right);
        }

        System.out.printf("pos = %d\n", pos);
    }
}
