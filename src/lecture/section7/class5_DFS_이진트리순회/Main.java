package lecture.section7.class5_DFS_이진트리순회;

// 이진트리 순회(깊이우선탐색)
// 전위순회, 중위순회, 후위순회 출력을 연습한다.
// 전위순회 출력: 1 2 4 5 3 6 7 -> 부 - 왼 - 오
// 중위순회 출력: 4 2 5 1 6 3 7 -> 왼 - 부 - 오
// 후위순회 출력: 4 5 2 6 7 3 1 -> 왼 - 오 - 부
public class Main {
    Node root;
    public void DFS(Node root) {
        if (root == null) {
            return;
        }
        else {
//            System.out.print(root.data + " "); // 전위순회
            DFS(root.lt);
//            System.out.print(root.data + " "); // 중위순회
            DFS(root.rt);
//            System.out.print(root.data + " "); // 후위순회
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);

        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }

    public static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }
}
