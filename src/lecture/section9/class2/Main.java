package lecture.section9.class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Conference> conferences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            conferences.add(new Conference(kb.nextInt(), kb.nextInt()));
        }

        System.out.println(T.solution(conferences, n));
    }

    private int solution(ArrayList<Conference> conferences, int n) {
        int cnt = 0;
        Collections.sort(conferences);
        int et = 0;
        for (Conference c : conferences) {
            if (c.start >= et) {
                cnt++;
                et = c.end;
            }
        }
        return cnt;
    }

    static class Conference implements Comparable<Conference>{
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
