import java.util.*;

class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
class Main {
    static int[] unf;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n =kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1];
        ArrayList<Edge> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i] = i;
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge(a,b,c));   // 각 간선 주입
        }
        int answer = 0; int cnt=0;
        Collections.sort(arr);
        for(Edge ob : arr){
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if(fv1 != fv2){
                answer += ob.cost;
                cnt++;
                if(cnt == n-1) break;
                Union(ob.v1,ob.v2);
            }
        }
        System.out.println(answer);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa]=fb;
    }

    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
}


