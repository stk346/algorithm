package section2.class3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[] input1 = new int[cnt];
        int[] input2 = new int[cnt];
        for (int i=0; i<cnt; i++) {
            input1[i] = kb.nextInt();
        }
        for (int i=0; i<cnt; i++) {
            input2[i] = kb.nextInt();
        }
        for (String answer : myTry(cnt, input1, input2)) {
            System.out.println(answer);
        }
    }

    private static List<String> myTry(int cnt, int[] input1, int[] input2) {
        List<String> answer = new ArrayList<>();
        for (int i=0; i<cnt; i++) {
            String winner = "";
            if (input1[i] > input2[i]) {
                winner = "A";
            }
            if (input1[i] < input2[i]) {
                winner = "B";
            }
            if (input1[i] == input2[i]) {
                winner = "D";
            }
            if (input1[i] == 1 && input2[i] == 3) {
                winner = "A";
            }
            if (input1[i] == 3 && input2[i] == 1) {
                winner = "B";
            }
            answer.add(winner);
        }
        return answer;
    }
}
