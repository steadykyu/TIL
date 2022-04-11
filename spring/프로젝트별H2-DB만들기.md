## 로컬 데이터 베이스 생성 방법

### window 기준

1. H2\bin\h2w.bat 을 실행시킨다.

2. url의 세션키는 유지한채 아래 모양처럼 바꿔준다.

```
localhost:8082/세션키
```

이렇게 한번만 연결해주면 이후로는 알아서 연결시켜준다. 우리는 홈 디렉토리가 아닌 로컬 디렉토리에 연결 해줄 목적이 있으므로, 아래처럼 연결해주자.

3. 홈 dir가 아닌 로컬에 H2 DB 만들기

3-1) 오른쪽 하단에 H2 DataBase Engine 찾기 -> 오른쪽 클릭, Create a new database 찾기

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/h2_1.png">
</p>

3-2) ./[새DB이름] 작성하고 비밀번호를 생성한후 create 누르자.

./은 새로운 DB를 H2폴더 현재의 bin 디렉토리에 만든다.

비밀번호가 없으면 생성이 안되므로, 일단 생성 시켜주자.

3-3) 이제 h2 web으로 돌아가서 비밀번호를 입력 후 연결이 되는 지 확인하자.

> JDBC URL

```
jdbc:h2:tcp://localhost/./jpashop
```

이때 .을 쓰면 h2w.bat을 실행시킨 bin 디렉토리에서 DB를 찾아서 연결해 준다.(이름을 생성한 db와 일치시켜주자.)

> 참고

```
jdbc:h2:tcp://localhost/~/jpashop

: 사용자 폴더에 db를 생성시킨다. 근데 이렇게 하면 각 프로젝트마다 db를 따로 둘수가 없어서 '.' 으로 db를 생성했다.
```

연결이 되었다면 아래 명령어를 통해 비밀번호를 제거해주자(귀찮으므로)

```
ALTER USER SA SET PASSWORD '';
```

> 참고

JDBC URL : jdbc:h2:~/newDB 로 접속하면 다른 곳에서 접속시 제한이 걸릴 수 있으므로,

JDBC URL : jdbc:h2:tcp://localhost/./newDB 로 접속하여 파일이 아닌 네트워크 tcp로 접근하자.

출처 : https://sogno-ing.tistory.com/169
