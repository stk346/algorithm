package lecture.section7.class2;

public class Main {

    public static void main(String[] args) {
        // 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
        // 11 -> 1011
        Main T = new Main();
        T.DFS(11);
    }

    private void DFS(int n) {
        if (n == 0) {
            return;
        }
        else {
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }
}
// D(0) - return;
// D(1) - D(0) -> 18line -> 1
// D(2) - D(1) -> 18line -> 1
// D(5) - D(2) -> 18line -> 1
// D(11) - D(5) -> 18line -> 1
