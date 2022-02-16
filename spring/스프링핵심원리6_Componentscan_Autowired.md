## 글의 목적
1. 긴 강의내용의 액기스를 모아놓음으로써, 미래의 내가 보기 편하게 하기 위함.
2. 내가 이해하기 어려운 부분을 적어 놓음으로써, 내 머리속에 제대로 지식을 넣기 위함.(weekness)
+ 액기스에 대한 정의
+ 왜 이 기술을 사용하는걸까?(why)
+ 이 기술을 어떻게 활용할 수 있을까?(how)

핵심주제 : 스프링 컨테이너를 왜사용하는걸까?
+ 현재까지의 나의 생각
****
+ App을 만드는데, 좋은객체지향설계로 만들 수 있다.(다형성,OCP, DIP만족시키고, DI를 좀더 편하게 제공)
****
+ BeanFactory 에 있는 빈 조회기능들, 특히 ApplicationContext interface에 있는 부가기능들로 Java App을 제작하는데 도움을 줄 수 있다.
****
+ 다양한 설정 형식을 지원한다.(java 코드로 된 애노테이션 설정 기법에서 , xml을 파일을 통한 설정정보로 교체할 수있다.(굳이 따지자면 다형성)
****
+ 웹사이트는 동시에 오는 요청이 많다. 이에 대해 Bean 컨테이너를 싱글톤패턴으로 만들어 주는 @Configuration을 사용하면 공유하는 객체를 이용하여 메모리 낭비를 줄일 수 있다.
+ @Configuration을 설정정보 클래스(AppConfig.class)에 입력해주면, Bean 컨테이너는 싱글톤 컨테이너로 만들어진다. 
****
+ 스프링빈을 몇천개 만들어야 하는 상황이라면, @Bean을 몇천번 입력해야할 뿐더러 실수가 나올 확률이 클 것이다.
+ 이럴때는 구현체에 @ComponentScan과 @Component, 구현체의 생성자에 @Autowired를 사용하면 스프링이 컨테이너 안에 빈이름과 빈객체을 만들어주고, Autowired룰 방식에 따라 자동으로 DI를 해준다.
+ 그러므로 AppConfig(설정정보)에 작성해야했던 소스코드를 저 두종류의 애노테이션으로 만들 수 있게 된 것이다.

## 목차 

## 컴포넌트 스캔과 의존관계 자동주입 시작하기
###  일단 왜 써야할까?
+ 만약 스프링 빈이 수십, 수백개가 되면 @Bean 입력부터, 거대한 설정정보, 정보누락의 문제가 발생한다.
+ 그래서 스프링은 설정정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.
+ 또 의존관계를 자동으로 주입하는 @Autowired 라는 기능도 제공한다.

+ (나중 공부를 위해) 기존 AppConfig.java는 과거 코드와 테스트를 유지하기 위해 남겨두고, 새로운 AutoAppConfig.java를 만들자.
```java
@Configuration
@ComponentScan(
//   무시     basePackages = "hello.core.member",
//    무시    basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    }
}
```
+ @ComponentScan 을 설정 정보에 붙여주면 된다.
+ 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없지만, 자동으로 스프링 빈에 들어간다.
+ 컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에, AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다.
+ excludeFilters 를 이용해서 @Configuration이 적힌 다른 설정정보들은 컴포넌트 스캔 대상에서 제외했다.
+ 각 클래스가 컴포넌트 **스캔의 대상**이 되도록 @Component 애노테이션을 붙여주자.(구현체들에 붙여주면 된다. MMR, RDP, MSI)
```java
@Component
public class MemoryMemberRepository implements MemberRepository {}
```
+ @Component로 빈 컨테이너에 넣었다.
+ 그런데 컨테이너에 들어만 갔을뿐 의존관계주입이 일어나지 않을 것이다.
```java
@Component
public class MemberServiceImpl implements MemberService {
   private final MemberRepository memberRepository;
   @Autowired
   public MemberServiceImpl(MemberRepository memberRepository) {
      this.memberRepository = memberRepository;
 }
}
```
+ @Autowired는 몇가지 룰로 의존관계를 자동으로 주입해준다.
+ DI가 일어나야하는 MSI와 OSI의 생성자에 @Autowired를 입력해주자.
+ @Autowired 를 사용하면 생성자에서 여러 의존관계도 한번에 주입받을 수 있기때문에, OSI도 똑같이 작업해준다. 
+ 그럼 이전에 우리가 해줬던 것과 일치하게 된다. 확인이 원한다면, package hello.core.scan.filter; 에서 테스트결과를 보자.

### 자동의존관계 주입이 어떻게 동작하는걸까
#### 1. @ComponentScan
+ @ComponentScan 은 @Component 가 붙은 모든 클래스를 스프링 빈으로 등록한다.
+ 이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.(MemberServiceImpl 클래스 -> memberServiceImpl)
+ 빈 이름을 직접 지명하려면 - ex) @Component("memberService2")

#### 2. @Autowired 의존관계 자동 주입
+ 생성자에 @Autowired 를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다.
+ 이때 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다.(만약 타입과 이름이 같다면? - 중복 등록과 충돌 목차에서 확인)
+ getBean(MemberRepository.class) 와 동일한 개념이다.(Autowired가 더 기능이 많다)
+ 생성자에 파라미터가 많아도 다 찾아서 자동으로 주입한다.

## 탐색위치와 기본 스캔대상
```java
@ComponentScan(
   basePackages = "hello.core.member",
   //basePackages = {"hello.core", "hello.service"},
   basePackageClasses = AutoAppConfig.class,
```
+ 모든 자바 클래스를 다 컴포넌트 스캔하면 시간이 오래 걸린다. 그래서 꼭 필요한 위치부터 탐색하도록 시작 위치를 지정할 수 있다.
+ basePackages : 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
+ 여러 시작 위치를 지정할 수도있다.
+ basePackageClasses : 지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
+ **만약 지정하지 않으면** @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
+ 실무에서는 default형태로, 스프링 부트의 대표 시작 정보인 @SpringBootApplication에 두는 것이좋다.(설정 정보 자체가 프로젝트를 대표하는 정보이므로)

### 컴포넌트 스캔 기본 대상
아래의 애노테이션은 @ComponentScan 대상에 포함하도록 스프링이 **기본적**으로 지원하는 기능이다.
+ @Component : 컴포넌트 스캔에서 사용
+ @Controlller : 스프링 MVC 컨트롤러에서 사용
+ @Service : 스프링 비즈니스 로직에서 사용
+ @Repository : 스프링 데이터 접근 계층에서 사용
+ @Configuration : 스프링 설정 정보에서 사용
> 각각 부가기능들이 있다. 이런 애노테이션들은 메타정보이며 이름에 맞는 기능들을 가지고 있다. PT or API 참조
> useDefaultFilters 로 기본스캔대상을 끌수도 있다.
## 필터
+ includeFilters : 컴포넌트 스캔 대상을 추가로 지정한다.
+ excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정한다.
```java
@MyIncludeComponent
public class BeanA {}
```
```java
@MyExcludeComponent
public class BeanB {}
```
+ 포함할 클래스 제외할 클래스에 각각 애노테이션을 붙여준다.
```java
public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
      ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
      BeanA beanA = ac.getBean("beanA", BeanA.class);
      assertThat(beanA).isNotNull();

//      ac.getBean("beanB", BeanB.class);
//      NoSuchBeanDefinitionException 뜨는지 확인
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB",BeanB.class)
        );
    }
//---------------------------------- 설정정보-----------------------------------
    @Configuration
    @ComponentScan(
            //type은 ANNOTATION이 기본 값이라 생략가능
            includeFilters = @Filter(classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcluedIncludeComponent.class)
    )
    static class ComponentFilterAppConfig{
    }
}
```
+ 테스트 코드
+ includeFilters에 MyIncludeComponent 애노테이션을 추가해서 BeanA은 스프링 빈에 등록된다.
+ excludeFilters 에 MyExcludeComponent 애노테이션을 추가해서 BeanB는 스프링 빈에 등록되지 않는다
### FilterType 옵션
+ ANNOTATION: 기본값, 애노테이션을 인식해서 동작한다. ex) org.example.SomeAnnotation
+ ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 동작한다. ex) org.example.SomeClass
+ ASPECTJ: AspectJ 패턴 사용 ex) org.example..*Service+
+ REGEX: 정규 표현식 ex) org\.example\.Default.*
+ CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리 ex) org.example.MyTypeFilter
> 최근 스프링 부트는 컴포넌트 스캔을 기본으로 제공하는데, 개인적으로는 옵션을 변경하면서 사용하기 보다는 스프링의 기본 설정에 최대한 맞추어 사용하는 것을 권장하고, 선호하는 편이다
## 중독 등록과 충돌
### 1. 자동 빈 등록 vs 자동 빈 등록
+ 스프링이 ConflictingBeanDefinitionException 예외를 발생시킨다.
### 2. 수동 빈 등록 vs 자동 빈 등록
+ 이 경우 수동 빈 등록이 우선권을 가진다.(수동한쪽으로 오버라이딩 해준다)
+ 이런 수동이 의도된 방식으로 쓰이기보다는 실수로 작업되는 상황이 많아서 스프링부트에서는 에러가 뜨게 만들어 주었다.
+ 수동으로 빈 이름을 똑같이 만든채, 스프링 부트인 CoreApplication 을 실행해보면 오류를 볼 수 있다.
+ 참고 : 개발자는 처음 코드를 보자마자 어떤 의미인지 알도록 명확하게 인식할수 있도록 짜는게 좋다.(사용자 설정값 이런게 많이 들어갈수록 명확x)
