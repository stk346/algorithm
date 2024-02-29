package section1.class1;

import java.util.Scanner;

public class Try {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        String lowerInput1 = input1.toLowerCase();
        String lowerInput2 = input2.toLowerCase();

        char targetChar = lowerInput2.toCharArray()[0];

        int cnt = 0;

        for(char c : lowerInput1.toCharArray()) {
            if (c == targetChar) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
