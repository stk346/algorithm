package lecture.section7.class3;

public class Main {

    // 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
    // 예를 들어 5! = 5*4*3*2*1 -> 120 입니다.
    // 5 -> 120
    public static void main(String[] args) {
        Main T = new Main();
        System.out.println(T.DFS(5));
    }


    private int DFS(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * DFS(n - 1);
        }
    }
}
