package lecture.section2.class8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int[] input2 = new int[input1];
        for (int i = 0; i < input1; i++) {
            input2[i] = kb.nextInt();
        }
        System.out.println(myTry(input2));
    }

    private static String myTry(int[] input2) {
        String answer = "";
        for (int i : input2) {
            int rank = 1;
            for (int j : input2) {
                if (i < j) {
                    rank++;
                }
            }
            answer += rank + " ";
        }
        return answer;
    }
}
