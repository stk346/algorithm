package lecture.section4.class2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input1 = kb.nextLine();
        String input2 = kb.nextLine();
        System.out.println(solution(input1, input2));
    }

    private static String solution(String input1, String input2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : input2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }
        return "YES";
    }

    private static String myTry(String input1, String input2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : input1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : input2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        String answer = "YES";
        for (char c : map1.keySet()) {
            if (map1.get(c) != map2.getOrDefault(c, 0)) {
                answer = "NO";
            }
        }
        return answer;
    }
}
