import java.util.*;
public class Main {
    static int[] pm;
    static int n, m;

    public void DFS(int L) {
        if(L == m){
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
           for(int i=1; i<=n; i++){
               pm[L]=i; // line 15
               DFS(L+1);    // DFS가 n번의 호출이 일어난다.
           }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();       // 문제수
        m = kb.nextInt();       // 제한 시간
        pm = new int[m];

        T.DFS(0);
    }
}
