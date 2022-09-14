```SQL
-- 코드를 입력하세요
SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID)
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR > 8 AND HOUR < 20
ORDER BY HOUR;

```
1. HOUR 함수 : DATETIME 타입에서 시간을 가져와 준다.
    + SELECT문이 우선순위가 낮음에도 GROUP, HAVING 문에서 별칭사용이 가능하다.(HOUR)


> 날짜/시간 참고사이트

https://blog.jiniworld.me/73#a179

