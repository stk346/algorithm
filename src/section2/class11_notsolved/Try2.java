package section2.class11_notsolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Try2 {
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
        int answer = -1;
        int classMatesCnt = 0;
        for (int i = 0; i < input1; i++) {
            List<Integer> sameClassesStudents = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < input1; k++) {
                    if (input2[i][j] == input2[k][j] && !sameClassesStudents.contains(k)) {
                        sameClassesStudents.add(k);
                    }
                }
            }
            if (classMatesCnt < sameClassesStudents.size()) {
                classMatesCnt = sameClassesStudents.size();
                answer = i + 1;
            }
        }
        return answer;
    }
}
