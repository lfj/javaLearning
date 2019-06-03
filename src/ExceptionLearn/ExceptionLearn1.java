package ExceptionLearn;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionLearn1 {

    public void testException() throws IOException {
        //FileInputStream的构造函数会抛出FileNotFoundException
        FileInputStream fileIn = new FileInputStream("E:\\a.txt");
        int word;
        //read方法会抛出IOException
        while((word =  fileIn.read())!=-1) {
            System.out.print((char)word);
        }
        //close方法会抛出IOException
        fileIn.close();
    }

    public void testException(int a) {
        if (0 != a) {
            throw new ArithmeticException("变量a居然不是0");
        }
    }
}
