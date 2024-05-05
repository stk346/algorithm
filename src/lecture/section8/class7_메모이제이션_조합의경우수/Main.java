package lecture.section8.class7_메모이제이션_조합의경우수;

import java.util.Scanner;

public class Main {
    static int[][] dy;
    static int n;
    static int r;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        r = kb.nextInt();
        dy = new int[n+1][n+1];
        System.out.println(T.DFS(n, r));
    }

    private int DFS(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}
