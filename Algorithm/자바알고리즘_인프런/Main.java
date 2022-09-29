import java.util.*;
public class Main {
    static int N, lines, answer=0;
    static int[][] graph;
    static int[] ch;    // 접점 통과 유무를 나타냄
    public void DFS(int v){
        if(v==N) answer++;
        else {
            for(int i=1; i<=N; i++){
                if(graph[v][i]==1 && ch[i]==0){
                    // 간선이 존재하고 아직 지나오지 않은 정점일 때만 더 깊이 내려간다.
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0; // 재귀를 마치고 백한경우
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt(); // 접점의 수
        lines = kb.nextInt(); // 간선의 수
        graph = new int[N +1][lines+1];
        ch = new int[N +1];
        for(int i=0; i<lines;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        // 인접행렬 생성(a->b로 가는 방향 그래프)
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
