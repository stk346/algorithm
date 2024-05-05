package boj_ses9928.problem6_9655;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.myTry(n));
    }

    // 1 -> SK
    // 2 -> CY
    // 3 -> SK
    // 4 -> CY
    // ...
    private String myTry(int n) {
        String answer = "SK";
        if (n % 2 == 0) {
            answer = "CY";
        }
        if (n % 2 != 0) {
            answer = "SK";
        }
        return answer;
    }
}
