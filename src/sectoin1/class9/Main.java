package sectoin1.class9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static int solution(String input) {
        int answer = 0;
        for (char c : input.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }

    private static int mySolution(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.valueOf(answer);
    }
}
