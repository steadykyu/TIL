```sql
SET @hour := -1; -- 변수 선언

SELECT (@hour := @hour + 1) as HOUR,
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour) as COUNT
FROM ANIMAL_OUTS
WHERE @hour < 23
```

1. 주어진 테이블에는 0~6시 까지의 시간 값이 존재하지 않는다. 그러므로 로컬 변수를 만들어주어야한다.

    + := : PL/SQL 에서 할당(대입)하는 연산자

    + SET : SET 옆에 변수명과 초기값을 설정할 수 있다.

    + @hour : 사용자 정의 변수 선언

2. 동작순서

    1. FROM 이후 WHERE문의 @hour < 23 조건을 만족하므로, select문으로 간다. (@hour에는 -1~22의 값을 순서로 순차적으로 select 문에 들어간다.)

    + 약간 반복문 처럼 select가 진행된다고 생각하면 편하다.

    2. SELECT (@hour := @hour +1) 은 where 조건을 통과한 @hour의 값에 1씩 증가시킨 값으로(0~23의 값) SELECT 문 전체를 실행하게 됩니다.

  