package lecture.section9.class1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Person> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Person(kb.nextInt(), kb.nextInt()));
        }
        System.out.println(T.solution(arr, n));
    }

    private int solution(ArrayList<Person> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Person p : arr) {
            if (p.weight > max) {
                max = p.weight;
                cnt++;
            }
        }
        return cnt;
    }

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
}
