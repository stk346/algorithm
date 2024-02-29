package section1.class5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(myTry(str));
    }

    public String solution(String str) {
        String answer;
        char[] s = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) lt++;
            else if (!Character.isAlphabetic(s[rt])) rt--;
            else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static String myTry(String str) {
        char[] charArray = str.toCharArray();

        int lt = 0; int rt = charArray.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            }
            if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            }
            if (Character.isAlphabetic(charArray[lt]) && Character.isAlphabetic(charArray[rt])) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++; rt--;
            }
        }
        return String.valueOf(charArray);
    }
}
