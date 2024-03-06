package section5.class3;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int k = kb.nextInt();
        int[] moves = new int[k];
        for (int i = 0; i < k; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(myTry(n, board, k, moves));
    }

    private static int myTry(int n, int[][] board, int k, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][move - 1] == 0) {
                    continue;
                }
                if (!bucket.isEmpty() && bucket.peek() == board[i][move - 1]) {
                    answer += 2;
                    bucket.pop();
                    board[i][move - 1] = 0;
                    break;
                } else {
                    bucket.push(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
