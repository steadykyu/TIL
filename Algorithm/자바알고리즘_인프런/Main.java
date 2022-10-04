import java.util.*;
public class Main {
    static int N, M;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L, int time, int point, int[] timeArr, int[] pointArr) {
        if(time > M) return;
        if(L == N){
            answer = Math.max(point,answer);
        }
        else{
            DFS(L+1, time + timeArr[L], point + pointArr[L],timeArr,pointArr);
            DFS(L+1, time,point,timeArr,pointArr);
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();       // 문제수
        M = kb.nextInt();       // 제한 시간
        int[] timeArray = new int[N];
        int[] pointArray = new int[N];

        for(int i=0; i<N;i++){
            pointArray[i] = kb.nextInt();
            timeArray[i] = kb.nextInt();
        }

        T.DFS(0,0,0,timeArray,pointArray);
        System.out.println(T.answer);
    }
}
