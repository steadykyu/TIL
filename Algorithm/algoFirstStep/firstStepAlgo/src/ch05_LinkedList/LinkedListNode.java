package ch05_LinkedList;

/**
 * 데이터 덩어리(Node)를 이용한 LinkedList
 */
class LinkedListNode {
    Node head;
    class Node{
        int data;
        Node next;
        // 새로운 Node를 생성하는 생성자
        Node(int d){
            data = d;
            next = null;
        }
    }

    // Linked List 맨 앞쪽에 Node를 넣는 함수 - O(1)
    public void pushFirst(int newData){
        Node newNode = new Node(newData);
        // 삽입되는 Node는 head의 주소를, 이전 맨 앞 Node에는 삽입되는 Node의 주소값을 넣어준다.
        newNode.next = head;
        head = newNode;
    }

    // 중간에 삽입하는 함수 - O(1)

    public void insertAfter(Node prevNode, int newData){
        if(prevNode == null){
            System.out.println(
                    "이전 노드가 null 일 수 없습니다.");
            return;
        }

        Node newNode = new Node(newData);
        // 새로운 Node에는 이전 Node가 가리키는 주소값을 삽입한다.
        // 이전 Node에는 새로운 Node의 주소값을 삽입하면 된다.
        newNode.next = prevNode.next;

        prevNode.next = newNode;
    }

    // 마지막에 삽입하는 함수 - O(N)
    public void appendLast(int newData){
        /* 1. Allocate the Node &
        2. Put in the data
        3. Set next as null */
        Node newNode = new Node(newData);

        /* 4. If the Linked List is empty, then make the
        new node as head */
        if(head == null){
//            head = newNode;
            head = new Node(newData);
            return;
        }
        /* 4. This new node is going to be the last node, so
        make next of it as null */
        newNode.next = null;

        /* 5. Else traverse till the last node */
            // lastNode를 찾기 위해 head 부터 loop한다.
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        /* 6. Change the next of last node */
        last.next = newNode;
        return;
    }

    public void printList(){
        Node iter = head;
        while(iter != null){
            System.out.printf("data: " + iter.data + ", pointer: " + iter.next + "\n");
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode LLN = new LinkedListNode();
        LLN.pushFirst(1);
        LLN.appendLast(10);
        LLN.printList();
//        LLN.insertAfter(3);
    }
}
