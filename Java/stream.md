# 왜 써야할까
+ 배열, 컬렉션등 여러 자료의 처리에 대한 기능을 미리 구현해 놓음으로써 프로그램의 코드를 간결하고 일관성있게 다루기 위해 스트림 클래스를/을 사용한다.
+ 자료에 따라 새로 구현하는 것이 아니라, 처리해야하는 자료가 무엇인지와는 상관없이 메서드를 호출할 수가 있다.
+ 이런 개념을 자료를 ***추상화***하였다라고 한다.

참고 : 추상화란?(간단하게)
공통의 속성이나 기능을 묶어 이름을 붙이는것. 그리고 불필요한 부분을 생략하고 객체의 속성 중 가장 중요한 것에만 중점을 두어 모델화 하는 것
데이터의 공통된 성질을 추출하여 슈퍼 클래스를 선정하는 개념이다. 그래서 "무엇인가?" 라는 질문에 답변 할수 있도록 한것(printf -> 아 출력이구나)

# 어떻게 써야할까
## 1.스트림 연산
### 중간연산
+ 자료를 거르거나 변경하여 또 다른 자료를 내부적으로 생성
+ ex) filter(), map() 등
### 최종연산
+ 생성된 내부 자료를 ***소모***해가면서 연산을 수행
+ 그러므로 최종연산 이후에는 해당 스트림을 더이상 사용할 수 없습니다.
+ ex) forEach(), count(), sum(), reduce() 등

## 2.스트림 생성하고 사용하기
배열에 사용
```java
import java.util.Arrays;
public class IntArrayTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int sumVal = Arrays.stream(arr).sum(); // 스트림 생성 및 중간연산, 최종연산
		int count = (int) Arrays.stream(arr).count(); // count()의 반환값이 long이므로 int형변환	
	}
}
```
컬렉션(List)에 사용
```java
public class ArrayListStreamTest {

	public static void main(String[] args) {

		List<String> sList = new ArrayList<String>();
		sList.add("Tomas");
		sList.add("Edward");
		sList.add("Jack");
		//-----------------------------1 번
		Stream<String> stream = sList.stream(); //스트림 생성
		stream.forEach(s->System.out.print(s + " "));
		System.out.println();
		//-----------------------------2번
		sList.stream().sorted().forEach(s->System.out.print(s+ " "));
	//	sList.stream().map(s->s.length()).forEach(n->System.out.println(n)); //각 요소들의 length()만 찾아서 출력해줌
	//	sList.stream().filter(s->s.length() >= 5).forEach(s->System.out.println(s));
		
	}
}
```
+ 1번처럼 스트링 객체를 만든 후에 사용할 수 있다.
+ 2번처럼 컬렉션에 바로 스트링으로 연결하여, 중간/최종연산을 할수 있다.

## 3.스트림의 특징
1. 자료의 대상과 관계 없이 동일한 연산을 수행한다.(일관성)
2. 한번 생성하고 사용한 스트림을 사용할 수 없다.(최종연산 - 소모)
3. 스트림의 연산은 기존 자료를 변경하지 않는다. <br>
  (스트림 연산을 위한 메모리 공간이 따로 존재한다.)
4. 스트림의 연산은 중간연산/최종연산이 있다.

## 4.reduce연산
프로그래머가 기능을 지정해줄 수 있다.
JDK에서 제공하는 reduce() 메서드의 정의
```
T reduce(T identify, BinaryOperator<T> accumulator)
```
### reduce 사용하기
람다식으로 구현하기
```java
import java.util.Arrays;

public class ReduceTest2 {
    public static void main(String[] args){
        String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
        System.out.println(Arrays.stream(greetings).reduce("",(s1,s2)->{
            if(s1.getBytes().length >= s2.getBytes().length)
                return s1;
            else return s2;}));
    };
}
```
+ reduce()는 어떤 람다식이 전달되느냐에 따라 다양한 연산 수행이 가능한 최종 연산이다.
+ 초기값 "" 와 "안녕하세요\~\~\~" , "안녕하세요\~\~\~"와 "hello"비교 방식으로 해서 가장 긴 "안녕하세요\~\~\~"가 출력된다.
+ 위는 람다식으로 reduce를 구현한 방식이다.
+ 아래 java 처럼 reduce의 BinaryOperator를 구현해줄 수 있다. 
+ BinaryOperator는 apply() 추상메서드를 가지고 있으므로, apply메서드를 구현해주면 된다.

클래스에 BinaryOperator구현하기
```java
class CompareString implements BinaryOperator<String>{
	@Override
	public String apply(String s1, String s2) {			//BinaryOperator의 apply 추상메서드를 구현해줘야 한다.
		if (s1.getBytes().length >= s2.getBytes().length) return s1;
		else return s2;
	}
}

public class ReduceTest {
	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
		String str = Arrays.stream(greetings).reduce(new CompareString()).get(); //BinaryOperator를 구현한 클래스 이용
		System.out.println(str);		                        
	}
}
```
+ reduce의 BinaryOperator를 구현해줄 수 있다. 
+ BinaryOperator는 apply() 추상메서드를 가지고 있으므로, apply메서드를 구현해주면 된다.
+ reduce(구현메서드) 는 Optional을 반환해준다. 그러므로 get()으로 String 값을 꺼내서 str에 참조시켜주었다.
