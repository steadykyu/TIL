import java.util.*;
public class Main {
    static int N, lines;
    int L=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;    // 접점 통과 유무를 나타냄
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0; i<len; i++){
                int cv=queue.poll();    // current vertex
                for(int nv : graph.get(cv)){   // next vertex
                    if(ch[nv]==0){      // 한번도 안지난 정점인지 판별
                        ch[nv]=1;
                        queue.offer(nv);
                        dis[nv] = L+1;
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();       // 접점의 수
        lines = kb.nextInt();   // 간선의 수
        // 간선정보 넣어주기
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[N+1];
        dis = new int[N+1];
        for(int i=0; i<lines;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1; // 출발지점
        T.BFS(1);
        for(int i=2; i<=N; i++){
            System.out.println(i + " : "+ dis[i]);
        }
    }
}
