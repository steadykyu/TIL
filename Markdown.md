# 목차 만들기
```
[목차 텍스트1](#링크가-걸리는-텍스트)
[목차 텍스트2](#-----------) (공백포함 11글자)
```
+ 1번, 2번중 1번의 방법을 쓰는 것이 좋다.
+ 주의할 점은 텍스트 띄어쓰기를 "-"로 명시해주어야한다. 또한 영어는 모두 소문자로 작성
+ 마크다운 글만 올리면 알아서 목차문법으로 바꿔주는 사이트 : https://ecotrust-canada.github.io/markdown-toc/
+ 목차끼리 문단이 안바뀌므로 br tag 나 두번 enter를 쳐서 띄어줘야합니다.

1.[목차](#목차-만들기)

2.[제목 부제목 만들기](#1.제목-부제목-만들기)

# 1.제목 부제목 만들기
```
# 가장 큰 텍스트
## 다음
### 다음으로 큰 제목
```
위 문법의 순서대로 제목이 만들어 집니다.

# 2. Emphasis 강조
```
기울여 쓰기(1) : *This text will be italic*
기울여 쓰기(2) : _This will also be italic_
두껍게 쓰기(1) : **This text will be bold**
두껍게 쓰기(2) : __This will also be bold__
취소선 :  ~~This is canceled~~
이탤릭체와 뚜껍게를 혼합하기  *You **can** combine them*
```
*You **can** combine them*
위의 문법대로 사용이 가능하다.

# 3. Blockquotes 인용
```
> This is a first blockquote.
> > This is a second blockquote.
> > > This is a third blockquote.
```
결과
> This is a first blockquote.
> > This is a second blockquote.
> > > This is a third blockquote.

# 4.Lists 목록
## 4.1 Unordered lists 순서가 없는 목록
+ "+","*","-" 를 이용하면 된다.
+ 들여쓰기를 하면 모양이 바뀝니다.(\t 이 아닌 ' '으로 처리)
## 4.2 Ordered lists 순서가 있는 목록
+ 숫자를 기입하면 순서가 있는 목록이 됩니다.
+ 들여쓰기 하면 모양이 바뀝니다.(\t 이 아닌 ' '으로 처리)
```
* Item 1
* Item 2
  * Item 1
  * Item 2
    * Item 1
    * Item 2
 1. Item 1
 2. Item 2
 3. Item 3
   1. Item 1
   2. Item 2
   3. Item 3
```
## 결과
* Item 1
* Item 2
  * Item 1
  * Item 2
    * Item 1
    * Item 2
1. Item 1
2. Item 2
3. Item 3
   1. Item 1
   2. Item 2
   3. Item 3

# 5. Backslash Escapes 백슬래쉬 이스케이프
+ 특수문자를 표현 할때, 표시할 문자앞에 '\'를 넣으면 텍스트로써 사용됩니다.
```
\*literal asterisks\*
\#hash mark\#
\[squre brackets\]
```
## 결과
\*literal asterisks\*
\#hash mark\#
\[squre brackets\]

# 6. Images 이미지
```
![alt 토마토](/img/tomato.jpg)
![alt man](/img/man_laptop.jpg)
![alt gitHubLogo](img src ="https://github.com/steadykyu/TIL/GitHub-logo.png" width="50%" height="50%")
```
각 순서대로 
1. 인라인 이미지
2. 링크 이미지
3. 다른 경로의 이미지 + 크기 바꾸기<br>

<img src ="https://github.com/steadykyu/TIL/blob/master/GitHub-logo.png" width="50%" height="50%">

# 7. External Links 외부 링크
```
[Google](http://www.google.com "구글")
[Naver](http://www.naver.com "네이버")
구글 www.google.com; 꺽쇠없음
네이버 <www.naver.com>; 꺽쇠있음
My github <https://github.com/steadykyu>;
```
## 결과
[Google](http://www.google.com "구글")
[Naver](http://www.naver.com "네이버")
구글 www.google.com; 꺽쇠없음
네이버 <www.naver.com>; 꺽쇠있음
My github <https://github.com/steadykyu>;

# 8. Fenced Code Blocks 코드 블럭 (텍스트 상자)
\`\`\`
This is code blocks.
\`\`\`
~~~
This is code blocks.
~~~
	4 spaces
```javascript
function test() {
 console.log("look ma’, no spaces");
}
