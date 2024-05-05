package lecture.section4.class4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        String n = kb.nextLine();
        System.out.println(myTry(s, n));
    }

    private static int myTry(String s, String n) {
        Integer answer = 0;
        HashMap<Character, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            answerMap.put(n.charAt(i), answerMap.getOrDefault(n.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < n.length() - 1; i++) {
            targetMap.put(s.charAt(i), targetMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = n.length() - 1; rt < s.length(); rt++) {
            targetMap.put(s.charAt(rt), targetMap.getOrDefault(s.charAt(rt), 0) + 1);

            boolean isAnagram = true;
            for (Character c : answerMap.keySet()) {
                Integer answerValue = answerMap.get(c);
                Integer targetValue = targetMap.get(c);
                if (answerValue != targetValue) {
                    isAnagram = false;
                }
            }
            if (isAnagram) {
                answer++;
            }

            if (targetMap.get(s.charAt(lt)) == 1) {
                targetMap.remove(s.charAt(lt));
            } else {
                targetMap.put(s.charAt(lt), targetMap.getOrDefault(s.charAt(lt), 0) - 1);
            }
            lt++;
        }
        return answer;
    }
}
