package ch04_multiFor_sorting;

public class BubbleSort {
    public static void printArray(int[] a){
        for(int i =0; i < a.length; i++){
            System.out.printf("[" + a[i]+ "]");
        }
        System.out.printf("\n");
    }
    public static void main(String[] args) {
        int a[] = {90, 34, 78, 12, 56};
        int ins, cmp, temp;

        for(ins = 0; ins < a.length-1; ins++){
            for(cmp = 0; cmp < a.length-ins-1; cmp++){
                if(a[cmp] > a[cmp+1]){
                    temp = a[cmp];
                    a[cmp] = a[cmp+1];
                    a[cmp+1] = temp;
                }
            }
        }
        System.out.println("정렬 후 배열\n");
        printArray(a);
    }
}
