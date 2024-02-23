package section2.class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        for (int answer : myTry(input)) {
            System.out.print(answer + " ");
        }
    }

    private static List<Integer> myTry(int input) {
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(1);
        for (int i=2; i<input; i++) {
            answer.add(answer.get(i-2) + answer.get(i-1));
        }
        return answer;
    }
}
