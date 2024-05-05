package lecture.section9.class4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        ArrayList<Lecture> lectures = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int money = kb.nextInt();
            int date = kb.nextInt();
            lectures.add(new Lecture(money, date));
            if (max < date) {
                max = date;
            }
        }

        System.out.println(T.solution(lectures, max));
    }

    private int solution(ArrayList<Lecture> arr, int max) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < arr.size(); j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                else {
                    pQ.offer(arr.get(j).money);
                }
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }

    static class Lecture implements Comparable<Lecture> {
        int money;
        int date;

        public Lecture(int money, int date) {
            this.money = money;
            this.date = date;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.date - this.date;
        }
    }
}
