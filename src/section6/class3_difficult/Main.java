package section6.class3_difficult;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int a : solution(n, arr)) {
            System.out.print(a + " ");
        }
    }

    private static int[] solution(int n, int[] arr) {
        // 6
        // 11 7 5 6 10 9 -> 5 6 7 9 10 11

        // i = 1, tmp = 7
        // j = 0 -> 11 11 5 6 10 9
        // j = -1 -> 7 11 5 6 10 9

        // i = 2, tmp = 5
        // j = 1 -> 7 11 11 6 10 9
        // j = 0 -> 7 7 11 6 10 9
        // j = -1 -> 5 7 11 6 10 9

        // i = 3, tmp = 6
        // j = 2 -> 5 7 11 11 10 9
        // j = 1 -> 5 7 7 11 10 9
        // j = 0 -> 5 6 7 11 10 9

        // i = 4, tmp = 10
        // j = 3 -> 5 6 7 11 11 9
        // j = 2 -> 5 6 7 10 11 9

        // i = 5, tmp = 9
        // j = 4 -> 5 6 7 10 11 11
        // j = 3 -> 5 6 7 10 10 11
        // j = 2 -> 5 6 7 9 10 11
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
