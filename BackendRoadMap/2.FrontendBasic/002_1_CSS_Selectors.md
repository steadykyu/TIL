# 1.정의
Cascading Style Sheet ( 연속해서 떨어지는(폭포수) 스타일의 sheet )

> Cascading 우선순위

+ **Author style** : 우리(제작자)가 정해주는 스타일

+ **User style**   : 유저가 정하는 스타일(ex) 다크모드 등)

+ **Browser**      : HTML과 같이 브라우저가 기본적으로 정해놓은 스타일

Cascading의 연결고리를 무시하는 !important가 있다. 이 important가 쓰이는 상황은, cascading 설계를 좋지 않게 했을 가능성이 크다.<br>
그래서 현업에서는 좋아 하지않는다.

# 2. 선택자
이전의 HTML에서 우리는 박스단위로 브라우저를 나누었다. 이렇게 박스 단위로 잘 나누어야하는 이유는, 박스단위로 잘 나누어야 label 하기 쉽기 때문이다.
이를 활용한 **selectors**를 살펴보자.

> 정의

HTML의 어떤 tag를 고를건지를 규정하는 문법이다.
> 문법 ( 아래 실습한 코드를 보면서 보도록 하자)
```
universal *
type Tag (div..)
ID #id
Class .class
State :
Attribute []
```
> 실습
+ JS bin에서 실행해보기!
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>JS Bin</title>
  </head>
  <body>
    
  <ol>
    <li id="special">First</li>
    <li>Second</li>
  </ol>
    
  <button>Button 1</button>
  <button>Button 2</button>
    
  <div class="red"></div>
  <div class="blue"></div>
    
  <a href="naver.com">Naver</a>
  <a href="googlenaver.com">Goolgle</a>
  <a>Empty</a>
</body>
</html>
```
+ ol tag는 container 이기때문에 기본적으로는 사용자에게 보여지지 않는다.
+ li tag는 사용자에게 보이는 방식이다.
+ div는 텅빈 박스이므로 보이지 않는다.
+ button 과 a는 알맞게 브라우져에 보이고 있다.(inline 에 알맞게 웹에 출력되고 있다.)


> css 
```css
/* universal selector  */
* {
  color : green;
}
/*전체가 전부 초록색을 입힌다. */

/* type selector */
li {
  color: blue;
}
/*해당 타입에 스타일을 입힌다. 
구체적으로 태그에 가깝게 설정한 방향으로 스타일 우선순위가 정해진다.*/

/* id selector */
li#special {
  color: pink;
}
/* 특정 tag의 이름에 스타일을 줄수도 있고, 해당 이름 전부에게 스타일을 줄수도 있다. */

/* class selector */
.red{
  width:100px;
  height: 100px;
  background: yellow;
}
/* div는 empty한 상태로 존재한다.
만약 다른 tag가 있으면 한 line을 차지하는 박스가 된다.
div.red 로 tag안 특정 클래스를 지정해줄 수 도 있다.
*/

/*  state selector */
button:hover{
  color: red;
  background: beige;
}
/* 버튼상태를 변경한다.
현재 버튼에 마우스를 가져가면, 배경색과 글자 색이 달라진다. */

/* Attribute selector */
a[href $="naver.com"]{
  color:purple;
}
/* 속성값에 따라서 스타일링이 가능하다.
[href $= "naver.com"] 등 naver.com으로 끝나는 attribute를 고를수도 있다.*/
```
+ 아래 형식을 따른다.
```
selector{
  property: value;
} 
```

> div tag
+ 마찬가지로 jsbin에서 사용가능하다.
```css

/* class selector */
.red{
  width:100px;
  height: 100px;
  padding: 20px;
  margin: 20px;
  border: 2px dashed red;
  background: yellow;
}
  /* padding 전부 풀어쓰기
  padding: 20px 10px 20px 10px;
  padding: 20px 10px; 상하/좌우
  padding-top: 20px;  etc...
  */

  /* border: 대신 구체적으로 풀어쓰는 방법
  border-width: 2px;
  border-style: solid;
  border-color: pink;*/
```
+ padding 는 content 안에 들어 가는 space를 말한다.

+ margin 는 content 밖에 존재하는 space를 말한다.

+ 더 많은 Selectors 종류들과 내용들은 아래링크들을 참고하자

https://developer.mozilla.org/en-US/docs/Web/CSS/Reference  :  레퍼런스 page <br>
https://flukeout.github.io/         : CSS dinner 게임.

> css diner 추가 내용(참고)
```
+ descendant selector : tag안의 tag를 지정할때 사용한다. (ex) plate apple{})
+ Comma Combinator 
+ Adjacent Sibling Selector
+ General Sibling Selector
+ Child Selector
+ First Child Pseudo-selector
+ Only Child Pseudo-selector (lv 16 - plate > :only-child)
+ :last-child
+ Nth Child Pseudo-selector
+ Nth Last Child Selector ( element 단위로 뒤쪽부터 세야함)
+ First of Type Selector
+ Nth of Type Selector (2n+3 하면 스타트지점을 3 이후 2씩증가 하게 만들수 있다.)
+ :only-of-type
+ :last-of-type
+ Empty Selector(:empty)
+ Negation Pseudo-class( :not(X) )
```


## 출처 
드림코딩 무료강좌 : https://www.notion.so/277f2906743742ae8f19b6494581058f
