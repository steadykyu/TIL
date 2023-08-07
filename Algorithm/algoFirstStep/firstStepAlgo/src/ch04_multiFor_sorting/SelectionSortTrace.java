package ch04_multiFor_sorting;

public class SelectionSortTrace {
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
            System.out.printf("외부 반복문: %d회\n", ins+1);
            min = ins; // 맨 앞 요소
            for(cmp=ins+1; cmp < a.length; cmp++){
                if(a[cmp] < a[ins]){
                    min = cmp; // cmp 위치일때 현재 요소들중 최소값을 가진다.
                    temp = a[ins];
                    a[ins] = a[min];
                    a[min] = temp;
                    // 배열 요소의 현재 최솟값 및 변경된 중간 정렬 결과 확인
                    System.out.printf("배열 요소의 현재 최솟값: a[%d] = %d\n",
                            ins, a[ins]);
                    printArray(a);
                }
                // 내부 반복문 1회 실행 후 중간 정렬 결과 내용을 표시
                System.out.printf("내부 반복문: ins = %d, cmp = %d, a[%d] = %d\n",
                        ins, cmp, cmp, a[cmp]);
                printArray(a);
            }
            System.out.printf("외부 반복문: ins = %d, cmp = %d, a[%d] = %d\n",
                    ins, cmp, ins, a[ins]);
            System.out.printf("외부 반복문: 확정된 정렬 위치 = a[%d] <- %d\n", ins, a[ins]);

            // 정렬 중간 결과 내용을 표시
            printArray(a);
            System.out.printf("\n");
        }
        System.out.printf("외부 반복문: 확정된 정렬 위치 = a[%d] <- %d\n\n", a.length-1, a[a.length-1]);
        System.out.println("정렬 후 배열\n");
        printArray(a);
    }
}
