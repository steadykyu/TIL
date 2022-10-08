import java.util.*;
class Point{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Main {
    static int n, m,len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs,pz;
    // 조합구하기
    public void DFS(int L, int s) {
        if(L==m){
            for (int x: combi) {
                System.out.print(x+" ");
            }
            System.out.println();
        }else {
            for(int i=s; i < len;i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>(); // 피자 집
        hs = new ArrayList<>(); // 가정 집
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                int tmp = kb.nextInt();
                if(tmp == 1) hs.add(new Point(i,j));
                else if(tmp == 2) pz.add(new Point(i,j));
            }
        }
        len = pz.size();
        combi=new int[m];
        T.DFS(0,0); // pz list에 대하여 조합 경우의 수를 만든다.

    }
}
