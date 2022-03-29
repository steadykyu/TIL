# 1. 콘솔에 출력하기

node.js를 이용하면 web환경이 아닌 cmd console 환경에서도 javascript를 실행할 수 있다.

또는 Web에 출력후 개발자모드를 가면 확인 할 수 있다.

> API(Application Programming Interface)

```
javascript가 아닌 **Web browser**가 제공하는 browser가 이해할 수 있는 함수들이다.

아래 링크는 console 함수에 관한 API다.

https://developer.mozilla.org/ko/docs/Web/API/Console_API
```

- 개발자 모드의 console 창에서는 여러 javascript 코드를 입력 할 수 있다.

- Source 창에서는 debug를 하기에 용이하다.

- Network를 통해 데이터가 잘 오고가는지 확인할 수 있다.

등등 여러 기능들이 존재하고 있으니 꼭 공식사이트에 서 확인하자.

- 공식사이트 : ecma-international.org
- 가독성이 좋은 사이트 : https://developer.mozilla.org

# 2. asycn vs defer

HTML에서 javascript를 포함할때, 어떻게 포함하는 것이 효율적인지를 알아보자

### case 1

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_1.png" width ="50%" height = "50%">
</p>

HTML을 파싱후 DOM객체로 만든다. 이후 main.js를 fetching(가져오고) executing 한다. 이후 다시 HTML을 파싱한다.

이는 JS가 만약 매우 거대한 파일이라면, site 동작이 멈추게 될 것이다.

### case 2

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_2.png" width ="50%" height = "50%">
</p>

js 전에 페이지를 볼수 있다. 단점은 만약 사용자가 의미있는 정보를 얻기 위해서 javascript를 사용해야하는 상황이라면(동적으로 꾸미거나, 서버에서 데이터를 가져오는 일 등), 정적 페이지만 보고 있어야한다.

### case 3

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_3.png" width ="50%" height = "50%">
</p>

boolean type의 asyn를 사용한 경우로 병렬로 js파일을 다운로드 한다. 다운로드 fetching이 완료되면 html에 blocked를 걸고 실행을 시작한다.

단점은 HTML 이 완료되기전에 js가 실행이 된다. 그러므로 만약 HTML에 필요한 요소가 파싱 되기전에 js에서 HTML의 요소를 사용하는 작업이 있을 수 있다.(위험1) <br>
blocked 되는 시간이 존재하므로 사용자가 Web을 보는데 시간이 더 필요하다.(위험2)

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_5.png" width ="50%" height = "50%">
</p>

여러 async가 있는 경우, 순서에 상관없이 먼저 fetching 되는 js를 executing 한다. 이는 만약 그림의 b가 a에 의존적인 js code라면 문제가 발생 할 수 있다.(아래 defer 와 비교해보자.)

### case 4 - defer

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_4.png" width ="50%" height = "50%">
</p>

pasring 도중 defer를 만나면, js를 fetching 한다. HTML이 모두 parsing 된 후에 executing js를 하게 된다.

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_2_6.png" width ="50%" height = "50%">
</p>

async 와 다르게 defer 한 순서대로 execting 하기 때문에, 상대적으로 안전하다고 볼 수 있다.

# 3.use strict

순수 바닐라 javascript를 사용할 때는 이 use strict를 사용하는 것이 좋다.

> why?

```
이전 노트에 있듯이 초창기의 javascript는 빠른 시간안에 만들어야 했기 때문에 매우
flexible 하게 제작이 되었다. 이 flexible한 점은 반대로 dangerous 하다는 의미이기도 하다.

그래서 ECMAScript 5 를 적용시키기위해 'use strict'를 사용한다.
이는 조금 더 다른 언어 개발자들에게 상식적인 개념을 도입시켜주고, 실행에 있어서의 성능 개선까지 해준다.

ex) 일반 언어들과는 다르게 변수를 선언하지 않고도, 할당 할수 있다.
이런 점은 개발자들에게 혼란을 일으켰다.
```

# 출처

https://www.notion.so/277f2906743742ae8f19b6494581058f

또는

https://academy.dream-coding.com/courses/javascript
