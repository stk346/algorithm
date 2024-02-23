package section2.class9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int[][] input2 = new int[input1][input1];
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input1; j++) {
                input2[i][j] = kb.nextInt();
            }
        }
        System.out.print(myTry(input1, input2));
    }

    private static int myTry(int input1, int[][] input2) {
        int answer = Integer.MIN_VALUE;
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0; i < input1; i++) {
            int length = 0;
            int width = 0;
            for (int j = 0; j < input1; j++) {
                width += input2[i][j];
                length += input2[j][i];
                if (i == j) {
                    leftDiagonal += input2[i][j];
                }
                if (i + j == input1 - 1) {
                    rightDiagonal += input2[i][j];
                }
            }
            if (answer < width) {
                answer = width;
            }
            if (answer < length) {
                answer = length;
            }
        }
        if (answer < leftDiagonal) {
            answer = leftDiagonal;
        }
        if (answer < rightDiagonal) {
            answer = rightDiagonal;
        }
        return answer;
    }
}
