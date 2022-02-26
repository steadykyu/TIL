## 목적
서버에 폴더에 있는 프로젝트 + @를 github repository와 연동시키자.

## 1. 서버 디렉토리에 git만들고 버전관리 시작하기.
### 1. git init
+ 이러면 현재 디렉토리에 .git이라는 파일이 생성됩니다.
+ git init 명령어는 “저장소를 생성”해줍니다.

### 2. git add -A
+ 변경사항 모두다 추가해주기

### 3. git commit -m "First Commit"
" " 내용으로 커밋해주기.

### 4. git status
+ nothing to commit, working tree clean' 가 나와야함)
(빠지거나 커밋해주지 않은게 없나 체크하자.)

## 2. github와 연동하기
### 1.git remote
+ 현 폴더의 원격 레파지토리(github)를 확인하는 명령어
+ 없으면 아무것도 출력되지 않는다.

### 2.git remote add origin https://github.com/steadykyu/TIL.git
+ 원격 레파지토리(이름 origin)와 연결
+ github repository를 생성하면, 레파지토리 url을 복사해올수 있다.
+ 복사해서 origin 옆쪽에 붙여주자.

### 3. git push -u origin master
+ 원격레파지토리 안의 master 브랜치에 값 넣어주기.
+ 한번해놓으면 이후로는 **git push**만 하면 된다.(알아서 master branch에서 작업한다.)

