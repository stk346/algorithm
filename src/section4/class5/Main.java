package section4.class5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer x : Tset) {
            cnt++;
            if (cnt == k) {
                answer = x;
            }
        }
        return answer;
    }

    private static int myTry(int n, int k, int[] arr) {
        ArrayList<Integer> sums = new ArrayList<>();
        
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += arr[i];
        }

        int lt = 0;
        for (int rt = 2; rt < n; rt++) {
            sum += arr[rt];
            sums.add(sum);

            sum -= arr[lt];
            sum += arr[rt];
            lt++;
        }
        if (sums.size() >= k) {
            return sums.get(k);
        } else {
            return -1;

        }
    }
}
