package exceptionlearn;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionLearn1 {

    public void testException() throws IOException {
        //FileInputStream的构造函数会抛出FileNotFoundException
        FileInputStream fileIn = new FileInputStream("E:\\a.txt");
        int word;
        //read方法会抛出IOException
        while ((word = fileIn.read()) != -1) {
            System.out.print((char) word);
        }
        //close方法会抛出IOException
        fileIn.close();
    }

    public void testException(int a) {
        if (0 != a) {
            throw new ArithmeticException("变量a居然不是0");
        }
    }

    /**
     * 该函数的作用是当catch语句中抛出异常，finally里的语句仍然会被执行
     */
    public static void testException2() {
        try {
            int num = 1 / 0;
        } catch (Exception e) {
            System.out.println("开始抛出异常！");
            throw e;
        } finally {
            System.out.println("我被调用啦！");
        }
    }

    public static void main(String[] args) {
        try {
            testException2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
