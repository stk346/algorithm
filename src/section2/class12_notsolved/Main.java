package section2.class12_notsolved;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int input2 = kb.nextInt();
        int[][] input3 = new int[input2][input1];
        for (int i = 0; i < input2; i++) {
            for (int j = 0; j < input1; j++) {
                input3[i][j] = kb.nextInt();
            }
        }
        System.out.println(myTry(input1, input2, input3));
    }

    private static int myTry(int input1, int input2, int[][] input3) {
        int answer = 0;
        for (int i = 1; i <= input1; i++) {
            for (int j = 1; j <= input1; j++) {

                boolean canBeMento = true;
                for (int k = 0; k < input2; k++) {
                    int iRank = 0;
                    int jRank = 0;
                    for (int l = 0; l < input1; l++) {
                        if (input3[k][l] == i) {
                            iRank = l;
                        }
                        if (input3[k][l] == j) {
                            jRank = l;
                        }
                    }
                    if (iRank >= jRank) {
                        canBeMento = false;
                        break;
                    }
                }
                if (canBeMento) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
