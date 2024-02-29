package section1.class3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        System.out.println(solution2(input));
    }

    public static String solution(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }
        return answer;
    }

    public static String solution2(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if (str.length() > m) {
            answer = str;
        }
        return answer;
    }

    public static String myTry(String input) {

        String[] inputSplit = input.split(" ");

        String answer = "";
        for (String string : inputSplit) {
            if (string.length() > answer.length()) {
                answer = string;
            }
        }
        return answer;
    }
}
