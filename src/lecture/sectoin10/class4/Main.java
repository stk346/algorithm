package lecture.sectoin10.class4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int dy[];

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }
        System.out.println(T.solution(bricks));
    }

    private int solution(ArrayList<Brick> bricks) {
        int answer = 0;
        Collections.sort(bricks);
        dy[0] = bricks.get(0).height;
        answer = dy[0];
        for (int i = 1; i < bricks.size(); i++) {
            int max_h = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(j).weight > bricks.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }

            dy[i] = bricks.get(i).height + max_h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    private static class Brick implements Comparable<Brick> {
        int width;
        int height;
        int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }
    }
}
