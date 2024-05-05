package lecture.section1.class6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String str) {
        String answer = "";
        for (int i=0; i<str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    private static String myTry(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (!answer.contains(String.valueOf(c))) {
                answer = answer.concat(String.valueOf(c));
            }
        }
        return answer;
    }
}
