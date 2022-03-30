# 1. Overloading이란?

## 1.1 정의

> 사전적 정의

```
to put too many things in or on something:
```

메서드는 같은 클래스 내에서 서로 구별될수 있어야하기 때문에 각기 다른 이름을 가져야한다. 그러나 자바에서는 한 클래스 내에 같은 이름의 메서드를 여러개 정의하는 method overloading 기능을 제공한다.

## 1.2 조건

```
1. 메서드의 이름이 같아야한다.
2. 매개변수의 개수 또는 타입이 달라야한다.
```

참고로 메서드의 반환 타입은 오버로딩을 구현하는데 아무런 영향을 끼치지 못한다.

## 1.3 장점

우리가 자주 쓰는 println 또한 오버로딩의 대표적인 예이다. int값이 들어오든, boolean타입이 들어오든, double이 매개변수로 들어오든 모두다 출력해주는 모습을 볼수 있다.

첫째, 오버로딩을 통해 여러 메서드들이 같은 이름의 메서드(println)로 정의 될 수 있다. 이를 통해 사용하는 클라이언트 입장에서는 기억하기도 쉽고, 오류의 가능성도 많이 줄일 수 있다.

둘째, 메서드의 이름을 절약할 수 있다.

셋째, 인정할것인지 아닌지 여러 이견이 존재하지만 가장 쉬운 다형성의 예 중 하나이다.

## 1.4 예시

```java
class O{
    public void a(int param){
        System.out.println("숫자출력");
        System.out.println(param);
    }
    public void a(String param){
        System.out.println("문자출력");
        System.out.println(param);
    }
}
public class PolymorphismOverloadingDemo {
    public static void main(String[] args) {
        O o = new O();
        o.a(1);;
        o.a("one");
    }
}
```

## 1.5 가변인자와 오버로딩

JDK1.5부터부는 매개변수를 고정하지 않고, 동적으로 지정해줄 수있는 **가변인자** 기능이 있다.

가변인자를 매개변수로 선언한 메서드를 오버로딩하게 되면, 메서드들끼리 구별을 하지못해 컴파일 에러가 발생할 확률이 매우 높다. **그러므로 가변인자가 존재하는 메서드는 오버로딩하지 않는것이 좋다.**

## 출처

## 오버로딩

- 자바의 정석
- https://opentutorials.org/module/516/6127

# 2. Overriding이란?
