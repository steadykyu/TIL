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
