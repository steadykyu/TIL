## 요약

다형성 만으로 구현체를 변경하여 Java 코드를 작성하였는데, 이는 OCP 그리고 DIP 원칙을 어겨 좋은 객체지향코드라고 볼수가 없다. 그러므로 우리는 DI를 사용하여야 한다.

- 질문 : 왜 DI를 사용해서 작성해야하는가?

- 다형성으로 만든 객체지향 설계에 부족한 점을 생성자주입을 통한 DI(의존관계 주입)를 함으로써, OCP원칙, DIP 원칙을 지키게 된다.

이런 원칙을 지키게 되면 코드 변경상황이 존재할때(특히 구현체 변경상황이 존재할때) 구성영역의 Config만 코드수정하고, 사용영역은 코드수정은 하지않음에도 불구하고 기능을 늘릴수 있다.<br> 즉 주어진 다양한 문제 상황들을 빠른시간에, 협업에 관점에서도 유리하게 해결 할 수 있다.

# 1. 다형성 만을 이용한 Java code

# 상황 요약

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_1.png">
</p>

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_2.png">
</p>

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_3.png">
</p>

> 회원 서비스 구현체

```java
public class MemberServiceImpl implements MemberService{
// 구현체를 직접주입
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}

```

> 주문 서비스 구현체

```java
public class OrderServiceImpl implements OrderService{
    // 구현체를 직접주입
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 구현체를 직접 주입
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
```

- 할인 정책을 RDP로 바꾸어주었다.
- 역할과 구현 충실히 분리 -> OK
- 다형성을 활용하여, 인터페이스와 객체를 분리 -> OK

> 문제점

- OCP, DIP같은 객체지향설계원칙을 충실히 준수했다 -> NO

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_4.png">
</p>

- 잘보면 클라이언트인 OrderServiceImpl 이 DiscountPolicy 인터페이스 뿐만 아니라 FixDiscountPolicy 인 구체 클래스도 함께 의존하고 있다. 실제 코드를 보면 의존하고 있다! DIP 위반

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_5.png">
</p>

- 중요!: 그래서 FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간 OrderServiceImpl 의 소스 코드도 함께 변경해야 한다! OCP 위반

- MemberServiceImpl 경우에도 마찬가지이다.

- 이러한 코드는 다형성을 이용했지만, 좋은 객체 지향 코드라고 볼 수 는 없다.

# 2. DI를 이용한 Java code

> AppConfig 추가

```java
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
```

## 참고

> 리팩토링한 AppConfig

```java
public class AppConfig {
 public MemberService memberService() {
  return new MemberServiceImpl(memberRepository());
 }
 public OrderService orderService() {
  return new OrderServiceImpl(memberRepository(),discountPolicy());
 }
 public MemberRepository memberRepository() {
  return new MemoryMemberRepository();
 }
 public DiscountPolicy discountPolicy() {
  return new FixDiscountPolicy();
  //return new RateDiscountPolicy();
 }
 // 전부 메서드임을 유의해서 보자.
```

- new MemoryMemberRepository() 이 부분이 중복 제거되었다. 이제 MemoryMemberRepository 를 다른 구현체로 변경할 때 한 부분만 변경하면 된다.

- AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.

---

다시 본론으로 돌아와서

- 이전에는 우리가 MSI(클라이언트)에서 MMR interface의 구현체를 만들었었다.(OSI(클라이언트)에서는 MMR과 FDP 구현체들을 만들었었다.)

- 이제는 Appconfig에서 메서드를 이용하여 구현 객체를 생성하도록 만든다.

```
  new MSI(new MMR)

  new OSI(new MMR, new FDP)
   - OSI는 두개의 구현체가 필요하므로, 두개의 매개변수를 이용한다.
```

- 객체를 생성했으므로 이제 만든 객체를 주입시켜주자.

## 2.2 생성자를 통한 주입

> 회원 서비스

```java
public class MemberServiceImpl implements MemberService{
    // 직접 주입하지 않고, DIP를 위해 추상화(interface)에만 의존시키게 만든다.
    private final MemberRepository memberRepository;

    // 생성자를 통해 주입함.
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
```

> Main 함수(실제 사용해보기)

```java
public class MemberApp {

    public static void main(String[] args) {
        // APPconfig 객체에서 memberService를 생성
        AppConfig appConfig = new AppConfig();
        //appConfig.memberService();에서 생성자 주입이 일어난다.
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
```

1. appConfig 객체는 memberService();메서드 호출시,<br>
   MemoryMemberRepository 객체를 생성하고 이를 매개변수로 한 MemberServiceImpl를 생성한다.

2. 생성자는 인스턴스 객체가 생성될때 변수를 초기화 시킨다. 그러므로 MemberServiceImpl의 생성자가 동작한다. MemoryMemberRepository를 매개변수로 한 MemberServiceImpl(MemberRepository memberRepository) 생성자가 실행한다.

3. MemberServiceImpl 클래스 안의 memberRepository 참조변수에 MemoryMemberRepository 구현체가 주입된다.

4. MSI 입장에서는 MMR의 의존관계가 주입된다. 이렇게 주입되는 관계를 DI 의존관계주입이라고 한다.

- 그리고 이제 MSI는 MR에만 의존하고 있다.(MR 코드만으로 이루어져 있다.) <br> -> DIP 위반해결

- 어떤 객체를 주입할 지는 오직 외부(AppConfig)에서만 결정하고, MSI는 이제 실행에만 집중하면 되는 것이다.

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_6.png">
</p>

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_7.png">
</p>

> 주문 서비스

```java
public class OrderServiceImpl implements OrderService{
    // 직접 주입하지 않고, DIP를 위해 추상화(interface)에만 의존시키게 만든다.
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // 생성자를 통해 주입한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
```

> Main 함수

```java
public class OrderApp {
        public static void main(String[] args) {
            // app config객체생성
            AppConfig appConfig = new AppConfig();
            // MemoryMemberRepository , FixDiscountPolicy 객체를
            // 생성자를 통해 주입할 것이다.
            MemberService memberService = appConfig.memberService();;
            OrderService orderService = appConfig.orderService();

            //member 생성
            long memberId = 1L;
            Member member = new Member(memberId, "memberA", Grade.VIP);

            memberService.join(member);

            Order order = orderService.createOrder(memberId, "itemA", 10000);

            System.out.println("order = " + order);
        }
}
```

1. appConfig 객체는 memberService();메서드 호출시,<br>
   MemoryMemberRepository 객체를 생성하고 이를 매개변수로 한 MemberServiceImpl를 생성한다.

2. appConfig 객체는 orderService();메서드 호출시,<br>
   MemoryMemberRepository 객체, FixDiscountPolicy() 생성하고 이를 매개변수로 한 OrderServiceImpl를 생성한다.

3. 생성자는 인스턴스 객체가 생성될때 변수를 초기화 시킨다. 그러므로 OrderServiceImpl의 생성자가 동작한다. MemoryMemberRepository, FixDiscountPolicy 구현체를 매개변수에 넣은 <br>

OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) 생성자가 실행한다.

4. OrderServiceImpl 클래스 안의 memberRepository 참조변수에 MemoryMemberRepository 구현체가 discountPolicy에 FixDiscountPolicy 구현체가 주입된다.

5. OSI 입장에서는 MMR, FDP의 의존관계가 주입된다.

- 마찬가지로 OSI는 추상화대상인 MR, DP에만 의존하고 있다.<br> -> DIP 위반해결

- 어떤 객체를 주입할 지는 오직 외부(AppConfig)에서만 결정하고, OSI는 이제 실행에만 집중하면 된다.

## 2.3 할인 정책 변경

> OCP 위반 해결

그렇다면 할인정책의 변경으로 FDP 에서 RDP로 변경되었다고 하자.

우리는 그저 Appconfig 에서 다음의 코드만 수정하면 된다.

```java
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
```

- Appconfig의 등장으로 코드들은 이제 구성영역과 사용영역으로 나뉘게 된다.

- 그저 구성영역(Appconfig)에 있는 코드만 변경시키면 된다.

- 기능을 RatePoilcy로 바꿨지만(기능확장), 사용영역의 클라이언트 코드를 변경시키지 않았다.

- 즉 OCP가 지켜지고 있는 모습을 볼수있다.

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_8.png">
</p>

# 정리

# 3. IOC, DI, DI컨테이너

## 3.1 IOC 제어의 역전(Inversion of Control)

처음의(목차 1) 다형성 만으로 만든 프로그램을 보면 클라이언트 구현 객체(MSI,OSI)가 가 스스로 필요한 서버 구현 객체를 생성, 연결, 실행 하면서 모든 흐름을 제어했다.

그러나 DI(목차 2)를 이용한 code를 보면 AppConfig의 등장 이후로 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 이제 AppConfig가 가져간다.

- ex) DI 이후의 OrderServiceImpl 은 필요한 인터페이스들을 호출하지만 어떤 구현 객체들이 실행될지 모른다.

프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다. 즉 객체생성, 객체연결(주입), 심지어 클라이언트 객체생성(MSI,OSI)까지 AppConfig가 제어흐름을 가지고 있는 것이다.

그리고 AppConfig는 OrderServiceImpl 이 아닌 OrderService 인터페이스의 다른 구현 객체를 생성하고 실행할 수 도 있다. 그런 사실도 모른체 OrderServiceImpl은 묵묵히 자신의 로직을 실행할 뿐이다.

다음과 같이 프로그램의 제어 흐름을 해당 객체에서 직접 제어하는 것이 아니라 **외부에서 관리하는 것**을 제어의 역전(IoC)이라 한다.

## 3.2 DI - dependency injection

> 정의

```
In software engineering, dependency injection is a technique in which an object receives other objects that it depends on, called dependencies. Typically, the receiving object is called a client and the passed-in ('injected') object is called a service.
```

의존관계 주입에 알기 전에 먼저 의존관계에 대해서 생각해보자.

- 의존관계는 **정적인 클래스 의존 관계**와, **실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계** 둘을 분리해서 생각해야 한다

> 정적인 클래스 의존관계

- 정적인 의존관계는 애플리케이션을 실행하지 않아도 import 코드만 보고도 분석할 수 있다. 클래스 다이어그램을 생각해보자.

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_9.png">
</p>

OrderServiceImpl 은 MemberRepository , DiscountPolicy 에 의존한다는 것을 알 수 있다.그런데 이러한 클래스 의존관계 만으로는 실제 어떤 객체가 OrderServiceImpl 에 주입 될지 알 수 없다.

즉 의존관계는 알수는 있지만, 어떤 구현체가 들어올 것인지는 알 수 없다.

> 동적인 클래스 의존관계

- 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.

- 객체 다이어그램을 생각해보자.

<p align= "center">
<img src= "https://github.com/steadykyu/TIL/blob/master/spring/img/DI_10.png">
</p>

애플리케이션 **실행 시점(런타임)**에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 **의존관계 주입**이라 한다.

객체 인스턴스를 생성하고, 그 참조값을 전달해서 연결된다.

의존관계 주입(DI)을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.(ex 정액객체-> 정률객체)

의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

> 정리

의존관계 주입(DI)을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

> 주의 : 의존관계와 의존관계 주입은 다른 개념이다.

## 3.3 DI 컨테이너, IOC 컨테이너

AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 DI 컨테이너라 한다.
