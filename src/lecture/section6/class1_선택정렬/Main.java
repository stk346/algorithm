package lecture.section6.class1_선택정렬;

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

    // 루프1 : i - 왼쪽부터 인덱스를 기억해 둔다.
    // 루프2 : j - 첫 번째 루프를 제외하고 왼쪽부터 탐색하며 가장 작은 숫자의 인덱스를 찾는다.
    // 루프1 : i j 스위칭
    private static int[] solution(int n, int[] arr) {
        // 6
        // 13 5 11 7 23 15 -> 5 7 11 13 15 23
        // i = 0
        // 5 13 11 7 23 15
        // i = 1
        // 5 7 11 13 23 15
        // i = 2
        // 5 7 11 13 23 15
        // i = 3
        // 5 7 11 13 23 15
        // i = 4
        // 5 7 11 13 15 23
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
}
