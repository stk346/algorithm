package lecture.section6.class10_결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }

    private static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 1 2 4 8 9
        int lt = 1;
        int rt = arr[n-1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
                continue;
            }
            if (count(arr, mid) < c) {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static int count(int[] arr, int distance) {
        // 1 2 4 8 9 | distance = 5
        // 최소 distance 만큼 떨어져야 함
        int cnt = 1;
        int point = arr[0];


        for (int x : arr) {
            if (x - point >= distance) {
                cnt++;
                point = x;
            }
        }
        return cnt;
    }
}
