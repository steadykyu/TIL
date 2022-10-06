import java.util.*;
public class Main {
    static int n,f;
    boolean flag = false;
    static int[] b, p, ch;
    // 조합수 구하는 메서드
    int[][] dy = new int[35][35];
    public int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        // b배열 구하기
        if(n == r || r==0) return 1;
        else{
            return dy[n][r] = combi(n-1,r) + combi(n-1,r-1);
        }
    }
// 순열 구하기
    public void DFS(int L, int sum){
        if(flag) return; // 원하는 값을 발견했을떄, 이후 남은 스택들을 모두 처리하기 위해 작성
        if(L==n){
            if(sum == f) {
                for(int x : p){System.out.print(x + " ");}
                flag = true;
            }

        }else{
            for(int i=1; i <=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1, sum + (p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();

        b = new int[n];
        p = new int[n];
        ch = new int[n+1];  // index 번호가 아닌 1~N의 값 자체로 사용할 것이다.. 자체가 필요하므로
        for(int i =0; i< n; i++){
            b[i] = T.combi(n-1 , i);
        }
        T.DFS(0,0);
    }
}
