package lecture.sectoin10.class2;

import java.util.Scanner;

public class Main {

    static int[] dy;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 2];
        System.out.println(T.solution(n));

    }

    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n + 1];
    }
}
