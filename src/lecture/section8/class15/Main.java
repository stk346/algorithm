package lecture.section8.class15;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int len;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs;
    static ArrayList<Point> pz;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {
                    hs.add(new Point(i, j));
                }
                if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size(); // lenCm
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }

    // L = 0, s = 0 - DFS(0,0) - [0]
        // L = 1, s = 1 - DFS(1,1) - [0, 1]
            // L = 2, s = 2 - DFS(1,1) - DFS(2,2) - [0, 1, 2]
                // L = 3, s = 3 - DFS(3,3) - [0, 1, 2, 3]
                // L = 3, s = 4 - DFS(3,4) - [0, 1, 2, 4]
                // L = 3, s = 5 - DFS(3,5) - [0, 1, 2, 5]
            // L = 2, s = 3 - DFS(1,1) - DFS(2,2) - [0, 1, 3]
                // L = 3, s = 4 - DFS(3,4) - [0, 1, 3, 4]
                // L = 3, s = 5 - DFS(3,5) - [0, 1, 3, 5]
            // L = 2, s = 4 - DFS(1,1) - DFS(2,2) - [0, 1, 4]
                // L = 3, s = 5 - DFS(3,5) - [0, 1, 4, 5]
        // L = 1, s = 2 - DFS(1,2) - [0, 2]
        // ...
    private void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : hs) {
                int minDistance = Integer.MAX_VALUE;
                for (int idx : combi) {
                    int dis = Math.abs(h.x - pz.get(idx).x) + Math.abs(h.y - pz.get(idx).y);
                    minDistance = Math.min(minDistance, dis);
                }
                sum += minDistance;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
