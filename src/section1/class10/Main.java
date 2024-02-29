package section1.class10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input1 = kb.next();
        String input2 = kb.next();
        for (int x : solution(input1, input2)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(String input1, String input2) {
        char t = input2.charAt(0);
        int[] answer = new int[input1.length()];

        int p = 1000;
        for (int i=0; i<input1.length(); i++) {
            if (input1.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i=input1.length()-1; i>=0; i--) {
            if (input1.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    private static List<Integer> mySolution(String input1, String input2) {
        List<Integer> answer = new ArrayList<>();
        int firstIndex = input1.indexOf(input2);
        for (int i=0; i<input1.length(); i++) {
            int distance = firstIndex - i;
            if (distance < 0) {
                distance = -distance;
            }

            int secondIndex = input1.indexOf(input2, firstIndex + 1);
            if (secondIndex != -1) {
                int secondDistance = secondIndex - i;
                if (distance > secondDistance) {
                    distance = secondDistance;
                }
            }
            if (i == secondIndex) {
                firstIndex = secondIndex;
            }
            answer.add(distance);
        }
        return answer;
    }
}
