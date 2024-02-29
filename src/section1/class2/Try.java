package section1.class2;

import java.util.Scanner;

public class Try {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static String solution(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            }
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }
}
