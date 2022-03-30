# 목차

- [람다 왜 사용할까?](#람다-왜-사용할까)
- [어떻게 사용할까?](#어떻게-사용할까)
  - [람다식문법](#람다식문법)
    - [1.매개변수 자료형과 괄호 생략하기](#1매개변수-자료형과-괄호-생략하기)
    - [2.중괄호 생략하기](#2중괄호-생략하기)
    - [3.return 생략하기](#3return-생략하기)
  - [람다식 사용하기](#람다식-사용하기)
    - [1.함수형 인터페이스로 사용하기](#1함수형-인터페이스로-사용하기)
    - [2.익명 객체를 생성하는 람다식](#2익명-객체를-생성하는-람다식)
    - [3.함수를 변수처럼 사용하는 람다식](#3함수를-변수처럼-사용하는-람다식)

# 람다 왜 사용할까?

- 원래의 자바는 객체 기반 언어이다. 그러므로 **_클래스가 없으면 메서드를 사용할 수가 없다._**
- 함수형 프로그래밍은 함수의 구현과 호출만으로 프로그래밍하는 방식이다.(객체 프로그래밍에 비하여 훨씬 간결하게 사용 가능하다.)
- 최근 함수형 프로그래밍의 장점이 대두되면서 Java도 함수형 프로그래밍 방식인 **람다식**을 제공하고 있다.

# 어떻게 사용할까?

## 람다식문법

```
(매개변수 모음) -> {실행문;}
(int x, int y) -> {return x+y;}
```

### 1.매개변수 자료형과 괄호 생략하기

- 매개변수가 한개일때는 ()생략이가능하다.

```
str -> {System.out.println(str);}

틀린경우
x,y -> {System.out.println(x + y);}
```

### 2.중괄호 생략하기

- 중괄호 안의 구현 부분이 한 문장인경우 중괄호 생략이 가능하다.
- return문이 있을경우 중괄호 생략이 불가능하다.

```
str -> System.out.println(str);

틀린경우
str -> return str.length();
```

### 3.return 생략하기

- 중괄호 안의 구현부분이 return문 하나라면, 중괄호와 return을 모두 생략하고 식만 쓸 수 있다.

```
x, y -> x + y
str -> str.length()
```

## 람다식 사용하기

### 1.함수형 인터페이스로 사용하기

인터페이스 선언

```java
@FunctionalInterface
public interface MyNumber {
//	추상메서드 선언
	int getMax(int num1, int num2);
  int getAdd(int num1, int num2); // 오류발생

}
```

```java
public class TestMyNumber {

	public static void main(String[] args) {

		MyNumber max = (x, y) -> (x >= y) ? x : y;             //생략한 모습
		MyNumber max2  = (x, y) -> {return (x >= y) ? x : y;}; //원본 모습
		MyNumber add  = (int x, int y) -> {return x + y;};

		System.out.println(max.getMax(10, 20));
    System.out.println(add.getMax(10, 20));

	}
}
```

- 함수형 인터페이스자료형 "max"에 람다식을 구현되있는 상태의 인터페이스가 된다.
- 자바는 참조 변수(클래스,인터페이스에 대한)없이는 메서드를 호출할 수 없는 모습과 대비된다.
- "max"로 구현할 수도 있고, "add"로 구현 할 수도 있다.
- 함수형 인터페이스는 단 **_하나의 메서드만_** 추상메서드로 선언할 수 있습니다. 여러 추상메서드가 존재한다면 어느것을 구현해야 할지 모호해지기 때문입니다.

### 2.익명 객체를 생성하는 람다식

```java
public interface StringConcat {

	public void makeString(String s1, String s2);

}
```

인터페이스 생성

```java
public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = "World";
    int i = 300;                            //main 메서드의 지역변수 i 는 300

//	-------------------------------------------------------익명 객체를 생성하는 람다식
		StringConcat concat2 = (s, v)->{        //자료형이 안터페이스인 concat2에 람다식을 구현
//  i = 200;   상수값이 되어있기 때문에 오류발생.
    System.out.println(s + "," + v );
    System.out.println(i);
    }
		concat2.makeString(s1, s2);

	}
```

- main 메서드의 지역변수 i 는 300 이다.
- 만약 람다식에서 i를 200으로 바꾸려고 하면 에러가 발생한다.
- 일단 람다식의 결과는 익명 내부클래스를 생성하는 것과 같은 기술이다.
- 지역 변수는 메서드 호출이 끝나면 메모리에서 사라지기때문에, 익명 내부 클래스에서 사용하는 경우에는 지역변수가 상수(final)로 변한다.
- 그러므로 람다식도 외부클래스의 지역변수가 람다식안에서는 상수값으로 쓰인다.

### 3.함수를 변수처럼 사용하는 람다식

```java
//--------------------------------------인터페이스 생성
interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		PrintString lambdaStr = s->System.out.println(s);  //람다식을 인터페이스형 변수에 대입
		lambdaStr.showString("hello lambda_1");

		showMyString(lambdaStr);                          //람다식lambdaStr를 메서드 매개변수로 전달
		PrintString reStr = returnString();               //returnString는 함수형 인터페이스를 반환해준다.
		reStr.showString("hello ");                       //그 인터페이스 안에서 구현된 showString 메소드가 호출된다.
	}

	public static void showMyString(PrintString p) {
		p.showString("hello lambda_2");
	}

	public static PrintString returnString() {         //리턴값(구현한식)을 람다식의 인터페이스자료형으로 받음.
		return s->System.out.println(s + "world");
	}
}


```

#### 1.인터페이스형 변수에 람다식 대입

- 위 코드의 lambdaStr의 메서드를 호출하면 "hello lambda_1" 출력

#### 2.매개변수로 전달하는 람다식

- showMyString메서드에 구현한 람다식 lambdaStr를 메서드 매개변수로 전달
- lambdaStr 인터페이스의 추상메서드showString에 "hello lambda_2" 를 넣는다.
- 구현한 식이 호출되어 "hello lambda_2" 출력된다.

#### 3.리턴값으로 쓰이는 람다식

- 함수형 인터페이스 자료형 reStr에 returnString()의 리턴값으로 넣으면서 람다식을 구현함.(2랑 기술은 같은데 다른 표현법)
- reStr속 showString 메서드에 문자값이 들어가면, 구현한 람다식에 문자값이 들어가 "hello world" 출력

## 참고

DOITJAVA 자바프로그래밍 입문
