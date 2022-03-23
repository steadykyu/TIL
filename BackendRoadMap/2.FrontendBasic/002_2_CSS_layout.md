# 3. layout
우리가 지정한 박스를 잘 select해서 원하는 위치에 적절한 사이즈로 배치하는것이 매우 중요하다. 이를 위해 **display**와 **position**을 아는것이 매우 중요하다.

## 3.1 Display
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <!--Block level -->
  <div></div>
  <div></div>
  <div></div>
 
  <!--inline level -->
  <span>1</span>
  <span>2</span>
  <span>3</span>
</body>
</html>
```
```css
div, span{
  width: 80px;
  height: 80px;
  margin: 20px;
  background: pink;
}

div{
  background: red;
  display: inline-block;
}

span{
  background: Blue;
  display: block;
}
```

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_1.png" width ="30%" height = "30%">

+ 대표적인 defalut값이 block level인 div tag 와 inline level인 span tag에 display를 이용하면 설정값을 바꿀 수 있다.
+ 이때 설정값은 **inline**은 content를 꾸며주는 것이기 때문에 값이 있어야 Web browser에 나타낼 수 있다.
+ 그리고 **inline**은 content 크기에 맞춰서 크기가 결정된다.
+ code와 그림을 보고 inline-block 과 block의 차이를 알자.

## 3.2 Position
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <article class="container">
    <div></div>
    <div class="box">I'm Box</div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    
  </article>
</body>
</html>
```
```css
div, span{
  width: 80px;
  height: 80px;
  margin: 20px;
  background: red;
}

.container{
  background: yellow;
  left: 20px;
  top: 20px;
  position: relative;
}

.box{
  background: blue;
  left: 20px;
  top: 20px;
  position:sticky;
  /* relative, absolute, fixed, 등등) */
}
```
> static

css에서 position는 default 값으로 static을 가지고 있다. 이는 html에 정의된 순서대로 브라우저에 보이는 것을 의미한다. <br>
즉 body안에 있다면 있는 article은 body전체를(브라우저 맨위에서 아래) 범위로 하고 있다.(container의 position을 지우면 확인가능)

> relative

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_2.png">

원래의 ITEM의 위치에서 우리가 설정한 값만큼 이동시키도록 할수 있다.

> absolute

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_3.png">

내 아이템이 담겨있는 상자(container 범위) 안에서 설정한 값만큼 이동한다.

> fixed

<img src="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/2_4.png">

상자가 아닌 밖의 Web page에서 설정한 값만큼 이동한다.

> sticky

원래위치에 위치해 있지만, 스크롤을 이동시켜도 계속 원래위치에 위치해(붙어)있는다.

## 실무
이전에는 jQuery나 Bootstrap 에서 제공하는 라이브러리를 많이 사용했지만, JS도 좋지않고, 제공되는 CSS도 강력한 기능들이 부족했다.
또한 브라우저 자체에서도 제공되는 API가 빈약했습니다. 그래서 여러가지 기능들이 발전된 최신의 CSS에서는 이런 라이브러리들이 필요가 없어졌다. 

그러면 최신의 CSS만 쓰면 될거 같지만, 브라우저마다 호환성 유무가 다르므로 꼭 확인해서 사용해야한다.
이전에 말한 MDN이나 아래의 링크에서 확인할수 있다. (주로 internet explorer 호환이 되지 않는다.)
간혹 Edge에서 호환되지 않는데, PostCSS를 활용하여 사용할 수 있다.<br>

https://caniuse.com/  : CSS 문법 호환성 확인 Site
