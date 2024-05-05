package lecture.section5.class4_notsolved;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static int solution(String input) {
        Stack<Integer> stack = new Stack<>();

        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Integer.valueOf(String.valueOf(c)));
            }
            if (!Character.isDigit(c)) {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                }
                if (c == '-') {
                    stack.push(lt - rt);
                }
                if (c == '*') {
                    stack.push(lt * rt);
                }
                if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        return stack.get(0);
    }

    private static int myTry(String input) {
        String beforeCalculate = "";
        int afterCalculate = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                beforeCalculate += input.charAt(i);
                continue;
            }

            if (afterCalculate == 0) {
                afterCalculate = Integer.valueOf(String.valueOf(beforeCalculate.charAt(beforeCalculate.length() - 1)));
                beforeCalculate = beforeCalculate.substring(0, beforeCalculate.length() - 1);
            }

            if (!Character.isDigit(input.charAt(i))) {
                if (String.valueOf(input.charAt(i)).equals("+")) {
                    afterCalculate += Integer.valueOf(String.valueOf(beforeCalculate.charAt(beforeCalculate.length() - 1)));
                    beforeCalculate = beforeCalculate.substring(0, beforeCalculate.length() - 1);
                    continue;
                }
                if (String.valueOf(input.charAt(i)).equals("-")) {
                    afterCalculate -= Integer.valueOf(String.valueOf(beforeCalculate.charAt(beforeCalculate.length() - 1)));
                    beforeCalculate = beforeCalculate.substring(0, beforeCalculate.length() - 1);
                    continue;
                }
                if (String.valueOf(input.charAt(i)).equals("*")) {
                    afterCalculate *= Integer.valueOf(String.valueOf(beforeCalculate.charAt(beforeCalculate.length() - 1)));
                    beforeCalculate = beforeCalculate.substring(0, beforeCalculate.length() - 1);
                    continue;
                }
                if (String.valueOf(input.charAt(i)).equals("/")) {
                    afterCalculate /= Integer.valueOf(String.valueOf(beforeCalculate.charAt(beforeCalculate.length() - 1)));
                    beforeCalculate = beforeCalculate.substring(0, beforeCalculate.length() - 1);
                    continue;
                }
            }
        }
        return afterCalculate;
    }
}
