package ch05_LinkedList;
/**
 * 책은 배열을 이용하여 Linked List를 만들어보고 있다.
 */
// StationList 클래스 정의 ( 사용자 정의 역이름, 연결 정보로 이루어진 구조체)
// 실제 자바의 LinkedList는 아래와 같지 않다. 아래는 간단하게 연결리스트의 자료구조만 보여주는 코드이다.
class StationList {
    public String name; // 역 이름
    public int next; // 연결 정보
}

// 연결 리스트를 다루는 클래스 정의
public class LinkedList{
    // 연결 리스트의 물리적 실체가 되는 배열(요소수는 최대 10)
        // 물리적 : 메모리에 저장되는 실체
    public static StationList[] list = new StationList[10]; // 배열을 이용한 LinkedList

    // head 선언 (연결리스트의 시작점)
    public static int head;

    // 연결 리스트의 초기 상태를 만드는 함수
    public static void initStationList(){
        // 인스턴스 생성
        for(int i=0; i< list.length; i++){
            list[i] = new StationList();
        }

        // 역 이름과 연결 정보를 설정
        list[0].name = "부산";
        list[0].next = -1; // 존재하지 않는 다음 idx -> 마지막 순서를 의미
        list[1].name = "대전";
        list[1].next = 3;
        list[2].name = "서울";
        list[2].next = 4;
        list[3].name = "동대구";
        list[3].next = 0;
        list[4].name = "천안아산";
        list[4].next = 1;

        // head 값 설정
        head = 2;
    }

    // 연결 리스트의 요소를 표시하는 메서드
    public static void printStationList(){
        int idx = head;
        while(idx != -1){
            System.out.printf("[" + list[idx].name + "] -> ");
            idx = list[idx].next;
        }

        System.out.printf("\n");
    }

    // 연결 리스트에 요소를 삽입하는 메서드
        // 역이름 삽입 및 연결 정보를 수정
        // insIdx : StationList 배열에 삽입할 요소의 index
        // insName : `` 삽입할 요소의 역이름
        // preIdx : `` 삽입할 요소의 이전 요소의 index
    public static void insertStationList(int insIdx, String insName, int preIdx){
            list[insIdx].name = insName;
            list[insIdx].next = list[preIdx].next;
            list[preIdx].next = insIdx;
    }

    // 연결 리스트에서 요소를 제거하는 메소드
    public static void deletionStationList(int delIdx, int preIdx){
        list[preIdx].next = list[delIdx].next;
    }

    // 자바 프로그램 기본 시작점인 main 메서드
    public static void main(String[] args) {
        initStationList();
        printStationList();

        // 연결 리스트에 요소를 삽입하여 표시
            // 이전 요소 (idx:2-서울) 객체 다음에 광명이 삽입되도록 함수
        insertStationList(5, "광명", 2);
        printStationList();

        // 연결 리스트에서 요소를 제거하여 표시
        deletionStationList(5,2);
        printStationList();
    }
}

// 다만 위 임시 연결리스트의 구조의 삽입 함수는 StationList의 idx에 위치하는 역이름의 다음 순서에 삽입되도록 만들어져있다.
// 그러므로 만약 연결리스트의 맨앞에 삽입을 하려는 경우, 배열의 크기가 고정되어 있기때문에 이미 선언한 "배열" StationList과 문제가 발생한다.


