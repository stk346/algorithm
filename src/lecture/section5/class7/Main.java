package lecture.section5.class7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String a = kb.nextLine();
        String b = kb.nextLine();
        System.out.println(solution(a, b));
    }

    private static String solution(String need, String plan) {
    Queue<Character> Q = new LinkedList<>();
        for (Character c : need.toCharArray()) {
            Q.offer(c);
        }
        for (Character c : plan.toCharArray()) {
            if (Q.contains(c)) {
                if (Q.poll() != c) {
                    return "NO";
                }
            }
        }
        if (!Q.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    private static String myTry(String a, String b) {
        Queue<Character> aQ = new LinkedList<>();
        Queue<Character> bQ = new LinkedList<>();

        for (Character c : a.toCharArray()) {
            aQ.offer(c);
        }
        for (Character c : b.toCharArray()) {
            bQ.offer(c);
        }

        for (int i = 0; i < b.length(); i++) {
            Character subject = bQ.poll();
            if (aQ.peek() == subject) {
                aQ.poll();
            }
        }
        if (aQ.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
}
