## 0. 글을 읽기 전에

최소한 [DI](https://github.com/steadykyu/TIL/blob/master/spring/DI%2CIOC.md) 의 상황요약을 보고오자.

DI, IOC 부분을 읽고 오면 더 좋다.

## 1. 기존 순수 Java code vs Spring code

객체(구현체) 생성, 연결, 관리 를 담당하는 구성영역 속 AppConfig의 경우 다음과 같이 변화한다.

> Java code Appconfig

```java
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
```

> Spring code Appconfig

```java
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
```

- AppConfig에 설정을 구성한다는 뜻의 @Configuration 을 붙여준다.

- 각 메서드에 @Bean 을 붙여준다. 이렇게 하면 스프링 컨테이너에 스프링 빈으로 등록한다.

# 2. 회원 Main 함수에 스프링컨테이너 적용

```java
public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext =
                        new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
```

# 3. 주문 Main 함수에 스프링 컨테이너 적용

```java
public class OrderApp {
        public static void main(String[] args) {

//            AppConfig appConfig = new AppConfig();
//            MemberService memberService = appConfig.memberService();;
//            OrderService orderService = appConfig.orderService();

            ApplicationContext applicationContext = new
                    AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService =
                    applicationContext.getBean("memberService", MemberService.class);
            OrderService orderService =
                    applicationContext.getBean("orderService", OrderService.class);

            //member 생성
            long memberId = 1L;
            Member member = new Member(memberId, "memberA", Grade.VIP);

            memberService.join(member);

            Order order = orderService.createOrder(memberId, "itemA", 10000);

            System.out.println("order = " + order);
        }
}
```

- ApplicationContext 를 스프링 컨테이너라 한다.

- 기존에는 개발자가 AppConfig 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.

- 스프링 컨테이너는 @Configuration 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다. 여기서 @Bean이라 적힌 **메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록**한다. 이렇게 스프링 컨테이너에
  등록된 객체를 스프링 빈이라 한다.

- 스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ( memberService ,orderService )

- 이전에는 개발자가 필요한 객체를 AppConfig 를 사용해서 직접 조회했지만, 이제부터는 스프링 컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야 한다.

- 스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.

- 기존에는 개발자가 직접 자바코드로 모든 것을 했다면 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.

## 정리

스프링 컨테이너와 스프링 빈으로 바꾸면서 어떤점이 좋아졌을까?
아래 링크를 따라 내용을 정리해보자.
[스프링 컨테이너와 스프링 빈]()

# 출처

인프런 - Spring 핵심 기본편 - 김영한
