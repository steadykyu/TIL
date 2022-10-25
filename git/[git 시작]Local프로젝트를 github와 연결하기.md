# 목표

Local 환경에 Github의 git을 연결시키자.
Local 서버 폴더에 있는 프로젝트를 위의 github repository와 연동시키자.

두가지 방법으로 알아본다.

1. git init 이용하기

2. git clone 이용하기

> 참고

- github repository에서 local git repository로 옮기기

## Visual Studio Code에서 작업한다.

- 작업할 폴더를 Visual Studio Code에 드래그한다.
- 위쪽의 터미널을 연다.

---

# 1. 로컬환경에서 git init 이용하기

> 최종 코드

```
echo "# example" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/steadykyu/example.git
git push -u origin main
```

## 0. 로컬 PC의 에서 git repository 이름과 email 설정하기

로컬 pc에서 한번도 이름과 email을 설정한 적이 없다면, 아래 작업을 진행한다.

> 이름등록

git config user.name "steadykyu"

> 이메일 등록

git config user.email "awakekyu1@google.com"

현재 git repository의 이름과 이메일을 설정해준다

만약 --global을 붙인다면, 모든 로컬PC에서 생성하는 git repository의 name과 email을 설정 해줄 수 있다.

```
git config --global user.name "steadykyu"
```

## 1. 새로운 git repository 만들기

```git
echo "# example" >> README.md
git init
git add README.md
git commit -m "first commit"
```

> git init

- 현재 디렉토리에 .git이라는 파일이 생성됩니다.
- git init 명령어는 “저장소를 생성”해줍니다.

> git add -A

- 변경사항 모두다 추가해주기
  - git add --ignore-errors -A
  - 만약 어떠한 이유로 전부가 아닌 몇개 파일만 올라가면, 다음과 같이 작업하여 문제가 생기는 파일 외의 파일들만 깃에 넣을수 있다.

> git commit -m "First Commit"

" " 내용으로 커밋해주기.

> git status

- nothing to commit, working tree clean' 가 나와야함
  (빠지거나 커밋해주지 않은게 없나 체크하자.)

## 2. git repository와 github 연동하기

```
git branch -M main
git remote add origin git@github.com:outsideris/example-repo.git
git push -u origin main
```

> git branch -M main

main 이라는 브랜치를 생성한다.

- github에서 default branch로 main을 사용하고 있다. 그러므로 main으로 만드는 것이 좋다.

> git remote

- 현 폴더의 원격 레파지토리(github)를 확인하는 명령어로 없으면 아무것도 출력되지 않는다.

```
git remote add origin https://github.com/steadykyu/TIL.git
```

- 원격 레파지토리(이름 origin)와 연결

- 직접 작성할 수도 있지만, github사이트에서 github repository를 생성하면 원격 repository의 url을 복사하면 더 편리하게 연동 시킬 수 있다.

> git push -u origin main

- 원격레파지토리 안의 main 브랜치에 값 넣어주기.
- 한번해놓으면 이후로는 **git push**만 하면 된다.(알아서 main branch에서 작업한다.)
- 위에서 썼지만, 앞으로의 github은 main을 default branch로 사용한다.

# 2. git clone 이용하기

git repository를 생성한후, 해당 git을 복사해온다.

- 예시

```
https://github.com/steadykyu/TIL.git
```

이후 [glt clone 사용]("https://github.com/steadykyu/TIL/blob/main/git/%5Bgit%20clone%5D%EC%A1%B4%EC%9E%AC%ED%95%98%EB%8A%94github%EC%99%80local%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0.md") 내용대로 진행한다.

# 참고

## github repository 프로젝트 내용을 local git repository로 옮기기

## 최종코드

```
git fetch
git pull origin main
```

### 1.git fetch

- github repository에서 업데이트 상황을 보고, local로 가져온다.

### 2. git pull origin main

- main에서 가져온 자료들을 현재 local repository에 동기화시켜준다.
