package section1.class12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input1 = kb.nextInt();
        String input2 = kb.next();
        System.out.println(mySolution(input1, input2));
    }

    private static String mySolution(int input1, String input2) {
        String answer = "";
        for (int i=0; i<input2.length()/7; i++) {
            String parsedInput = input2.substring(i * 7, (i + 1) * 7);
            String parsedInput2 = parsedInput.replace("#", "1").replace("*", "0");
            int convertedTo10 = Integer.parseInt(parsedInput2, 2);
            answer += (char) convertedTo10;
        }
        return answer;
    }
}
