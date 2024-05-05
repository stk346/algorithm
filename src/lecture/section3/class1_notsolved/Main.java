package lecture.section3.class1_notsolved;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] input1 = new int[n];
        for (int i = 0; i < n; i++) {
            input1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] input2 = new int[m];
        for (int i = 0; i < m; i++) {
            input2[i] = kb.nextInt();
        }
        for (int x : solution(n, m, input1, input2)) {
            System.out.print(x + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int m, int[] input1, int[] input2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (input1[p1] <= input2[p2]) {
                answer.add(input1[p1++]);
            } else {
                answer.add(input2[p2++]);
            }
        }
        while (p1 < n) {
            answer.add(input1[p1++]);
        }
        while (p2 < m) {
            answer.add(input2[p2++]);
        }
        return answer;
    }
}
