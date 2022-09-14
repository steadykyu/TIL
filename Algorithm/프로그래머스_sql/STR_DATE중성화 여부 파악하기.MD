```SQL
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
,IF(SUBSTRING_INDEX(SEX_UPON_INTAKE,' ',1) IN ('Neutered','Spayed'),'O','X') AS 중성화
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID
/* LIKE 사용해도 될듯 */
```

존재하는 COLUMN의 데이터와 조건문 IF을 이용하여 새로운 COLUMN을 만들수 있다.