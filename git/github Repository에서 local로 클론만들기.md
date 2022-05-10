### 1. 새로운 다른 환경(다른 디렉토리, 서버 등)에 github 내용 불러오기
왠만하면 바탕화면 에서 작업하면 된다.
```
git clone https://github.com/steadykyu/TIL.git
```

### 2.클론을 만들었다면 이후로는 업데이트 상황을 보기위해
```
git fetch

git status
```

### 3. 내용추가 후 알맞은 계정으로 push 해주기 위해 계정을 확인해보자

```
git config --list

git config --global user.name "steadykyu"
git config --global user.email "awakekyu1@gmail.com"
```
계정이 없다면 github 설정과 일치하도록 이름과 email을 설정해주자.
