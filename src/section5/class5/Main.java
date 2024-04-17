package section5.class5;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(myTry(input));
    }

    private static int myTry(String input) {
        // ((( () ( () () )) ( () ) () )) ( () () )
        // 3 | 3 -> 3
        // 4 | 4 -> 7
        // 4 | 4 -> 11
        // 1 | 3 -> 12
        // 1 | 2 -> 13
        // 3 | 3 -> 16
        // 1 | 2 -> 17
        // 2 | 2 -> 19
        // 1 | 1 -> 20
        // 1 | 0 -> 21
        // 1 | 1 -> 22
        // 1 | 1 -> 23
        // 1 | 0 -> 24

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        boolean isEnd = false;
        for (Character c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                isEnd = false;
                continue;
            }
            if (c == ')' && !isEnd) {
                stack.pop();
                answer += stack.size();
                isEnd = true;
                continue;
            }
            if (c == ')' && isEnd) {
                stack.pop();
                answer += 1;
                continue;
            }
        }
        return answer;
    }
}
