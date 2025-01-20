package iolearn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.log"));
            String str;
            while (null != (str = in.readLine())) {
                System.out.println(str);
            }
            System.out.println(str);
        } catch (IOException e) {
        }
    }
}
