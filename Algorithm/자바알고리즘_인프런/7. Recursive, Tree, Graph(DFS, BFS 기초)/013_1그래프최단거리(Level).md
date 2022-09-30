## 문제

<img src ="https://github.com/steadykyu/TIL/blob/master/Algorithm/%EC%9E%90%EB%B0%94%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EC%9D%B8%ED%94%84%EB%9F%B0/7.%20Recursive%2C%20Tree%2C%20Graph(DFS%2C%20BFS%20%EA%B8%B0%EC%B4%88)/img/7_13_1.png" width="50%" height="50%">

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

1. BFS를 작업하면서 생기는 L의 값을 그때그떄 dis 배열에 저장해준다.

2. 한 노드에서 다른 노드로 움직이는 작업은 인접리스트를 사용하여 구현해주자.

3. Queue를 이용하여 BFS를 진행하자. 탐색하며 발생하는 L의 값을 조건을 만족하면 dis 배열에 저장해준다.
    + 조건 : 인접리스트 속 요소이며, 해당점을 지난 적이 없다.(ch[nv]==0)

## 구현

```java
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
```

> L값 구하기
```java
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0; i<len; i++){
                int cv=queue.poll();
                
                ....

            }
            L++;
        }
```
Queue의 길이만큼 다 탐색한 후에 L값을 증가시켜야 적절한 L값을 얻을 수 있다. 자주 헷갈려서 기록해 둔다.
