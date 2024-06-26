package lecture.section7.class6_DFS_부분집합구하기;

// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
// 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
// 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
// 단 공집합은 출력하지 않습니다.

// 3
// ---
// 1 2 3
// 1 2
// 1 3
// 1
// 2 3
// 2
// 3
public class Main {
    static int n;
    static int[] ch; // 원소 사용/미사용 여부를 판단하기 위한 배열

    public void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        }
        else {
            ch[L] = 1;  // 왼 - 사용한다
            DFS(L + 1); // 왼쪽
            ch[L] = 0; // 오 - 사용하지 않는다.
            DFS(L + 1); // 오른쪽
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
    }
}
