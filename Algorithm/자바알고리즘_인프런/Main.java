import java.util.*;

public class Main {
    static int n;
    static int[] ch;

    public void DFS(int L){
        if(L==n+1){
            //종착지점 일때
            String tmp = "";
            for(int i=1; i<=n;i++){
                if(ch[i]==1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
            // 공집합 제외하고 출력한다.
        }
        else{
            ch[L] = 1;   // 부분집합으로 사용한다.
            DFS(L+1); // 왼쪽으로 뻗을떄
            ch[L] = 0;   // 부분집합으로 사용하지 않는다.
            DFS(L+1) ; // 오른쪽으로 뻗을때
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        n=3;
        ch=new int[n+1];
        T.DFS(1);
    }
}
