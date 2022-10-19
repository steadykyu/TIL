import java.util.*;

class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] dy = new int[m+1];
        for(int i=0; i<n; i++){
            int ps = kb.nextInt();
            int pt = kb.nextInt();
            // 배열을 뒤에서 부터 탐색하여 값을 넣어준다.
            for(int j=m; j>=pt; j--){
                dy[j]=Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);
    }
}
