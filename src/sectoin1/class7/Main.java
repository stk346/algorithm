package sectoin1.class7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        System.out.println(solution2(input.toLowerCase()));
    }

    private static String solution2(String str) {
        String reversedString = new StringBuilder(str).reverse().toString();
        if (str.equals(reversedString)) {
            return "YES";
        }
        return "NO";
    }

    private static String solution(String str) {
        String answer = "YES";
        int len = str.length();
        for (int i=0; i<len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static String mySolution(String input) {
        int lt = 0, rt = input.length() - 1;
        while (lt < rt) {
            if (input.charAt(lt) != input.charAt(rt)) {
                return "NO";
            }
            lt++;
            rt--;
        }
        return "YES";
    }
}
