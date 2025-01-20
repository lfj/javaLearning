package longlearn;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        char c = 65;
        System.out.println(c);

        int a = 15;
        float b = 2.2f;
        System.out.println((int) (a * b));

        Scanner input = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(input.next());
        }
        System.out.println(sb);
    }
}
