package ch03_BinarySearch_timeComplex;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
        int x, pos, left, right, middle;
        x = scn.nextInt();
        pos = -1;
        left = 0;
        right = a.length-1;

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
        }

        System.out.printf("pos = %d\n", pos);
    }
}
