```SQL
-- 코드를 입력하세요
SELECT OUTS.ANIMAL_ID, OUTS.NAME
from ANIMAL_OUTS OUTS left outer join ANIMAL_INS INS 
ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_TYPE IS NULL
order BY ANIMAL_ID
```

1. 보호소쪽(INS)의 데이터가 유실되었고, 입양간 쪽(OUTS)이 더 많은 데이터를 가지고 있으므로 OUTS LEFT OUTER JOIN INS 를 작업해주자.

2. OUTS에 더많은 ANIMAL_ID가 존재하며(유실된 ID들), 이 ID들은 INS와 연결된 COLUMN과는 NULL 값으로 연결 된다. (단 이때의 COLUMN은 자체로 NULL이 존재하지 않는(NULLABLE=FALSE) COLUMN을 사용해야한다.)