package section5.class2_retry;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    private static String myTry(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            // (A(BC)D)EF(G(H)(IJ)K)LM(N)
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                stack.pop();
                continue;
            }
            if (stack.isEmpty()) {
                answer += c;
            }
        }
        return answer;
    }
}
