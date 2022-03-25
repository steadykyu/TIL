이번 실전편은 **모바일을 먼저 만들고** 확장해서 반응형으로 태블릿, desktop으로 만들도록 하겠다.이러한 방식을 "Mobile First" 라고 부른다.

# 1. 전체적인 layout 정하기.

> header 와 nav의 차이

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/6_1.png">

- Header 요소

```
HTML5에 새롭게 추가된 요소로서, 웹 문서 맨 윗부분에 있으며 웹 사이트 이름, 글로벌 링크(로그인, 회원가입, 사이트맵, 언어 선택등 웹사이트 어느 곳에서든지 이용할 수 있는 링크)등으로 구성된 영역이다.

```

- Nav 요소

```
HTML5에 새롭게 추가된 요소로서, 목적지로 이동할 수 있도록 링크를 별도로 모아둔 영역이다.

출처: https://webdir.tistory.com/310 [WEBDIR]
```

우리에게는 검색엔진도 필요하므로, header로 작성하자.

- section 요소

> section 과 article의 div의 차이

```
<article> tag는 문서 혹은 요소가 독립적으로 존재할 수 있을 때 사용한다.
<section> tag는 논리적으로 관계 있는 문서 혹은 요소를 분리할 때 사용한다.
<div> 요소간 논리적 관계와는 상관없이 요소를 나눠야 할 필요가 있을 경우 사용한다.

출처 : https://developern.tistory.com/entry/how-to-article-section-div-tag
```

\<article\>과 \<section\>은 모두 \<div\>와 같은 block 속성을 갖고 있는 tag이다. 그러므로 기능상의 문제는 없지만 개발자의 가독성을 위해 구별한다. 우리는 아래 wireframe에 따라 4개의 section으로 작업을 진행하도록 하겠다.

> wireframe 만들기

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/6_2.png">

- 위 그림과 같이 디자이너가 어떠한 형태로 웹을 만들 것인지 디자인 한 형태를 **wireframe**이라고 한다. 이 wireframe을 잘 만들어두고 각각 **labeling**을 설정하자.

# 2. 빠르게 HTML Markup 하기

## 2.1 HTML

<h2 align=center> MDN을 참고하며 빠르게 작성한다.</h2>

> video

> span

일반적으로 쓰여있는 텍스트들은 HTML에서 스타일을 주는 span 태그 안에 넣는다.

현재는 내가 javascript를 몰라서 직접 작성하였다. 하지만 이런 HTML 데이터들은 사실 javascript를 통하면 동적으로 가져올 수 있다. 그러니 노가다에 너무 겁내지말자. 문제 생겼을때 고치려면 이 언어에 대해 알아야하니까 익숙은 해져야 한다!

## 2.2 준비물 준비하기

HTML header에 적절하게 입력해준다.ex) \<script\> \<link\>

> 아이콘 가져오기

https://fontawesome.com/ 에서 script와 아이콘 tag를 가져와서 넣어주었다.

> 필요한 color 비교하며 가져오기

https://material.io/resources/color/#!/?view.left=0&view.right=0 : 색 비교하는 site

Color Picker : 구글 확장프로그램

> font

https://fonts.google.com/

# 3. CSS 코드작성하기

> VSC 에서 이중창 사용하기

VSC 에서 이중창을 사용하여 생산성을 더 높힐 수 있다.

> root: , \*

:root를 이용하여 조금더 consistent(일관성 있는) 하게 작성하기.

root: , \* 를 활용하여 전반적인 환경 세팅해두기.

## 3.1 header

```css
header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: var(--padding);
  background-color: var(--black-color);
  color: var(--white-color);
}

header .logo {
  font-size: var(--font-large);
}

header .logo i {
  color: var(--red-color);
}

header .icons .fa-magnifying-glass {
  margin-right: var(--padding);
}
```

> header .logo i

tag 안 클래스 안쪽의 item에 갈때 **띄어쓰기가 꼭 되어있어야** 적용이 된다.

> header .icons .fa-magnifying-glass

공백이 존재하는 class="fa-solid fa-magnifying-glass" 에서 어느 부분을 적어도 웹이 알아서 처리해준다.

지금 보면 중복된 코드가 너무많다. 이러한 문제를 해결하기위해 SASS와 LESS란 라이브러리를 사용이 가능하다.

```
header{
    .logo{

    }
    .icons{

    }
}
```

또는 React 프레임 워크의 POSTCSS 기술로 더 편하게 할수 있다. 일단 나는 초보니까, 익숙해지도록 원시css방식을 그대로 써보자.

## 3.2 player section

> .info .metadata .titleAndButton .title

span 속 글자가 너무길때 계속 내려가는것이 아니라, 2문장으로 제한하고 ...상태로 만들고 싶다.
그럴때는 css line clamp(고정시키는 기구) 를 이용해야한다.

## 3.3 info section

header 와 마찬가지로 경로는 라이브러리나 프레임워크쓰면 간편하게 가능하다.

button의 default 배경색은 grey라 white로 수정해주었다. global option으로 위쪽 button에서 해도 된다.

## 3.4 UpNext Section

> .upNext > .title {}

HTML을 보면 upNext class 안에는 여러 title classname이 존재한다. **바로 직전의 자식**에게만 속성값을 주고싶을때 다음과 같이 작성한다.

> <div class="img"><img src="/img/파이리.jpg" alt=""></div>

```
html의 코드를

<img src="/img/파이리.jpg" alt="">에서

<div class="img"><img src="/img/파이리.jpg" alt=""></div> 로 바꾸었다.

이미지 자체는 반응형이 아니므로 flex 박스의 비율을 맞추도록 작동하지 않는다.
그래서 박스안에 넣어주고, 박스크기만큼의 크기로 고정해두었다.
즉 flex box 비율대로 이미지가 변하도록 하기 위해 작업하였다.
```

# 4. 반응형으로 배치바꾸기

flexbox 덕분에 어느정도 반응형이 가능하지만 desktop같이 큰곳에서는 배치를 바꾸고싶다고하자.
(wireframe 확인)

```html
<section class="info">...</section>
<section class="upNext">...</section>

에서 아래로 수정!
<div class="infoAndUpNext">
  <section class="info">...</section>
  <section class="upNext">...</section>
</div>
```

원래 flex-direction: column 형으로 section이 구성되어있는데 @mediaQuries로 특정상황에서는 저 두 section이 가로로 바뀌도록 해보자.

# 5. 동적 사이트 만들기

추가내용이므로 JS를 알고 보는게 좋다. 일단 모른채 작성해봄. <br>
youtube 48분 29초

html에서 main.js와 연결후 아래 코드를 입력하자.

> js

```javascript
const moreBtn = document.querySelector(".info .metadata .moreBtn");
const title = document.querySelector(".info .metadata .title");

moreBtn.addEventListener("click", () => {
  moreBtn.classList.toggle("clicked");
  title.classList.toggle("clamp");
});
```

- html의 .info .metadata .moreBtn를 (좌측)moreBtn에 할당한다. title마찬가지
- click 시 moreBtn은 clicked로 toggle(설정변경) / title은 clamp로 toggle 한다.
  > html

```html
<div class="titleAndButton">
  <span class="title clamp">
    clamp를 추가해준다. Clone Coding Youtube mobile Website 유튜브 모바일
    웹사이트 따라만들기|프론트엔드 개발자 입문편. 누구나 따라할수 있습니다.
    화이팅하세요 너도 할수 있다!! 늦은건 없다!! 앉아서 코딩하면 늘수 있어!!
  </span>
  <button class="moreBtn"><i class="fa-solid fa-caret-down"></i></button>
</div>
```

> css

```css
.info .metadata .titleAndButton .title {
  font-size: var(--font-medium);

  margin-right: val(--padding);
}

.info .metadata .titleAndButton .title.clamp {
  /* clamp */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
}
```

## 출처

https://www.youtube.com/watch?v=67stn7Pu7s4&ab_channel=%EB%93%9C%EB%A6%BC%EC%BD%94%EB%94%A9by%EC%97%98%EB%A6%AC
