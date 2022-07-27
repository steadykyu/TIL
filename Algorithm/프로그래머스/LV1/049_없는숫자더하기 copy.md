## Idea
1. 있는 숫자를 정렬한다.

2. 0~9 를 담은 Set을 만든다.

3. Set에 포함되는 않는 숫자만 더한다.

## 풀이
```java
import java.util.Set;
import java.util.HashSet;
public int solution(int[] numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int x : numbers) set.add(x);
        for(int i=0; i<=9;i++) if(!set.contains(i)) answer+=i;

        return answer;
    }
```
1. HashSet Class는 Set interface를 구현한 클래스이다. 그래도 둘다 import 해주어야 한다. 
## 참고

