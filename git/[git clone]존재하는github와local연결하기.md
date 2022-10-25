# 목표

github repository에 프로젝트가 존재할때, 이 프로젝트를 그대로 복사하여 local과 연결해주는 git clone 을 알아보자.

# 최종 코드

```
git clone "https://github.com/steadykyu/TIL.git"
git fetch
git status
git pull origin main
```

> 내용 추가 후

```
git add -A
git commit -m "first commit"
git push -u origin main
```

한번 push 한 이후로는 push만 써주면 main Branch로 들어간다.

## 1. 새로운 다른 환경(다른 디렉토리, 서버 등)에 github 내용 불러오기

```
git clone https://github.com/steadykyu/TIL.git
```

github의 git을 복사해온다.

- 이 과정에서 git remote (Github의 git과 연결)을 자동으로 해준다.

### 2.클론을 만들었다면 이후로는 업데이트 상황을 보고, 프로젝트를 가져오자.

```
git fetch
git status
git pull origin main
```

# 참고
> 계정확인하기
```
git config --list
```
내용추가 후 알맞은 계정으로 push 되는지 확인해보자.

> 잘못된 계정일때
```
git config --global user.name "steadykyu"
git config --global user.email "awakekyu1@gmail.com"
```

local 에서 계정을 설정하지 않았다면, github 설정과 일치하도록 이름과 email을 설정해주자.

--global를 제거하면 로컬 pc가 아닌 현재 프로젝트의 이름과 email만 설정시킬 수 있다.
