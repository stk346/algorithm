package lecture.section8.class9;

import java.util.Scanner;

// 1부터 N까지의 번호가 적힌 구슬이 있습니다. M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
// 입력설명
// 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
// 출력설명
// 첫 번째 줄에 결과를 출력합니다.
// 출력 순서는 사전순으로 오름차순으로 정렬합니다.
// 입력예제
// 4 2
// 출력예제
// 1 2
// 1 3
// 1 4
// 2 3
// 2 4
// 3 4
public class Main {
    static int[] combi;
    static int n;
    static int m;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }

    private void DFS(int L, int s) {
        if (L == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
