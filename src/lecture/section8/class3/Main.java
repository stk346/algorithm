package lecture.section8.class3;

import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, int time, int[] scores, int[] times) {
        if (time > m) {
            return;
        }
        if (L == n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L + 1, sum + scores[L], time + times[L], scores, times);
            DFS(L + 1, sum, time, scores, times);
        }
    }
}
