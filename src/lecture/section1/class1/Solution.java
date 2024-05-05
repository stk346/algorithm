package lecture.section1.class1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.println(solution(str, c));
    }

    private static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char c : str.toCharArray()) {
            if (c == t) {
                answer++;
            }
        }
        return answer;
    }
}
