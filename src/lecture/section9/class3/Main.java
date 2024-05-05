package lecture.section9.class3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }

        System.out.println(T.solution(arr, n));
    }

    private int solution(ArrayList<Time> arr, int n) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;

        for (Time t : arr) {
            if (t.state == 's') {
                cnt++;
            }
            if (t.state == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    static class Time implements Comparable<Time> {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return this.state - o.state; // 알파벳 순 오름차순 정렬
            }
            return this.time - o.time;
        }
    }
}
