package lecture.section6.class2_버블정렬;

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

    // 루프1 : i - 루프 2의 마지막 숫자가 순차적으로 줄어들 수 있도록 하는 역할
    // 루프2 : j - 매번 j, j + 1를 비교하고 스위칭한다. -> 매 루프마다 가장 큰 숫자가 무조건 맨 뒤로 가게 된다.
    private static int[] solution(int n, int[] arr) {
        // 6
        // 13 5 11 7 23 15 -> 5 7 11 13 15 23
        // 5 11 7 13 15 23
        // 5 7 11 13 15 23

        // 13 11 7 23 15 5
        // 11 7 13 15 5 23
        // 7 11 13 5 15 23
        // 7 11 5 13 15 23
        // 7 5 11 13 15 23
        // 5 7 11 13 15 23
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
