package section2.class7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int[] input2 = new int[input1];
        for (int i = 0; i < input1; i++) {
            input2[i] = kb.nextInt();
        }
        System.out.println(mySolution(input2));
    }

    private static int mySolution(int[] input2) {
        int answer = 0;
        int score = 0;
        for (int i : input2) {
            if (i == 1) {
                score++;
                answer += score;
            }
            if (i == 0) {
                score = 0;
            }
        }
        return answer;
    }
}
