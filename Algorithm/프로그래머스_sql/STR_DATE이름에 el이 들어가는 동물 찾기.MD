```sql
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS 
WHERE ANIMAL_TYPE = 'Dog' and NAME LIKE '%EL%'
order BY NAME
```
el만 신경쓰다가 할머니가 찾으시는 동물이 개라는 부분을 신경쓰지 않았다. 그래서 시간이 더 걸렸다. 


> 참고

LIKE 연산자 PATTERN을 알려주는 사이트

https://www.w3schools.com/mysql/mysql_like.asp