package longlearn;

public class Test {
    public static void main(String[] args) {
        Long a = 100L;
        Long b = 100L;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == 100);
        System.out.println(a.equals(100L));
        System.out.println(a.equals(100));

        Long c = 125L;
        Long d = 125L;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c == 125);
        System.out.println(c.equals(125L));
        System.out.println(c.equals(125));

        Long e = 130L;
        Long f = 130L;
        System.out.println(0 == Long.compare(e, f));
    }
}
