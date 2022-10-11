# 상황

github repository에 프로젝트가 존재할때, 이 프로젝트를 그대로 복사하여 local과 연결해주는 방법들을 적었다.

### 1. 새로운 다른 환경(다른 디렉토리, 서버 등)에 github 내용 불러오기

```
git clone https://github.com/steadykyu/TIL.git
```
왠만하면 바탕화면 에서 작업하면 된다.

github에 가면 git을 복사해올 수 있다.

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
local 에서 계정을 설정하지 않았다면, github 설정과 일치하도록 이름과 email을 설정해주자.

--global를 제거하면 로컬 pc가 아닌 현재 프로젝트의 이름과 email만 설정시킬 수 있다.