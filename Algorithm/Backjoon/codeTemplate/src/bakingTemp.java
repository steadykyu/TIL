class Test{
    int value;

    Test(int value) {
        this.value = value;
    }
}

public class bakingTemp {
    static void swap(int a1, int b1){
       int temp;
        temp = a1;
        a1 = b1;
        b1 = a1;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swap(a,b);
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
    }
}