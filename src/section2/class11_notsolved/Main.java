package section2.class11_notsolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int[][] input2 = new int[input1][5];
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < 5; j++) {
                input2[i][j] = kb.nextInt();
            }
        }
        System.out.println(myTry(input1, input2));
    }

    private static int myTry(int input1, int[][] input2) {

        int studentIdx = 0;
        int friendsCnt = 0;
        for (int i = 0; i < input1; i++) {
            List<Integer> sameClassFriends = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < input1; k++) {
                    if (i != k && input2[i][j] == input2[k][j]) {
                        sameClassFriends.add(input2[k][j]);
                    }
                }
            }
            int tmp = (int)sameClassFriends.stream().distinct().count();
            if (friendsCnt < tmp) {
                friendsCnt = tmp;
                studentIdx = i+1;
            }
        }
        return studentIdx;
    }
}
