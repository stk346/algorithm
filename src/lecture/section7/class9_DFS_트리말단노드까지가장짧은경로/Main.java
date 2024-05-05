package lecture.section7.class9_DFS_트리말단노드까지가장짧은경로;

public class Main {
    Node root;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.rt.lt = new Node(4);
        tree.root.rt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }

    private int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        }
        else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }
}

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}