# 문제상황

github와 로컬 서버 git의 username 또는 useremail이 달라서 github에 잔디가 심어지지 않았다.

과거의 commit들이 잘못된 이름과 이메일로 커밋되었던 것이다!!

# 해결 방안

> 내 로컬 pc 환경의 계정이름을 바꿔주는 작업
```
git config --global user.email "내 이메일"
git config user.email "내 이메일"
```
--global을 제거시 현재 진행하는 프로젝트에서만 내 이메일을 바꾸어준다.

앞으로의 커밋은 적절하게 잔디가 심어질 것이다.

## 과거의 커밋 수정하기

근데 과거에 작업해둔 잘못된 커밋들의 이름과 이메일을 수정해줄 수는 없을까?

이를 해결 하기 위해 인터넷 서칭한 결과 과거 commit()한 기록에서 이름과 이메일을 바꿔주는 소스 코드를 발견했다.

> 과거 commit한 git들의 이름과 이메일을 변경해주는 코드
```
git filter-branch --env-filter '
WRONG_EMAIL="wrong@example.com"
NEW_NAME="New Name Value"
NEW_EMAIL="correct@example.com"
if [ "$GIT_COMMITTER_EMAIL" = "$WRONG_EMAIL" ]
then
export GIT_COMMITTER_NAME="$NEW_NAME"
export GIT_COMMITTER_EMAIL="$NEW_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$WRONG_EMAIL" ]
then
export GIT_AUTHOR_NAME="$NEW_NAME"
export GIT_AUTHOR_EMAIL="$NEW_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags
```

참고 : https://steadykyu.tistory.com/29

