package boj_ses9928.problem4_1157_ns;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        int[] arr = new int[26];
        for (Character c : input.toCharArray()) {
            if ('A' <= c && 'Z' >= c) {
                arr[c - 'A']++;
            } else {
                arr[c - 'a']++;
            }
        }
        System.out.println(T.solution(arr));
    }

    private Character solution(int[] arr) {
        int max = -1;
        Character target = '?';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                target = (char) (i + 65);
                continue;
            }
            if (arr[i] == max) {
                target = '?';
            }
        }
        return target;
    }
}
