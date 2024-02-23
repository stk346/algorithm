package section2.class10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
//        int[][] input2 = new int[input1 + 2][input1 + 2];
//        for (int i = 1; i < input1 + 1; i++) {
//            for (int j = 1; j < input1 + 1; j++) {
//                input2[i][j] = kb.nextInt();
//            }
//        }
        int[][] input2 = new int[input1][input1];
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input1; j++) {
                input2[i][j] = kb.nextInt();
            }
        }
        System.out.println(solution(input1, input2));
    }

    private static int solution(int input1, int[][] input2) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input1; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < input1 && ny >= 0 && ny < input1 &&
                            input2[i][j] <= input2[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static int myTry(int input1, int[][] input2) {
        int answer = 0;
        for (int i = 1; i < input1 + 1; i++) {
            for (int j = 1; j < input1 + 1; j++) {
                int left = input2[i][j-1];
                int right = input2[i][j+1];
                int up = input2[i-1][j];
                int down = input2[i+1][j];
                if (input2[i][j] > left && input2[i][j] > right &&
                    input2[i][j] > up && input2[i][j] > down) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
