# 1.Spring 과 OOP의 관계

먼저 Spring과 OOP를 같이 알고 있어야 하는 이유를 알아보자. 그 이유는 아래와 같다.

## Spring 의 핵심 컨셉은 무엇인가?

좋은 객체지향App을 개발할 수 있도록, 객체지향언어 Java의 특징을 조금더 쉽고 잘살려내주도록 해주는 프레임 워크이다. 이러한 핵심 컨셉에 추가적으로 기술들이 만들어 지고 있는 상태이다.

그러므로 우리는 Spring의 도움을 받아 **좋은 객체지향 프로그래밍**을 하려고 노력해야한다.

# 2.객체 지향 프로그래밍(Object Oriented Programming)

[객체지향언어](https://github.com/steadykyu/TIL/blob/master/Java/lamda.md)

## 2.1 사전적 정의

Object-oriented programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code: data in the form of fields (often known as attributes or properties), and code, in the form of procedures (often known as methods).

In OOP, computer programs are designed by making them out of objects that interact with one another.

객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러개의 독립된 단위, 즉 "객체"들의 모임으로 파악하고자 하는 것이다. 각각의 객체는 메시지를 주고받고, 데이터를 처리할 수 있다. (협력)

## 2.2 Why OOP?(간략히)

OOP를 써야하는 이유에는 정말 너무 많은 이유가 있지만, 현재 내 수준에서 이해할수 있는 사용이유는 다음과 같다.

1. 코드의 재사용성

2. 코드의 유지보수의 용이성

3. 중복된 코드 제거

## 2.3 좋은 객체지향 프로그래밍이란?

- Objects 들의 상호작용(협력)으로 만들어지는 OOP가 좋은 설계로 이어지려면 **유연하고 변경이 용이**해야한다.

- [객체지향의 4가지 특징](https://github.com/steadykyu/TIL/blob/master/OOP/OOP%EC%9D%98_4%EA%B0%80%EC%A7%80%ED%8A%B9%EC%A7%95.md) 이 존재해야한다.(추상화, 캡슐화, 상속성, 다형성)

이 4가지 특징중 유연하고 변경을 용이하게 해주는 특징, 다형성에 대해서 알아보자.

# 3. 다형성

- **다형성**은 실세계에 비유해보자면 **역할과 구현**으로 세상을 구분하는 개념으로, 위에서 말한 프로그래밍을 유연하고 변경을 용이하게 만들어 설계 과정에서 중요하게 사용된다.

## 3.1 역할과 구현의 분리

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/OandS_1.png">
</p>

- ex) 운전자는 운전자 역할만 알고있고 자동차는 자동차역할에 알맞은 자동차만 구현한다면 운전자는 자동차의 내부모델을 몰라도 된다.

- 핵심은 클라이언트가 <br>
  첫째, 구현 대상의 내부 구조를 몰라도(차내부)<br>
  둘째, 구현 대상의 내부 구조가 변경이 되어도(차 내부가 변경)<br>
  셋째, 구현 대상 자체를 변경해도 (차 종류를 변경)<br>
  영향(코드의 변화)을 받지 않아야 한다는 것이다.

- 이를 자바언어에 대입한다면 역할은 **interface**, 구현은 **class(객체)**rk 된다. 역할과 구현으로 구분하면 세상이 단순해지고 유연해지며 변경도 편리해진다.

```
클라이언트는 대상의 역할(인터페이스)만 알면 된다.
첫째, 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
둘째, 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
셋째, 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
```

조금 이해가 가지 않는다면 아래 그림을 통해 이해해보자.

객체 클라이언트는 요청을 , 객체 서버는 응답하는 관계로 서로 협력 관계를 가진다.

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/OandS_2.png">
</p>

현재 interface(역할) MemberReporitory의 save() 메서드를 구현체들이 overriding 하고 있다. 다형성으로 인해 MemberReporitory의 save()를 호출하는 MemberService 라는 객체는 내부구조를 몰라도, 구조가 변경되어도, 대상자체가 변경(MMR -> JMR)되어도 아무런 문제가 없다. 이말은 결국 유연하게 변경할 수 있다는 결론으로 도달한다.

```java
Public class MemberService {
// private MemberRepository memberRepository = new MemoryMemberRepository();
 private MemberRepository memberRepository = new JdbcMemberRepository();

}
```

위 두 코드는 클라이언트 객체 입장에서는 아무런 영향을 받지않는다.(코드의 변화가 없다.) 그저 변경상황(비즈니스 상황)에 알맞게 구현체만 바꿔 껴주면 되는것이다.

> 정리

- 실세계의 역할과 구현이라는 편리한 컨셉을 다형성을 통해 객체 세상으로 가져올 수 있음
- 유연하고, 변경이 용이한 프로그래밍이 가능하다.
- 확장 가능한 설계가 가능
- 클라이언트에 영향을 주지 않고 변경 가능
- 인터페이스를 안정적으로 잘 설계하는 것이 중요하다.

## 3.2 역할과 구현을 분리했을때의 한계

- 역할(인터페이스) 자체가 변하면, 클라이언트, 서버 모두에 큰 변경이 발생한다.

```
• 자동차를 비행기로 변경해야 한다면?
• 대본 자체가 변경된다면?
• USB 인터페이스가 변경된다면?
```

그러므로 인터페이스를 안정적으로 잘 설계하는 것이 중요하다.

스프링은 다형성을 이러한 다형성을 극대화 할수 있도록 도와준다.<br>
[Ioc](https://github.com/steadykyu/TIL/blob/master/spring/IOC.md)(제어의 역전), [DI](https://github.com/steadykyu/TIL/blob/master/spring/DI.md)(의존관계 주입)은 **다형성을 활용해서** 역할과 구현을 편리하게 다룰 수 있도록 지원해 준다.
