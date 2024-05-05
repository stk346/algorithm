package lecture.section1.class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();

        String[] inputs = new String[input];
        for (int i = 0; i < input; i++) {
            inputs[i] = kb.next();
        }

        for (String result : solution2(inputs)) {
            System.out.println(result);
        }
    }

    public static ArrayList<String> solution1(String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static ArrayList<String> solution2(String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : str) {
            char[] charArray = s.toCharArray();

            int lt = 0, rt = s.length() - 1;
            while (lt < rt) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++; rt--;
            }
            String reversedString = String.valueOf(charArray);
            answer.add(reversedString);
        }
        return answer;
    }

    public static List<String> myTry(String[] input) {
        List<String> answer = new ArrayList<>();

        for (String targetString : input) {
            String result = "";
            for (int i = targetString.length() - 1; i >= 0; i--) {
                result += (targetString.charAt(i));
            }
            answer.add(result);
        }
        return answer;
    }
}
