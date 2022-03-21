# DNS란?
> 사전적 정의
```
도메인 네임 시스템(Domain Name System, DNS)은 호스트의 도메인 이름을 호스트의 네트워크 주소로 바꾸거나
그 반대의 변환을 수행할 수 있도록 하기 위해 개발되었다.
```
예를 들면 우리가 자주 접하는 naver.com , google.com 모두 DNS을 가진 DN(Domain Name)이라고 할 수 있다.
그리고 이들은 사실 문자열의 탈을 쓴 IP라고 볼 수 있다.
그림 4-1

보다시피 google.com 의 IP 주소는 172.217.175.78이 나왔다.

이렇게 DN을 통해 자기 컴퓨터가 사이트의 어느 IP 주소로 연결 되는지 확인 할 수 있다. (자신과 가까운 DNS서버를 통해 IP주소를 받아온다.)

# DNS의 작동원리
그림 4-2

1.웹 브라우저에 "www.naver.com"을 입력하면 먼저 Local DNS에게 "www.naver.com"이라는 hostname"에 대한 IP 주소를 질의하여
Local DNS에 없으면 다른 DNS name 서버 정보를 받음(Root DNS 정보 전달 받음)

> Root DNS란?
```
Root DNS (루트 네임서버) 는 인터넷의 도메인 네임 시스템의 루트 존이다. 
루트 존의 레코드의 요청에 직접 응답하고 적절한 최상위 도메인(TLD)에 대해 권한이 있는 "네임 서버 목록"을 반환함으로써 다른 요청에 응답한다. 
전세계에 961개의 루트 DNS가 운영되고 있다.
```
2.Root DNS 서버에 "www.naver.com" 질의

3.Root DNS 서버로 부터 "com 도메인"을 관리하는 TLD (Top-Level Domain) 이름의 서버 정보를 전달 받음
```
여기서 TLD는 .com을 관리하는 서버를 칭함
아래의 TLD구조 그림 확인
```
4.TLD에 "www.naver.com" 질의

5.TLD에서 "naver.com" 관리하는 DNS 정보 전달

6."naver.com" 도메인을 관리하는 DNS 서버에 "www.naver.com" 호스트네임에 대한 IP 주소 질의

7.Local DNS 서버에게 "www.naver.com"에 대한 IP 주소는 222.122.195.6라고 응답

8.Local DNS는 "www.naver.com"에 대한 IP 주소를 캐싱을 하고 IP 주소 정보 전달

> TLD 구조
그림 4-3 jpg

+ 최상위 ICANN 아래에 REGISTRY, NIC이 있고 REGISTRY 아래에 우리가 흔이 보는 gTLD 그리고 new gTLD가 있다.
+ NIC아래에는 공공사이트에서 쓰는 ccTLD 도메인 주소가 있다.

