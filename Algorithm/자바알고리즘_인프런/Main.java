import java.util.*;
public class Main {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r]; // 행렬안에 값이 존재하면, 그 값을 그대로 가져온다.
        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();

        System.out.println(T.DFS(n, r));
    }
}
