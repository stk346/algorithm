package boj_ses9928.problem5_11723_ns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0;
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("all")) S = (1 << 21) - 1;
            else if(str.equals("empty")) S = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                if(str.equals("add"))
                    S |= (1 << num);
                else if(str.equals("remove"))
                    S &= ~(1 << num);
                else if(str.equals("check"))
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(str.equals("toggle"))
                    S ^= (1 << num);
            }
        }
        System.out.println(sb);

//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        kb.nextLine();
//        String[] commands = new String[n];
//        for (int i = 0; i < n; i++) {
//            commands[i] = kb.nextLine();
//        }
//
//        for (int x : myTry(commands)) {
//            System.out.println(x);
//        }
    }

    // 메모리 초과
    private static List<Integer> myTry(String[] commands) {
        ArrayList<Integer> values = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        ArrayList<Integer> answer = new ArrayList<>();
        for (String c : commands) {
            String[] s = c.split(" ");
            if (s.length == 1) {
                if (s[0].equals("all")) {
                    Collections.fill(values, 1);
                    continue;
                }
                if (s[0].equals("empty")) {
                    Collections.fill(values, 0);
                    continue;
                }
            }
            if (s.length == 2) {
                Integer target = Integer.valueOf(s[1]) - 1;
                if (s[0].equals("add")) {
                    values.set(target, 1);
                    continue;
                }
                if (s[0].equals("check")) {
                    if (values.get(target) == 1) {
                        answer.add(1);
                        continue;
                    }
                    if (values.get(target) == 0) {
                        answer.add(0);
                        continue;
                    }
                }
                if (s[0].equals("remove")) {
                    values.set(target, 0);
                    continue;
                }
                if (s[0].equals("toggle")) {
                    if (values.get(target) == 1) {
                        values.set(target, 0);
                        continue;
                    }
                    if (values.get(target) == 0) {
                        values.set(target, 1);
                    }
                }
            }
        }
        return answer;
    }
}
