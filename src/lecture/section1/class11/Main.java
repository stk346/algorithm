package lecture.section1.class11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "";
        input = input + " ";
        int cnt = 1;
        for (int i=0; i<input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                cnt++;
            } else {
                answer += input.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }
        return answer;
    }

    private static String mySolution(String input) {
        String answer = "";
        int sameCharacterCnt = 1;
        for (int i=1; i<input.length(); i++) {
            if (input.charAt(i-1) == input.charAt(i)) {
                sameCharacterCnt++;
            }
            if (input.charAt(i-1) != input.charAt(i)) {
                answer += input.charAt(i-1);
                if (sameCharacterCnt != 1) {
                    answer += sameCharacterCnt;
                }
                sameCharacterCnt = 1;
            }
            if (i == input.length() - 1) {
                answer += input.charAt(i-1);
                if (sameCharacterCnt != 1) {
                    answer += sameCharacterCnt;
                }
            }
        }
        return answer;
    }
}
