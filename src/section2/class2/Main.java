package section2.class2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        int[] input2 = new int[input1];
        for (int i=0; i< input1; i++) {
            input2[i] = kb.nextInt();
        }
        System.out.println(myTry(input2));
    }

    private static int myTry(int[] input2) {
        int height = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i : input2) {
            if (i > height) {
                height = i;
                cnt++;
            }
        }
        return cnt;
    }
}
