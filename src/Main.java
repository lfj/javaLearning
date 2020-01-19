import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        float f1 = 3.4F;
        float f2 = (float) 3.4;

        /* 自动装箱 */
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较

        Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        System.out.println(i1.equals(i2));
        System.out.println(i3.equals(i4));

        Integer i5 = new Integer(100);
        Integer i6 = Integer.valueOf(100);
        Integer i7 = new Integer(i5);

        System.out.println(i5 == i6);
        System.out.println(i5 == i7);
        System.out.println(i6 == i7);

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

        Collections.emptyList();
    }
}
