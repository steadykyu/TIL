import java.util.*;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}
public class Main {
    Node root;
    public void DFS(Node root){
        if(root==null) return; // 재귀 결과, 말단 노드까지 온 경우
        else{
//            System.out.printf(root.data+ " "); // 전위 순회한다.
            DFS(root.lt);       // 왼쪽 자식노드로 간다.
//            System.out.printf(root.data+ " "); // 중위 순회한다.
            DFS(root.rt);       // 오른쪽 자식노드로 간다.
//            System.out.println(root.data + " "); // 후위 순회한다.
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);    // data 값 설정
        tree.root.lt = new Node(2); // node 값 설정 및 하위 node data 설정
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
