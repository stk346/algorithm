package lecture.section7.class4_피보나치_메모이제이션;

public class Main {
    static int[] fibo;

    // 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    // 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
    // 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
    //  첫 줄에 피보나치  수열을 출력한다.
    // 10 -> 1 1 2 3 5 8 13 21 34 55
    public static void main(String[] args) {
        Main T = new Main();
        int n = 45;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1; i < n; i++) {
            System.out.print(T.DFS(i) + " ");
        }
    }

    // D(6) = D(5) + D(4) -> 5 + 3
    // D(5) = D(4) + D(3) -> 3 + 2
    // D(4) = D(3) + D(2) -> 2 + 1
    // D(3) = D(2) + D(1) -> 1 + 1
    // 설명: D(6)이 스택의 맨 밑에 있다고 했을 때 D(5)와 D(4)는 이미 구해진 상태이다.
    // if (fibo[n] > 0) 구문이 없다면 D(5)와 D(4)를 다시 계산하는 절차를 거치게 되는데, 해당 구문을 넣어 줌으로써 이전에 계산한 값을 다시 사용할 수 있게 된다.
    private int DFS(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            fibo[n] = 1;
            return fibo[n];
        }
        if (n == 2) {
            fibo[n] = 1;
            return fibo[n];
        }
        else {
            fibo[n] = DFS(n - 1) + DFS(n - 2);
            return fibo[n];
        }
    }
}
