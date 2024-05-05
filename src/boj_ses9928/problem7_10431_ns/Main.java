package boj_ses9928.problem7_10431_ns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T.solution(br);
    }

    private void solution(BufferedReader br) throws IOException {
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int num = Integer.parseInt(st.nextToken());
            sb.append(num + " ");
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int j = 1; j < arr.length; j++) {
//                if (arr[j-1] > arr[j]) {
//                    for (int k = j - 1; k >= 0; k--) {
//                        result++;
//                    }
//                }
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[j] < arr[k]) {
                        result++;
                    }
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
