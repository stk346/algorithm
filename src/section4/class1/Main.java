package section4.class1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String input = kb.nextLine();
        System.out.println(solution(n, input));
    }

    private static char solution(int n, String input) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : input.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    private static String myTry(int n, String input) {
        String answer = "";
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            Integer score = scoreMap.getOrDefault(c, 0);
            scoreMap.put(c, ++score);
        }
        Integer max = Collections.max(scoreMap.values());
        for (Map.Entry<Character, Integer> entry : scoreMap.entrySet()) {
            if (entry.getValue() == max) {
                answer = entry.getKey().toString();
                break;
            }
        }
        return answer;
    }
}
