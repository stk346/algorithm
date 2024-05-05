package lecture.section9.class6;

import java.util.Scanner;

public class Main {
    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            Union(kb.nextInt(), kb.nextInt());
        }

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int Find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }
}
