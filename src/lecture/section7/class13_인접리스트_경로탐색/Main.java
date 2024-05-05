package lecture.section7.class13_인접리스트_경로탐색;

import java.util.ArrayList;
import java.util.Scanner;

// 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// ---
// 입력
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결 정보가 주어진다.
// ---
// 출력
// 총 가지수를 출력한다.
// ---
// 입력예제
// 5 9
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2
// 4 5
// 출력예제
// 6
public class Main {
    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<>(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int v) {
        if (v == n) {
            answer++;
        }
        else {
            for (int nextV : graph.get(v)) {
                if (ch[nextV] == 0) {
                    ch[nextV] = 1;
                    DFS(nextV);
                    ch[nextV] = 0;
                }
            }
        }
    }
}
