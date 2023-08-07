package ch04_multiFor_sorting;

public class SelectionSortEx {
    public static void printArray(int[] a){
        for(int i =0; i < a.length; i++){
            System.out.printf("[" + a[i]+ "]");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] a = {90, 34, 78, 12 ,56};
        int ins, cmp, temp, minIdx;

        for(ins=0; ins<a.length; ins++){
            minIdx = ins;
            for(cmp=ins+1; cmp < a.length; cmp++){
                if(a[ins] > a[cmp]){
                    minIdx = cmp;
                    temp = a[ins];
                    a[ins] = a[minIdx];
                    a[minIdx] = temp;
                }
            }
        }

        System.out.println("정렬 후 배열");
        printArray(a);
    }
}
