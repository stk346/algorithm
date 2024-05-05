package lecture.section2.class5_notsolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        System.out.println(solution(input));
    }

    private static int solution(int input) {
        int answer = 0;
        int[] target = new int[input + 1];
        for (int i = 2; i <= input; i++) {
            if (target[i] == 0) {
                answer++;
                for (int j = i; j <= input; j = j+i) {
                    target[j] = 1;
                }
            }
        }
        return answer;
    }

    private static int myTry(int input) {
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);

        for (int i = 3; i <= input; i++) {
            boolean isPrimeNumber = true;
            for (Integer primeNumber : primeNumbers) {
                if (i % primeNumber == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers.size();
    }
}
