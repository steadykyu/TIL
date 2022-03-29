# 학습 목표

## Javascipt의 탄생 배경을 이해해보자.

1. Mosiac Web browser의 탄생
2. Netscape Navigator

```
Mosiac Web에 UI기능을 조금더 추가한 Netscape Navigator 가 탄생하고 시장에 나온다.
```

그러나 이런 Web들은 정적 Web site였다. 결국 동적 웹사이트만들고 싶었던 Mark Andreesen은 scripting 언어를 추가하기로 결심하였다.

이 결과로 scheme script 언어 컨셉을 유지하면서 문법은 당시 인기언어인 Java 스러운 언어를 만들려고 하였다.

3. LiveScript 탄생

Mocha 언어에서 이름을 바꾼 LiveScript가 탄생한다. 이 언어는 Interpreter 를 내장한 언어로  
이 언어에서 작성한 코드는 interpreter를 거쳐, Netscape Navigator browser 에서 작동할 수 있도록(Dom 요소를 조작하도록) 설계되었다.

이후 이름이 변경되어 JavaScript가 되었다.

4. Microsoft의 Jscript

Microsoft가 웹의 가능성을 무한히보고, 이 Javascript를 reverse enginnering(같은 방식으로 언어를 설계)한다. 이는 Jscript로 만들어지고 우리가 아는 Internet explorer Web browser에서 작동하게 된다.

문제는 세계에 Netscape Navigator와 Internet explorer 브라우저가 다른 형식을 지니고 있었기때문에 개발자, 사용자 모두에게 불편함이 존재하였다.

5. Web 표준화

이를 참지못한 JavaScript는 변수명, 함수동작방식 등을 정리한 ECMAScript 문서를 만들게 된다. 또 이 ECMAScript에는 새로운 아이디어들이 추가가 된다.(클래스 방식 등등)
이 사이 Internet explorer는 세계 95%의 점유율을 달성한다.

여러 아이디어들일 합쳐져있는 ECMAScript를 표준으로 사용하자고 Microsoft에게 제안하지만 이미 점유율이 높인 Internet explorer는 이를 거절한다.

이후 또 새로운 방식의 Web browser인 firefox가 등장한다.

이 3 개의 Web이 경쟁하면서 고생하는 시대, 2004년 AJAX 라는 혁신적인 기술이 발명된다.("Asynchronous JavaScript and XML")

```
- Asynchronous Definition
In computer science, asynchronous I/O (also non-sequential I/O) is a form of input/output processing that permits other processing to continue before the transmission has finished.
```

그럼에도 browser 상황은 나아지지 않았고, 결국 개발자 커뮤니티들은 jQuery, dojo, mootools 등의 library를 개발한다. 이런 library의 목적은 **library에서 정의해둔 문법만 사용하면,개발자들이 다른 웹에서의 구현사항을 신경쓰지 않아도 되는 것**이었다.

<p align ="center">
<img src ="https://github.com/steadykyu/TIL/blob/master/BackendRoadMap/2.FrontendBasic/img/js_3_1.png" width ="40%" height = "40%">
</p>

> 좋은 프로그래밍의 철학

```
service layer, business layer, presentation layer등을 만들때 API들을 잘 작성하여 나중에 구현사항이 변경되더라도 이 interface를 사용하는 사용자의 코드는 수정하지 않아도 되는 것이 좋은 프로그래밍이다.
```

6. Chrome 의 탄생
   just-in-time compilation 엔진을 가진 강력한 browser이다.(js의 실행속도가 매우 빠름.) 이때
   여러 Web browser들이 모여 ECMAScript5, 6 .. 들로 표준화 하게 된다.

7. ECMAScript 표준화 이후
   모든 Web들이 ECMAScript 에 따라 구현되도록 만들어 놓았기 때문에 이전의 jQuery 같은 Library없이 Javascript 작성만으로도 원하는 web 구현을 할 수 있게 되었다.

8. Javascript Engines
   각 Web마다 Javascript가 돌아가도록 engine을 가지고 있다. 특히 Chrome에서 사용되는 V8 engine 은 node.js에서도 사용이 된다.

9. BABEL
   모든 사용자들은 Web에서 최신이 아닌 다양한 버전을 사용하고 있다. 이를 위해 개발자는 여러 버전의 코드를 작성해야했다. BABEL은 최신의 ECMAScript로 코드를 작성하면, 이를 각각 Web 버전에 알맞는 ECMAScript version으로 변환시켜주는 기술이다.

10. 현재 Web의 가고 있는 방향

- SPA(Single Page Application)

Web site 를 만드는 것을 넘어, 하나의 page가 있을때, 필요한 부분만 data를 가져오고 부분적 업데이트를 해주는 방식이 유행하고 있다. 이러한 기능을 조금더 편하기 위해 React, Vue, Angular등의 프레임워크들이 탄생하였다.

ECMA script, chrome사의 V8 engine을 통해 Node.js가 탄생하여 Backend Service가 가능해지고 있다.

- WA(Web Assembly)
  이전에는 Web App을 위한 동적언어는 Javascript를 사용해는 것이 편해서 주로 사용했다. 그러나 이제 **WA**를 통해 여러 언어들을 이용해 Web App 을 만드는 것이 가능해졌다.

# 출처

https://www.youtube.com/watch?v=wcsVjmHrUQg&ab_channel=%EB%93%9C%EB%A6%BC%EC%BD%94%EB%94%A9by%EC%97%98%EB%A6%AC
