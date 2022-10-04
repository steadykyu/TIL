## 문제

<img src ="https://github.com/steadykyu/TIL/blob/master/Algorithm/%EC%9E%90%EB%B0%94%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EC%9D%B8%ED%94%84%EB%9F%B0/7.%20Recursive%2C%20Tree%2C%20Graph(DFS%2C%20BFS%20%EA%B8%B0%EC%B4%88)/img/7_13_2.png" width="50%" height="50%">

> 출력 결과

2부터 6까지 차례로 최단거리를 출력하시오.

> 입력 예제
```
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
```
> 출력 예제
```
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
```

## 설명


<img src ="https://github.com/steadykyu/TIL/blob/master/Algorithm/%EC%9E%90%EB%B0%94%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EC%9D%B8%ED%94%84%EB%9F%B0/7.%20Recursive%2C%20Tree%2C%20Graph(DFS%2C%20BFS%20%EA%B8%B0%EC%B4%88)/img/7_13_3.jpg" width="50%" height="50%">

L(level)을 사용하지 않고, 인접리스트와 이전의 최소거리를 이용하여 다음 정점의 최소거리를 구하는 로직으로 문제를 해결 할수 있다.

0. 최단 거리를 구하기 위해서 Queue를 이용한 BFS를 진행한다.

1. 다음 정점까지의 최소거리는 현재까지 최소거리의 +1이다.
    + 정점1 -> 정점3,4 일때 거리는 0+1 = 1
    + 정점4 -> 정점5,6 일떄 거리는 1+1 = 2

2. 인접리스트를 활용하여 현재 vertex(cv)에서 인접한 다음 vertex(nv)를 구해준다. nv를 이용하여 dis 배열에 최소거리를 구해서 넣고, ch 배열에는 지나갔다는 표시로 1을 넣어준다.

지금은 일차원 배열의 특성을 이용하여 값을 구하고 저장했기에 L(level)을 사용할때와의 차이점을 느끼지 못할 것이다. 그러나 이후 이차원 배열을 이용한 문제들이 나오므로 기억해두자.
## 구현

```java
import java.util.*;
public class Main {
    static int N, lines;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;    // 접점 통과 유무를 나타냄
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1; // 출발지점
        dis[v] = 0;// 출발지점이므로 거리 0
        queue.offer(v);
        while(!queue.isEmpty()){
            int cv=queue.poll();    // current vertex
            for(int nv : graph.get(cv)){   // next vertex
                if(ch[nv]==0){      // 한번도 안지난 정점인지 판별
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv] = dis[cv]+1; 
                }
            }
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
        // 인접리스트 생성
        for(int i=0; i<lines;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<=N; i++){
            System.out.println(i + " : "+ dis[i]);
        }
    }
}
```

> dis[nv] = dis[cv]+1;

이전 정점까지 최소거리에서 1을 더해준다.