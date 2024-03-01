package section3.class4_retry;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }


    private static int myTry(int n, int m, int[] arr) {
        int answer = 0;
        int p1 = 0;
        while (p1 < n) {
            int sum = 0;
            boolean meetCondition = false;
            for (int i = p1; i < n; i++) {
                sum += arr[i];
                if (sum == m) {
                    answer++;
                    p1++;
                    meetCondition = true;
                    break;
                }
                if (sum > m) {
                    p1++;
                    meetCondition = true;
                    break;
                }
            }
            if (!meetCondition) {
                p1++;
            }
        }
        return answer;
    }
}
