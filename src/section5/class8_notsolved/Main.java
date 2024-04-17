package section5.class8_notsolved;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        LinkedList<Person> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person person = q.poll();
            for (Person p : q) {
                if (person.priority < p.priority) {
                    q.offer(person);
                    person = null;
                    break;
                }
            }
            if (person != null) {
                answer++;
                if (person.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    static class Person {
        private int id;
        private int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
}
