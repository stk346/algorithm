package lecture.section8.class8_어려움_수열추측하기;


import java.util.Scanner;

public class Main {

    static int[] b;
    static int[] p;
    static int[] ch;
    static int n;
    static int f;
    static boolean flag = false;
    static int[][] dy;

    public int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dy = new int[n + 1][n + 1];
        // 이항계수를 이용해 배열을 만들어 놓고
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        // 이 배열과 1~n 숫자를 순차적으로 곱한 수를 합해 f와 일치하는지 확인한다.
        T.DFS(0, 0);
    }

    private void DFS(int L, int sum) {
        // 사전순으로 가장 앞에 있는 것만 출력. 무슨 뜻인지 모르겠음.
        if (flag) {
            return;
        }
        if (L == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + b[L] * p[L]);
                    ch[i] = 0;
                }
            }
        }
    }
}
