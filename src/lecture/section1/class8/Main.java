package lecture.section1.class8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "NO";
        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(input).reverse().toString();
        if (input.equals(tmp)) {
            return "YES";
        }
        return answer;
    }

    private static String mySolution(String input) {
        input = input.toLowerCase();
        int lt = 0, rt = input.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(input.charAt(lt))) {
                lt++;
                continue;
            }
            if (!Character.isAlphabetic(input.charAt(rt))) {
                rt--;
                continue;
            }
            if (input.charAt(lt) != input.charAt(rt)) {
                return "NO";
            }
            lt++; rt--;
        }
        return "YES";
    }
}
