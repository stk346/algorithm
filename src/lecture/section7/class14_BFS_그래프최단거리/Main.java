package lecture.section7.class14_BFS_그래프최단거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
// 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결 정보가 주어진다.
// 출력설명
// 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
// 입력예제
// 6 9
// 1 3
// 1 4
// 2 1
// 2 5
// 3 4
// 4 5
// 4 6
// 6 2
// 6 5
// 출력예제
// 2 : 3
// 3 : 1
// 4 : 1
// 5 : 2
// 6 : 2
public class Main {
    static int n = 0;
    static int m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dis[nv] = dis[cv] + 1;
                    queue.offer(nv);
                }
            }
        }
    }
    // cv=1
        // nv = 3 : ch[3]=1, dis[3]=1
        // nv = 4 : ch[4]=1, dis[4]=1
    // cv=3
        // nv = 4 : pass
    // cv=4
        // nv = 5 : ch[5]=1, dis[5] = dis[4] + 1
}
