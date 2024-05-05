package lecture.section3.class3_notsolved;

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
        //10 3
        //12 15 11 20 25 10 20 19 13 15
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += arr[i];
        }
        int sum = answer;
        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i-m]);
            if (answer < sum) {
                answer = sum;
            }
        }
        return answer;
    }

    private static int myTry(int n, int m, int[] arr) {
        int highestProfit = -1;
        for (int i = 0; i <= n - m; i++) {
            int profit = 0;
            for (int j = i; j < i + m; j++) {
                profit += arr[j];
            }
            if (highestProfit < profit) {
                highestProfit = profit;
            }
        }
        return highestProfit;
    }
}
