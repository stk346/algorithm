package lecture.section7.class8_BFS_송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int answer = 0;
    int[] dis = {-1, 1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }

    private int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int currentDist = Q.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nextDist = currentDist + dis[j];
                    if (nextDist == e) {
                        return L + 1;
                    }
                    if (ch[nextDist] == 0 && nextDist <= 10000 && nextDist >= 1) {
                        Q.offer(nextDist);
                        ch[nextDist] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
