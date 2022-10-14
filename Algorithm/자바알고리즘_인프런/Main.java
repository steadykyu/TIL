import java.util.*;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n =kb.nextInt();        // 도시의 수(정점의 수)
        int m = kb.nextInt();       // 도로의 수(간선의 수)

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n;i++){  // 일부로 idx 맞춤
            graph.add(new ArrayList<Edge>());
        }
        int[] ch = new int[n+1]; // check 배열
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c)); // a node -> bnode 갈때 비용 c
            graph.get(b).add(new Edge(a, c)); // a node -> bnode 갈때 비용 c
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));

        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex;   // endvertax
            if(ch[ev]==0){  // 회로 방지
                ch[ev] =1;
                answer += tmp.cost;
                for(Edge ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
