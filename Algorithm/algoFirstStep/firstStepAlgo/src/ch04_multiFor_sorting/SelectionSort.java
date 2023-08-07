package ch04_multiFor_sorting;

public class SelectionSort {
    public static void printArray(int[] a){
        for(int i =0; i < a.length; i++){
            System.out.printf("[" + a[i]+ "]");
        }
        System.out.printf("\n");
    }
    public static void main(String[] args) {
        int a[] = {90, 34, 78, 12, 56};
        int ins, cmp, temp, min;

        for(ins=0; ins < a.length -1; ins++){
            min = ins; // 맨 앞 요소
            for(cmp=ins+1; cmp < a.length; cmp++){
                if(a[cmp] < a[ins]){
                    min = cmp; // cmp 위치일떄 최소임을 알 수 있다.
                    temp = a[ins];
                    a[ins] = a[min];
                    a[min] = temp;
                }
            }
        }
        System.out.println("정렬 후 배열\n");
        printArray(a);
    }
}
