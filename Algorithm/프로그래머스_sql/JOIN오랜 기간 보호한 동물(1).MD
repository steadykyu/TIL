```SQL
-- 코드를 입력하세요
SELECT INS.NAME, INS.DATETIME
FROM ANIMAL_INS INS LEFT OUTER JOIN ANIMAL_OUTS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.ANIMAL_ID IS NULL
ORDER BY INS.DATETIME 
LIMIT 3
```


> JOIN 참고 그림
+ http://chongmoa.com/xe/2549