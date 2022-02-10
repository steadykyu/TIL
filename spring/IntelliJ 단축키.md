# 글의 목적
앞으로 Spring을 사용하는데 있어, IntelliJ 단축키들을 잘 알고 있으면 생산성을 높일 수 있을 것이라 생각함.

# 목차 
- [alt+enter](#altenter)
- [F2](#f2)
- [alt+1 and esc](#alt1-and-esc)
- [ctrl+e](#ctrle)
- [ctrl+b](#ctrlb)
- [alt+f7](#altf7)
- [shift+ctrl+enter](#shiftctrlenter)
- [ctrl+alt+l](#ctrlaltl)
- [Shift+Ctrl+Alt+T](#shiftctrlaltt)
- [shift+ctrl+a](#shiftctrla)
- [특성상황에 쓰지만 알면 편한 단축키](#특성상황에-쓰지만-알면-편한-단축키)
## alt+enter
이 키보드 단축키는 현재 컨텍스트에 대한 액션을 표시하여 뭐든지 수정하는 데 사용할 수 있습니다.

참고) 컨텍스트 
사전적의미 :  문맥이나 환경, 정황등의 뜻.<br>
소프트웨어 관점 : 상황에 맞게끔, 실행/판단/결정 등을 해야하는 부분. or 그 메뉴를 호출한 동작 및 상황에 따라, 서로 다른 선택 사항들이 나열되는 메뉴

## F2
에디터에서 오류와 경고 사이를 이동할 때 마우스를 사용하고 싶지 않다면 F2로 경고창을 확인 해 볼수 있습니다.
alt+enter와 자주 쓰입니다.

## alt+1 and esc
코드창에서 도구창(디렉토리, 클래스, 인터페이스등이 있는 창)으로 넘어가게 해줍니다.
esc를 누르면 원래 포커스로 돌아옵니다.

## ctrl+e
 최근 실행했던 파일을 확인할 수 있습니다. 방향키로 움직입니다.
 
## ctrl+b
코드 안에서 다른 코드로 이동하고 싶을 때, Ctrl+B(Windows/Linux)를 사용하면 심볼의 선언으로 이동.
ex) 필드 위에서 이 단축키를 누르면 커서가 해당 필드의 선언으로 이동합니다. <br>
    클래스 이름 위에서 누르면 해당 클래스 파일로 이동합니다. 
    
## alt+f7
Alt+F7을 누르면 어떤 항목이 사용된 모든 곳이 표시됩니다.
ex) 인터페이스 이름 위에서 Alt+F7을 누르면 인터페이스를 구현하는 것이 필드 선언이든 클래스이든 상관 없이 <br>
해당 인터페이스가 사용된 모든 곳이 검색 창에 표시

## shift+ctrl+enter
현재 구문 완성
+ 대부분의 경우 단순히 코드 끝에 세미콜론을 추가하는 것
+ “for” 루프를 작성하는 중 이 단축키를 누르면 IntelliJ IDEA가 중괄호를 추가하고 블록 안에 커서를 배치
+ if” 문에서는 괄호 및 중괄호를 추가하고 역시 적당한 위치에 커서를 배치

## ctrl+alt+l
Ctrl+Alt+L(Windows/Linux)을 사용하여 해당 프로젝트의 표준에 맞도록 현재 파일의 서식을 지정할 수 있습니다.
+ 중괄호, line등을 표준에 맞게 맞춰준다.

## Shift+Ctrl+Alt+T
IntelliJ IDEA에서 대부분의 자동화된 리팩토링은 자체적인 단축키가 있지만, <br>
Shift+Ctrl+Alt+T(Windows/Linux)를 사용해 전체에 액세스할 수 있습니다.
심볼 또는 선택 영역 위에서 이 단축키를 누르면 사용 가능한 리팩토링 옵션이 표시됩니다. 

## shift+ctrl+a
모든 단축키를 기억할 수는 없다.
이 단축키로 IntelliJ IDEA에서 모든 액션(단축키효과)을 검색할 수 있습니다.

## 특성상황에 쓰지만 알면 편한 단축키
+ ctrl + p : 파라미터 정보 옵션을 준다.
+ alt + insert : 반복적인 작업 소스들을 generate시키기 ex) getter,setter, constructor 등등
+ shift + f6 : 모든 변수 rename
+ ctrl + alt + v : (커서가 있는 메서드의 리턴값)변수 추출하기.
+ ctrl + alt + m : 메서드 추출하기
+ ctrl + shift + T : main()의 클래스위에 커서를 두고 누를시, 바로 패키지와 test class의 뼈대를 만들어 준다.
+ ctrl + click : 해당 클래스로 들어가기.(단축키)
+ ctrl + alt + N : inline variable 만들기.(단축키)
