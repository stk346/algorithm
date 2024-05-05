package lecture.section5.class1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    private static String myTry(String input) {
        int bracketOffset = 0;
        if (input.charAt(0) == ')' || input.charAt(input.length() - 1) == '(') {
            return "NO";
        }
        for (char c : input.toCharArray()) {
            if (c == '(') {
                bracketOffset++;
            }
            if (c == ')') {
                bracketOffset--;
            }
        }
        if (bracketOffset == 0) {
            return  "YES";
        } else {
            return "NO";
        }
    }
}
