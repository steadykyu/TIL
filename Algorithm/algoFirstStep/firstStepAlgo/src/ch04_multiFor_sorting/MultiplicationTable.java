package ch04_multiFor_sorting;

public class MultiplicationTable {
    public static void main(String[] args) {
        int step, num;

        for(step = 1; step < 10; step++){
            System.out.printf("%d단", step);
            for(num =1; num < 10; num++){
                System.out.printf("\t%2d", step * num);
            }
            System.out.printf("\n");
        }
    }
}
