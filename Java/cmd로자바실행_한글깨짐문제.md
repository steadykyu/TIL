# 기본적인 개념
## cmd 명령어
```
- javac : .java 파일을 컴파일 하여, 현재 디렉토리에 .class 를 생성한다. 
          -d를 통해 경로를 지정해줄 수 있다.
- java : .class 파일을 실행한다.
```
## 환경 변수
+ C:\Program Files\Java\jdk-11.0.13\bin 폴더안을 보면 java.exe , javac.exe 파일이 존재한다. 
+ cmd에서 명령어를 입력하면 이 실행파일들이 실행 되는 것이다.
```
우리가 등록한 환경변수는 cmd창에서 java명령을 치면 운영체제가 현재 명령을 내린 위치의 경로에 java.exe가 존재하는지를 확인한다
만약 없다면 PATH를 참조해서 PATH 목록의 디렉토리를 하나하나 찾아보면서 java.exe를 찾는다.
그렇기 때문에 우리는 cmd창 어느경로에서도 저 두 실행파일을 사용할 수 있는것이다.
```

## 문제 
1. java 로 인텔리제이안 .class를 실행하면 메인클래스가 없다면서 실행되지 않았다. (해결법 참고)
2. IDE폴더의 .java 파일을 실행시켰으나 글자가 깨지는 문제가 발생했다.

> 실행할 자바코드
```java
class ArrayEx16 {
    public static void main(String[] args) {
        System.out.println("매개변수 개수:"+args.length);

        for(int i=0;i< args.length;i++) {
            System.out.println("args[" + i + "] = \""+ args[i] + "\"");
        }
    }
}
```
+ mainclasserror
### 해결법 
#### 문제 2 해결
```
- .java파일을 cmd에서 컴파일하면 Ms 운영체제의 디폴트인 cp949로 cmd가 인코딩을 해서 글자가 깨졌다. 
- javac ArrayEx16.java -encoding UTF-8 로 해결(컴파일을 UTF-8)로 인코딩함
```

#### 문제 1 해결
+ 환경변수의 %JAVA_HOME%\bin.;  으로 수정하였다. bin뒤에 ".;"를 붙였다.
```
- PATH에서 설정해놓은 경로에 해당 클래스(.class)가 없기 때문에 에러가 발생하는 것이다.
- 그러므로 현재 경로를 뜻하는 .;를 붙여 현재 경로의 class파일을 찾을수 있도록 만들었다.
```
+ 그래도 바로 문제가 해결되지가 않았는데 다음과 같은 작업을 진행하였다.
mainclasssolution

+ javac는 소스코드가 있는 패키지 않에서 진행해야했지만
+ java 패키지.클래스명 으로 처리해야 문제가 발생하지 않았다. 


## 참고
https://javakong.tistory.com/131#:~:text=%E2%96%B6%20javac%20%EA%B0%80%20%EC%9E%88%EB%8A%94%20%EC%9C%84%EC%B9%98,%EB%95%8C%20%EC%8B%A4%ED%96%89%EB%90%98%EB%8A%94%20%ED%8C%8C%EC%9D%BC%EC%9D%B4%EB%8B%A4.
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=vidaafeliz&logNo=221618018156
