package section4.class3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i : solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) - 1);
            if (HM.get(arr[lt]) == 0) {
                HM.remove(arr[lt]);
            }
            lt++;
        }
        return answer;
    }

    private static int[] myTry(int n, int k, int[] arr) {
        int[] answer = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer[0] = map.keySet().size();
        int lt = 0, rt = k;
        while (rt < n) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer[lt + 1] = map.keySet().size();
            lt++; rt++;
        }
        return answer;
    }
}
