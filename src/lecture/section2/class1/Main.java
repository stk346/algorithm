package lecture.section2.class1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = Integer.valueOf(kb.nextLine());
        String input2 = kb.nextLine();
        System.out.println(mySolution(input1, input2));
    }

    private static String mySolution(int input1, String input2) {
        String answer = "";
        String[] targetNum = input2.split(" ");

        answer += targetNum[0] + " ";
        for (int i=1; i<targetNum.length; i++) {
            Integer target = Integer.valueOf(targetNum[i]);
            if (Integer.valueOf(targetNum[i-1]) < target) {
                answer += target + " ";
            }
        }
        return answer;
    }
}
