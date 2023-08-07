package ch04_multiFor_sorting;

public class InsertionSort {
    public static void printArray(int[] a){
        for(int i =0; i < a.length; i++){
            System.out.printf("[" + a[i]+ "]");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] a = {90, 34, 78, 12 ,56};
        int ins, cmp, temp;

        // 정렬 전의 배열 내용을 표시
        System.out.printf("정렬 전 배열\n");
        printArray(a);

        System.out.printf("\n");

        // 삽입정렬로 오름차순 정렬
        // ins : 삽입 되는 수의 idx, cmp 비교되는 수의 idx
        for(ins = 1; ins < a.length; ins++){
            temp = a[ins];
            for(cmp = ins-1; cmp >=0; cmp--){
                if(a[cmp] > temp){ // 현 idx 숫자가 삽입 숫자보다 더 크면
                    a[cmp+1] = a[cmp];
                }else {
                    break;
                }
            }
            // 내부 루프 카운터가 다 끝나거나 (@:삽입숫자가 맨앞으로 오는경우로 cmp(현재 idx 값)가 -1이 되어버린다.)
            // break문 (@:현 idx 숫자보다 삽입숫자가 더 큰 경우)
            // ---> 위의 두 경우 모두 어찌되었든 cmp + 1로 해결해줄 수 있다.
            a[cmp+1] = temp;
        }

        // 정렬 후의 배열 내용을 표시
        System.out.printf("정렬 후 배열\n");
        printArray(a);
    }
}
