package lecture.section9.class5_다익스트라;

// 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 impossible을 출력)
// 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.
// 출력설명
// 1번 정점에서 각 정정으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 입력예제
// 6 9
// 1 2 12
// 1 3 4
// 2 1 2
// 2 3 5
// 2 5 5
// 3 4 5
// 4 2 2
// 4 5 5
// 6 4 5
// 출력예제
// 2 : 11
// 3 : 4
// 4 : 9
// 5 : 14
// 6 : impossible
public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            graph.get(kb.nextInt()).add(new Edge(kb.nextInt(), kb.nextInt()));
        }
        
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : " + "impossible");
            }
        }
    }

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) {
                continue;
            }
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
