```java
    public String solution(String s) {
        String answer = "";
        boolean isfirst = true;
        for(char ch : s.toCharArray()){
            if(ch == ' ') {
                answer += ch;
                isfirst = true;
            }
            else{
                if(isfirst == true) {
                    answer += Character.toUpperCase(ch);
                    isfirst = false;
                }
                else answer+=Character.toLowerCase(ch);
            }
        }
        return answer;
    }
```
String은 불변 데이터이므로 자체적으로 수정하기는 불가하다.

공백글자를 지우지 않고 유지해주어야 하므로, split(" ")는 문제해결을 하지 못했다.
그러므로 한글자씩(char) 작업을 진행했다.

1. charArray로 만든다.

2. 한글자씩 읽으며, 공백인지 글자인지 구별한다.
    + 공백일 경우 그냥 더해준다. 

3. 첫글자 유무를 나타내는 boolean값 isfirst를 적절히 사용해준다.

    + 첫글자 아닌 경우, 소문자로 변환후 더해준다.
    + 첫글자 인경우 대문자로 고친후 더해준다.