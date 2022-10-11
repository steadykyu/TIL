## 문제상황

이전까지 github는 master라는 branch의 이름으로 저장 되어 왔다. 이번에 github가 master라는 이름을 버리고 main이라는 이름을 택한 사실을 알게 되었다.

그러므로 이전의 master branch들을 main으로 바꾸어 주려고 한다.

> 로컬 환경 체크하기

로컬 환경을 모두 github에 동기화하여 github repository가 최신화 된 상태여야 한다.
로컬 repository의 git push가 이전 브랜치(master)와 연동 되도록 되어있기 때문에 모두 지워야 하기 때문이다.

<img src = "https://github.com/steadykyu/TIL/tree/main/git/img/mastertimain_1.png">

과거 부터 현재까지의 기록을 모두 저장하고 있는 git repository master branch는 github에서 쉽게 변경이 가능하다.

```

```

변경한 git repository를 다시 Local repository로 옮겨주자. git clone을 이용하면 쉽게 옮겨 줄 수 있다. 옮긴 후에는 앞으로 main에 들어가도록 아래의 push 작업을 해주자.
```
git add .
git commit -m "masterTomain"
git push -u origin main
```