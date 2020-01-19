package assertlearning;

public class test1 {

    public static void main(String[] args) {
        /* 这个成员变量的值可以变，但最终必须还是回到原值5 */
        int i = 5;
        assert (i == 6);
        System.out.println("如果断言正常，我就被打印");
    }
}
