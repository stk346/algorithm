package lecture.section7.class1;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        T.DFS(3);
    }

    // D(3) -> D(2) -> D(1) ...
    private void DFS(int n) {
        if (n == 0) {
            return;
        }
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
