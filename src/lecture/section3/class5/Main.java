package lecture.section3.class5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(myTry(n));
    }

    private static int myTry(int n) {
        int answer = 0;
        int lt = 1, sum = 0;
        for (int rt = 1; rt < n; rt++) {
            if (sum == n) {
                answer++;
            }
            sum += rt;
            while (sum > n) {
                sum -= lt++;
            }
        }
        return answer;
    }
}
