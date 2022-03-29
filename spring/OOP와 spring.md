# 1.Spring 과 OOP의 관계

먼저 Spring과 OOP를 같이 알고 있어야 하는 이유를 알아보자. 그 이유는 아래와 같다.

## Spring 의 핵심 컨셉은 무엇인가?

좋은 객체지향App을 개발할 수 있도록, 객체지향언어 Java의 특징을 조금더 쉽고 잘살려내주도록 해주는 프레임 워크이다. 이러한 핵심 컨셉에 추가적으로 기술들이 만들어 지고 있는 상태이다.

그러므로 우리는 Spring의 도움을 받아 **좋은 객체지향 프로그래밍**을 하려고 노력해야한다.

# 2.객체 지향 프로그래밍(Object Oriented Programming)

- 내일 입력

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

<img src= " "OandS_1

- ex) 운전자는 운전자 역할만 알고있고 자동차는 자동차역할에 알맞은 자동차만 구현한다면 운전자는 자동차의 내부모델을 몰라도 된다.

- 핵심은 클라이언트가 <br>
  첫째, 구현 대상의 내부 구조를 몰라도(차내부)<br>
  둘째, 구현 대상의 내부 구조가 변경이 되어도(차 내부가 변경)<br>
  셋째, 구현 대상 자체를 변경해도 (차 종류를 변경)<br>
  영향(코드의 변화)을 받지 않아야 한다는 것이다.

- 이를 자바언어에 대입한다면 역할은 **interface**, 구현은 **class(객체)**rk 된다.

## SOLID-좋은 객체 지향 설계의 5가지 원칙(간략히)

### 1. SRP

### 2.
