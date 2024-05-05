package lecture.section9.class7_UnF_최소스패닝트리;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            arr.add(new Edge(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }

        int answer = 0;
        Collections.sort(arr);
        for (Edge o : arr) {
            int fv1 = find(o.v1);
            int fv2 = find(o.v2);
            if (fv1 != fv2) {
                answer += o.cost;
                union(fv1, fv2);
            }
        }
        System.out.println(answer);
    }

    // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    //2 9 8     -> [1, 9, 3, 4, 5, 6, 7, 8, 9]
    //2 3 10    -> [1, 9, 3, 4, 5, 6, 7, 8, 3]
    //1 2 12    -> [1, 3, 3, 4, 5, 6, 7, 8, 3] -> [3, 3, 3, 4, 5, 6, 7, 8, 3]
    //8 9 15    -> [3, 3, 3, 4, 5, 6, 7, 3, 3]
    //2 8 17    -> pass
    //3 4 18    -> [3, 3, 4, 4, 5, 6, 7, 3, 3]
    //1 9 25    -> [4, 3, 4, 4, 5, 6, 7, 3, 4]
    //7 8 35    -> [4, 3, 4, 4, 5, 6, 7, 4, 4] -> [4, 3, 4, 4, 5, 6, 4, 4, 4]
    //5 7 38    -> [4, 3, 4, 4, 4, 6, 4, 4, 4]
    //4 5 44    -> pass
    //3 7 55    -> pass
    //5 6 60    -> [4, 3, 4, 6, 4, 6, 4, 4, 4]
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

