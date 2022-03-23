# 4. Flexbox
Box나 ITEM들을 행 또는 열로 자유자재로 배치켜줄수 있는 기능이다.

박스가 커지거나 작아지면 ITEM들의 크기를 어떻게 두며 어떻게 박스의 공간을 차지할지 설정할 수 있다.

> 탄생 배경

이전에는 Position, float, Table 들을 어떻게든 알맞게 맞춰넣어서 BOX와 ITEm들을 위치시켰다. 하지만 이런 방식은 너무나 많은 시간을 소비하게 만들었다.
그리고 위의 것들로는 할수 없는 기능들이 존재했었다.(ex) 박스안의 ITEM 가운데 정렬, ITEM size 상관없이 동일간격을 가지도록 설정 등)

> float

image와 text들을 어떻게 배치하는지 설정하는 기능이다.텍스트를 기준으로 left, center, right으로 배치할수 있다.(신문에 있는 이미지와 비슷함)

+ 참고사이트

https://developer.mozilla.org/en-US/docs/Web/CSS/float : float MDN

## 4.1 container
### concept1

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_5.png" width = "40%" heigth = "40%">

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_6.png" width = "40%" heigth = "40%">

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_7.png" width = "40%" heigth = "40%">
 
+ **컨테이너에 대한 설정과 컨테이너 안 ITEM에 관한 설정을 attribute(속성값)들을 통해 지정해 줄수 있다.**

### concept2

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_8.png" width = "40%" heigth = "40%">

+ **중심축과 반대축을 내가 원하는대로 설정할 수 있다.(그림의 main axis-중심축)**


> Flexbox 참고사이트

https://css-tricks.com/snippets/css/a-guide-to-flexbox/ 

https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout/Basic_Concepts_of_Flexbox

코드를 통해 두가지 핵심 개념이  내용인지 확인해보자 <br>

### 4.1.1 코드작성
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <!-- div.container>div.item.item${$}*10 + tap -->
   <div class="container">
        <div class="item item1">1</div>
        <div class="item item2">2</div>
        <div class="item item3">3</div>
        <div class="item item4">4</div>
        <div class="item item5">5</div>
        <div class="item item6">6</div>
        <div class="item item7">7</div>
        <div class="item item8">8</div>
        <div class="item item9">9</div>
        <div class="item item10">10</div>
    </div>
</body>
</html>
```
+ 예약어 확인하기

> Css 
```css
.container{
  background: beige;
  height: 100vh; 
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  /*flex-flow: column nowrap; */

  justify-content: space-between;  /* main axis */
  align-items: baseline;
  align-content: center;      /* cross axis */
}

.item{
  width:40px;
  height: 40px;
  border: 1px solid black;
}

.item1 {
  background: #ef9a9a;
  /* padding: 20px; */
}

.item2 {
  background: #f48fb1;
}

.item3 {
  background: #ce93d8;
}

.item4 {
  background: #d39ddb;
}

.item5 {
  background: #90caf9;
}

.item6 {
  background: #a5d6a7;
}

.item7 {
  background: #e6ee9c;
}

.item8 {
  background: #fff176;
}

.item9 {
  background: #ffb74d;
}

.item10 {
  background: #ef5350;
```
> Viewport Height(vh) 
 
+ 부모의 height를 100% 쓰겠다는 의미이다.(원래는 부모 html, body 전부 바꿔야하지만 자식 tag쪽에서 vh값으로 바꿀 수 있다.)

> display
 
+ flex로 선언하여, flexbox로 만들어 줄수 있다.(자동으로 왼쪽에서 오른쪽으로 가도록 정렬이 된다.)

> flex-direction

+ row, row-reverse, column, column-reverse 로 **중심축**을 지정 할 수 있다.
+ -reverse시 box의 순서도 반대로 바뀐다.

> flex-wrap

+ 그림 2-9
+ 그림은 wrap상태이다.
+ flex-wrap은 기본값은 nowrap으로 공간 부족시 box크기를 전체적으로 줄인다.
+ wrap을 하면 row box가 공간이 부족할시 아래로 내려간다. 

> flex-flow

+ 한번에 direction과 wrap 여부를 정해 줄 수 있다.

> justify-content
+ 그림 2_10
+ 중심축(main axis)을 지정한후 어떻게 배치할지 결정한다. 단 위의 -reverse와 다르게 box 순서는 바뀌지 않는다. 
+ 예 ) flex-start, flex-end, space-around, space-evenly, space-between

> align-items

+ 세로축에서의 배치를 결정해준다 
+ top, center, baseline(텍스트 위치가 일치하도록) 등이 존재한다.

> align-content
+ 반대축을 중심으로 어떻게 배치할지 결정한다. 
+ justify-content 와 사용법은 같다.

+ flexbox는 대부분의 웹브라우저가 호환하고 있지만, 그 안의 attribtute 호환하지 않을 가능성이 높다. 그러므로 꼭 MDN에서 확인하고 사용하도록 하자.
+ 모든 속성들을 외우려고하지 말고 큰개념의 동작방식을 이해하고, 세부내용은 필요할때마다 MDN CSS에서 찾고 예시를 해보면서 알아가면 된다.
+ 개념을 알고 찾을때와 모르고 찾을때 속도의 차이는 엄청나다!!!


> color 관련 참고사이트

https://material.io/resources/color/#!/?view.left=0&view.right=0


## 4.2 Item 속성값들
Container에 속성값들을 통해 Flexbox의 설정이나 배치를 변경한 것 처럼 ITEM에도 속성값을 통해 크기, 배치등을 설정 할수 있다.
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <!-- div.container>div.item.item${$}*10 + tap -->
   <div class="container">
        <div class="item item1">1</div>
        <div class="item item2">2</div>
        <div class="item item3">3</div>
    </div>
</body>
</html>
```

```css
.container{
  background: beige;
  height: 100vh; 
  display: flex;

}


.item{
  width:40px;
  height: 40px;
  border: 1px solid black;
}

.item1 {
  background: #ef9a9a;
  /* padding: 20px; */
  /* order: 2;*/
  /* flex-grow : 2; */
  /* flex-shrink: 2; */
  /* flex-basis: 50% */
  
  align-self: center;
  
}

.item2 {
  background: #f48fb1;
 /* flex-grow : 1;  */
 /* flex-shrink: 1; */
 /* flex-basis: 40% */
}

.item3 {
  background: #ce93d8;
 /* flex-grow : 1;  */
 /* flex-shrink: 1; */
 /* flex-basis: 10% */
}
```

> padding

ITEM의 크기를 변경할 수 있다.

> order

ITEM의 순서를 정해 줄수 있다.(실무에서 거의 안씀)

> flex-grow

+ 기본값은 0 으로 container의 빈공간을 채우려고 하지 않는다.
+ 1의 속성값을 주면 container의 빈공간을 채우려고 노력한다.
+ 여러 ITEM에 값을 주면 container를 다 채우되 입력값에 비례해서 공간 크기를 결정한다.
+ 단 정해준 크기보다 작아지면 비례해서 공간을 차지하지는 않는다.

> flex-shrink

+ 기본값은 0이다.
+ 값이 정해준 크기보다 줄어들때 더 비례해서 작아지도록 설정할 수 있다.

> flex-basis

+ ITEM의 크기를 적절하게 나눌때 사용한다.
+ 기본값은 auto 로 grow와 shrink에 맞춘 비율로 정해진다.
+ grow와 shrink가 없다면, 크기가 줄든 늘든 basis에서 정한 비율로 공간을 차지한다.

> flex

grow, shrink, basis 값을 한번에 정해줄 수 있다. (ex) 2 2 auto;)

> align-self

+ container의 align 처럼 세로축에서의 정렬대로 배치시켜준다.
+ 단 모든 ITEM이 아닌 지정한 ITMP에만 정렬기준 대로 배치시켜준다.

## 연습용 사이트

https://flexboxfroggy.com/#ko

## 출처

https://www.youtube.com/watch?v=7neASrWEFEM&ab_channel=%EB%93%9C%EB%A6%BC%EC%BD%94%EB%94%A9by%EC%97%98%EB%A6%AC
